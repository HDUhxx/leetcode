package com.atguigu.递归.树;

import java.util.ArrayList;
import java.util.List;

public class 剑指34树和为sum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return null;

        List<Integer> path = new ArrayList<>();
        dfs(res,path,root,sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null ){
            return;
        }


        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs(res,path,root.left,sum);
        dfs(res,path,root.right,sum);
        path.remove(path.size() - 1);
    }
}
