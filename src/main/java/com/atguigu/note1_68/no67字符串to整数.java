package com.atguigu.note1_68;

public class no67字符串to整数 {

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int res = 0,bndry = Integer.MAX_VALUE;
        int i = 1,sign = 1;
        if (chars[0] == '-'){
            sign = -1;
        }else if (chars[0] != '+'){
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0')break;
            int temp = res * 10 + (chars[j] - '0');
            if (temp / 10 != res) return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = temp;
        }

        return res;
    }

}
