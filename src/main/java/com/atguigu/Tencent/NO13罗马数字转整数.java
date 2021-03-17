package com.atguigu.Tencent;

import java.util.HashMap;
import java.util.Map;

public class NO13罗马数字转整数 {
    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char[] chars = s.toCharArray();
        int res = 0;

        for (int i = 1; i < chars.length; i++) {
            if (map.get(chars[i]) <= map.get(chars[i - 1])){
                res += map.get(chars[i]);
            }else {
                res -= map.get(chars[i]);
            }
        }

        res += map.get(chars[chars.length - 1]);
        return res;

    }
}
