package com.atguigu.Tencent;

public class no14最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        String res = "";
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if (ans.equals("")) return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);

    }
}
