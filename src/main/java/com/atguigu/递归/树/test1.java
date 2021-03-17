package com.atguigu.递归.树;

import javax.xml.ws.soap.Addressing;
import java.util.*;

public class test1
{



    public int numTrees(int n) {
        return 0;
    }

//    public boolean isValidSerialization(String preorder) {
//
//    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = insertionSortList(head.next);

        ListNode pre = new ListNode(0,cur);
        ListNode preHead = pre;
        while (cur != null){
            if (head.val > cur.val){
                cur = cur.next;
                pre = pre.next;
            }else {
                break;
            }
        }
        pre.next = head;
        pre.next.next = cur;
        return preHead.next;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        if (root.val < low){
            return right;
        }else if (root.val > high){
            return left;
        }else {
            return root.val + left + right;
        }


    }



    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new test1().isPalindrome(s);
        System.out.println(palindrome);
    }




    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs4(root,res);
        return res;
    }

    private void dfs4(TreeNode root, List<Integer> res) {
        if (root == null) return;

        dfs4(root.left,res);
        dfs4(root.right,res);
        res.add(root.val);
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            //先获取有效的字母
            if (Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        int l = 0,r = sb.length() - 1;
        while (l < r){
            //双指针判断，都转换为小写来判断
            if (Character.toLowerCase(sb.charAt(l)) != Character.toLowerCase(sb.charAt(r))){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = temp;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        dfs3(res,path,root,targetSum);
        return res;
    }

    private void dfs3(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum) {
        //终止条件1
        if (root == null) return;
        targetSum -= root.val;
        //终止条件2
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        dfs3(res,path,root.left,targetSum);
        dfs3(res,path,root.right,targetSum);
        path.remove(path.size() - 1);
    }

    private boolean res;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs2(root,targetSum);
        return res;
    }

    private void dfs2(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                res = true;
            }
            return;
        }
        targetSum -= root.val;
        dfs2(root.left,targetSum);
        dfs2(root.right,targetSum);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;


    }



    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs1(nums,0,nums.length - 1);
    }

    private TreeNode dfs1(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs1(nums,left,mid - 1);
        root.right = dfs1(nums,mid + 1,right);
        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;


        Queue<TreeNode> q = new ArrayDeque<>();
        int count = 0;
        q.add(root);
        while (!q.isEmpty()){
            count ++;
            List<Integer> path = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                path.add(poll.val);
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            res.add(0,new ArrayList<>(path));
        }
        return res;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (root.val == inorder[i]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,preorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }


        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right  = maxDepth(root.right);

        return Math.max(left,right) + 1;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;


        Queue<TreeNode> q = new ArrayDeque<>();
        int count = 0;
        q.add(root);
        while (!q.isEmpty()){
            count ++;
            List<Integer> path = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                path.add(poll.val);
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            if (count % 2 != 0){
                res.add(new ArrayList<>(path));
            }else {
                Collections.reverse(path);
                res.add(new ArrayList<>(path));
            }
        }
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return isduicheng(root,root);
    }

    private boolean isduicheng(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isduicheng(p.left,q.right) && isduicheng(p.right,q.left) && p.val == q.val;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val < pre){
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;

    }

    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int k = 0;
        if (nums[0] != nums[1]) res[k++] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]){
                res[k++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) res[k ++] = nums[nums.length - 1];

        return res;
    }

    class node1{
        public node1(boolean isbalan, int depth) {
            this.isbalan = isbalan;
            this.depth = depth;
        }

        boolean isbalan;
        int depth;

    }

    public boolean isBalanced(TreeNode root) {
        return isBa(root).isbalan;
    }

    private node1 isBa(TreeNode root){
        if (root == null){
            return new node1(true,0);
        }

        node1 left = isBa(root.left);
        node1 right = isBa(root.right);
        if (!left.isbalan || !right.isbalan){
            return new node1(false,0);
        }

        boolean res = Math.abs(left.depth - right.depth) <= 1;
        if (!res) return new node1(false,0);
        int depth = Math.max(left.depth,right.depth);
        return new node1(true,depth);
    }







}


