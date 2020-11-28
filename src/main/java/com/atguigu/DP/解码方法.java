package com.atguigu.DP;

public class 解码方法
{

    //no.91再想想
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++)
        {
            int n1 = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
            int n2 = Integer.parseInt(String.valueOf(s.charAt(i - 2)));

            if (n1 == 0 && (n2 == 0 || n2 > 2)){
                return 0;
            }else if (n1 == 0){
                dp[i] = dp[i - 2];
            }

            if ( n2 == 0){
                dp[i] = dp[i - 1];
            }
            if (n2 > 2 && n1 > 6){
                dp[i] = dp[i - 1];
            }
            if (n1 != 0 && n2 > 0 && n2 <3){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        for(int i=2;i<=s.length();i++){
            int num = Integer.parseInt(String.valueOf(s.charAt(i-1)));//得到当前数；
            int nums2 = Integer.parseInt(String.valueOf(s.charAt(i-2)));//得到当前数的前一个数
            if (nums2+num==0||(num==0&&nums2>2)){
                return 0;
            }else if(num==0||nums2==0){
                dp[i] = num==0?dp[i-2]:dp[i-1];
            }else{
                dp[i] = nums2*10+num>26?dp[i-1]:dp[i-2]+dp[i-1];
            }

        }

        return dp[chars.length];
    }
}
