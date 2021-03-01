package com.atguigu.note1_68;

public class no58_1翻转单词的顺序 {


    /**
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     *  目标：删除首位的空格，中间多的空格变成一个

     * @param s
     * @return
     */
    public String reverseWords(String s) {

        String[] res = s.trim().split(" ");//删除首位空格
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0 ; i--) {
            if (res[i].equals("")) continue;//删除中间的多的空格
            sb.append(res[i]);
        }

        return sb.toString().trim();//最后还是要删掉首尾空格
    }
}
