package com.atguigu.递归;

public class 第N行第K个元素779
{
    public int kthGrammar(int N, int K) {
        if (N == 1){
            return 0;
        }

        int i = kthGrammar(N - 1, (K + 1) / 2);

        return 0;
    }

}
