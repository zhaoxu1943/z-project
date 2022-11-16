package com.z.alg.stack.lc20;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * stack ?
 * stack relation problem:
 *
 * 最近相关性问题,用栈
 *
 * 本题 lc20,并不是中心对称的括号,而是一个个闭合括号组成
 *
 * 当然中心括号也是可以的
 *
 *
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
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

    public static void main(String[] args) {
        String s = "}}{{{";
        Solution solution = new Solution();
        solution.isValid(s);

        String s1 = "{([])}";
        solution.isValid(s1);


    }
}