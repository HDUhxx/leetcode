package com.atguigu.递归.树;




public class 平衡二叉树110
{
    class ReturnNode{
        boolean isB;
        int depth;

        public ReturnNode(boolean isB, int depth)
        {
            this.isB = isB;
            this.depth = depth;
        }
    }

    public ReturnNode isBa(TreeNode root){
        if (root == null){
            return new ReturnNode(true,0);
        }

        ReturnNode left = isBa(root.left);
        ReturnNode right = isBa(root.right);
        if (left.isB == false || right.isB == false){
            return new ReturnNode(false,0);
        }

        if (Math.abs(left.depth - right.depth) > 1){
            return new ReturnNode(false,0);
        }

        return new ReturnNode(true,Math.max(left.depth,right.depth) + 1);
    }

    public boolean isBalance(TreeNode root){
        return isBa(root).isB;
    }
}



//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//}
