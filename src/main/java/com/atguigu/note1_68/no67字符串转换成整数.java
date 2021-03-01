package com.atguigu.note1_68;

public class no67字符串转换成整数 {
    public int strToInt(String str) {
        str.trim();
        if (str.substring(0,1).compareTo("0") < 0 || str.substring(0,1).compareTo("9") > 0 || str.charAt(0) != '-'){
            return 0;
        }


        return 0;
    }
}
