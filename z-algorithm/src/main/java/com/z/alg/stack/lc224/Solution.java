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
        //init ops
        Map<String, Integer> opLevelMap = initOpLevelMap();
        String opZuoKuo = "(";
        String opYouKuo = ")";
        //init
        //输出队列
        Deque<String> outputQueue = new ArrayDeque<>();
        //op栈
        Deque<String> opStack = new ArrayDeque<>();

        //处理空格
        //convert to charArr
        String strWithNoSpace = s.replace(" ","");
        //处理左括号和-号之间的补0
        strWithNoSpace = strWithNoSpace.replace("(-","(0-");
        //处理首字符为-号时,前面需要补0
        if (strWithNoSpace.startsWith("-")){
            strWithNoSpace = "0".concat(strWithNoSpace);
        }
        //to char arr
        char[] charArr = strWithNoSpace.toCharArray();
        int charArrSize = charArr.length ;
        //init end






        //开始转换为后缀表达式

        //1. 数字入队
        //2. 符号入栈,当待入栈符号的级别<=栈顶符号时,全部出栈加入队列,否则继续入栈
        //3. 如果是括号,左括号直接入栈,直到右括号
        for (int i = 0; i < charArrSize; i++) {
            char chi = charArr[i];
            String chiStr = String.valueOf(charArr[i]);
            //遇见左括号,入符号栈
            if(opZuoKuo.equals(chiStr)){
                opStack.push(chiStr);
            }else if(opYouKuo.equals(chiStr)){
                //遇见右括号,开始出栈
                while(!opStack.isEmpty()&&!opZuoKuo.equals(opStack.peek())) {
                   outputQueue.addLast(opStack.pop());
                }
                //左括号出栈
                opStack.pop();
            }else{
                //完整的取数字,加入
                if(isNum(chi)) {
                    //学习小循环手法,复制循环元素i进行循环
                    int n = 0;
                    int j = i;
                    while(j<charArrSize && isNum(charArr[j])) {
                        //convert char to int - '0'即可,如果你看不懂,code it
                        n = n *10 + (charArr[j++]-'0');
                    }
                    //添加到输出deque中
                    outputQueue.addLast(String.valueOf(n));
                    //此时i需要前进,
                    //i还要++,so - 1
                    i=j-1;


                }else{
                    //处理符号
                    //考虑空栈情况,空栈直接入栈
                    if(opStack.isEmpty()){
                        opStack.push(chiStr);
                    }else{
                        //看栈顶
                        int topStackLevel  = opLevelMap.get(opStack.peek());
                        //入栈级别
                        int pushOpLevel = opLevelMap.get(chiStr);
                        while (!opStack.isEmpty()&&pushOpLevel<=topStackLevel) {
                            String top = opStack.pop();
                            outputQueue.addLast(top);
                            if (!opStack.isEmpty()) {
                                topStackLevel =opLevelMap.get(opStack.peek());
                            }else{
                                break;
                            }
                        }
                        opStack.push(chiStr);

                    }

                }



            }

        }

        //final output all
        while(!opStack.isEmpty()){
            outputQueue.addLast(opStack.pop());
        }


        String[] houzhui = outputQueue.toArray(new String[0]);



        //输出String[]数组,供后缀表达式计算器计算

        return evalRPN(houzhui);
    }


    private static Map<String, Integer> initOpLevelMap() {
        //init阶段:初始化符号
        //等级1: ^
        //等级2: * , /
        //等级3: + , -
        String opChengFang = "^";

        String opCheng = "*";
        String opChu = "/";

        String opPlus = "+";
        String opJian = "-";

        String opZuoKuo = "(";
        String opYouKuo = ")";


        Map<String,Integer> opMapLevel = new HashMap<>();
        opMapLevel.put(opChengFang,3);

        opMapLevel.put(opCheng,2);
        opMapLevel.put(opChu,2);

        opMapLevel.put(opPlus,1);
        opMapLevel.put(opJian,1);

        opMapLevel.put(opZuoKuo,0);

        return opMapLevel;
    }


    boolean isNum(char c) {
        return Character.isDigit(c);
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



    public static void main(String[] args) {
        Solution obj = new Solution();
        String input = "-2+ 1";

        int result = obj.calculate(input);
        System.out.println(result);

    }




}
//leetcode submit region end(Prohibit modification and deletion)
