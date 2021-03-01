package com.atguigu.回溯DFS;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class 括号生成22
{
    public static void main(String[] args)
    {

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }

        dfs("",n,n,res);
        return res;
    }

    private void dfs(String s, int left, int right, List<String> res)
    {
        //注意：因为每一次尝试，都使用新的字符串变量，所以不需要回溯
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }

        if (left > right){
            return;
        }

        if (left > 0){

            dfs(s + "(",left - 1,right,res);
            //或者
            /*path.append("(");
            dfs(path, left - 1, right, res);
            path.deleteCharAt(path.length() - 1);*/


        }

        if (right > 0){
            dfs(s+")",left,right - 1,res);
        }
    }
}
