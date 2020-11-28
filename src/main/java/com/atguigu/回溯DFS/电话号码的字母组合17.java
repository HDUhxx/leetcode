package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 电话号码的字母组合17
{
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
            return  res;
        }

//        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        
        backtrack(digits,0,hashMap,sb,res);
        
        return res;
    }

    private void backtrack(String digits, int i,HashMap<Character,String> map,StringBuilder sb,List<String> res)
    {
        if (i == digits.length()){
            res.add(sb.toString());
            return;
        }

        //String s = map[digits.charAt(i) - '2'];
        String s = map.get(digits.charAt(i));
        for (char c : s.toCharArray()){
            sb.append(c);
            backtrack(digits,i + 1,map,sb,res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
