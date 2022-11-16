package com.z.alg.stack.lc20;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Map<String,String> baseMap  = new HashMap<String,String>();
        baseMap.put("(",")");
        baseMap.put("[","]");
        baseMap.put("{","}");
        String[] words = s.split("");
        Stack<String> stack = new Stack<String>();

        for(String word : words) {
            if (!stack.isEmpty()) {
                String top = stack.peek();
                if (word.equals(baseMap.get(top))){
                    stack.pop();
                }else {
                    stack.push(word);
                }
            }else {
                stack.push(word);
            }
        }

        return stack.isEmpty();
    }
}