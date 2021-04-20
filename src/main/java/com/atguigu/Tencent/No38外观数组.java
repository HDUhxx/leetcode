package com.atguigu.Tencent;

public class No38外观数组 {

    /**
     *      1211
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int start = 0;//记录起始位置
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)){
                sb.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        sb.append(s.length() - start).append(s.charAt(s.length() - 1));
        return sb.toString();
    }
}
