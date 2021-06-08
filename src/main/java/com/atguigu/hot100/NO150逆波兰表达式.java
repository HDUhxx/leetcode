package com.atguigu.hot100;

import java.util.Stack;

public class NO150逆波兰表达式 {
    public static void main(String[] args) {
        String[] arr = {"2","1","+","3","*"};
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens){
            if (isNumber(s)){
                nums.push(Integer.parseInt(s));
            }else {
                int b = nums.pop();
                int a = nums.pop();
                int res = 0;
                if ("+".equals(s)){
                    res = a + b;
                }else if ("-".equals(s)){
                    res = a - b;
                }else if ("*".equals(s)){
                    res = a * b;
                }else if ("/".equals(s)){
                    res = a / b;
                }
                nums.push(res);
            }
        }
        return nums.pop();
    }

    private static boolean isNumber(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
