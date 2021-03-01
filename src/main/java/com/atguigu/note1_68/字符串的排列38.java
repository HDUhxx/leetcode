package com.atguigu.note1_68;

import java.util.ArrayList;
import java.util.List;

public class 字符串的排列38
{
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null ||s.length() == 0){
            return new String[]{};
        }

        char[] strs = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        dfs(res,sb,strs,0);
        String result [] = new String[res.size()];
        int k = 0;
        for (String string : res){
            result[k ++ ] = string;
        }
        return result;
    }

    private void dfs(List<String> res, StringBuilder sb, char[] strs,int i)
    {
        if (strs.length == sb.length()){
            res.add(sb.toString());
            return;
        }

        sb.append(strs[i]);
        
        dfs(res,sb,strs,i + 1);
        sb.deleteCharAt(sb.length() - 1);
    }


}
