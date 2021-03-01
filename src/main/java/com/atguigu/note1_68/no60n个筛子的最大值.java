package com.atguigu.note1_68;

public class no60n个筛子的最大值
{
    public static double[] dicesProbability(int n) {
        double a = 1/6d;
        int len = n * 6 - n + 1;
        double[] res = new double[len];
        if (len % 2 == 0){
            for (int i = 0; i < len / 2; i++)
            {
               res [i] = (i + 1) * Math.pow(a,n );
               res[len - i - 1] = res[i];
            }
        }else {
            for (int i = 0; i < len / 2; i++)
            {
                res [i] = (i + 1) * Math.pow(a,n - 1);
                res[len - i - 1] = res[i];
            }
            res[len/2 + 1] = (len/2  + 1) * Math.pow(a, n - 1);
        }
        return res;
    }

    public static void main(String[] args)
    {
        double[] doubles = dicesProbability(1);

        for (int i = 0; i < doubles.length; i++)
        {
            System.out.print(doubles[i]);
        }

//        double b = 0.16667;
//        double a=Math.pow(b, 2);//用数学bai方法中的dupow函数求任意数的任zhi意次幂。dao
//        System.out.println(a);//在控制zhuan台输出1.5的2次方值shu
    }
}
