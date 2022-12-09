package com.z.alg.stack.lc224;

/**
 * @author zhaoxu
 * @date 12/8/2022 4:42 PM
 * @since
 */
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
//
//
//
// 示例 1：
//
//
//输入：s = "1 + 1"
//输出：2
//
//
// 示例 2：
//
//
//输入：s = " 2-1 + 2 "
//输出：3
//
//
// 示例 3：
//
//
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
// 输入中不存在两个连续的操作符
// 每个数字和运行的计算将适合于一个有符号的 32位 整数
//
//
// Related Topics 栈 递归 数学 字符串 👍 858 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //基本计算器
    //思路:调度场算法将中缀转后缀-->再基于后缀表达式运算求值
    public int calculate(String s) {
        //step1 : 字符串的解析,我们看到支持的符号有'+'、'-'、'('、')',以及space
        String opChengFang = "^";

        String opCheng = "*";
        String opChu = "/";

        String opPlus = "+";
        String opJian = "-";

        //special
        String opZuoKuo = "(";
        String opYouKuo = ")";
        String opSpace = " ";


        Map<String,Integer> opMap = new HashMap<>();
        opMap.put(opChengFang,1);

        opMap.put(opCheng,2);
        opMap.put(opChu,2);

        opMap.put(opPlus,3);
        opMap.put(opJian,3);

        opMap.put(opZuoKuo,4);
        opMap.put(opYouKuo,4);
        opMap.put(opSpace,5);

        //step2 : 中转后:调度场算法
        //等级1: ^
        //等级2: * , /
        //等级3: +

        //init
        //1. 数字入队
        //2. 符号入栈,当待入栈符号的级别<=栈顶符号时,全部出栈加入队列,否则继续入栈
        //3. 如果是括号,左括号直接入栈,直到右括号

        Queue<String> outputQueue = new LinkedList<>();

        //convert
        String[]  originArr = s.split("");
        for(String c :originArr) {


        }




        //输出String[]数组,供后缀表达式计算器计算

        return 0;
    }






    public int evalRPN(String[] tokens) {
        //operator set
        Set<String> operatorSet = new HashSet<>(Arrays.asList("+","-","*","/"));
        Stack<Integer> calStack = new Stack<>();
        for (String str :tokens) {
            if (!calStack.isEmpty() && calStack.size() >=2 &&operatorSet.contains(str)) {
                //sec
                int num1 = calStack.pop();
                //first
                int num2 = calStack.pop();
                if ("+".equals(str)){
                    calStack.push(Math.addExact(num1,num2));
                }else if ("-".equals(str)){
                    calStack.push(Math.subtractExact(num2,num1));
                }else if("*".equals(str)){
                    int temp = num2*num1;
                    calStack.push(temp);
                }else{
                    int temp = num2/num1;
                    calStack.push(temp);
                }
            }else {
                calStack.add(Integer.valueOf(str));
            }

        }
        return calStack.peek();


    }

}
//leetcode submit region end(Prohibit modification and deletion)
