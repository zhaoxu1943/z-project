package com.z.alg.stack.lc155;

/**
 * @author zhaoxu
 * @date 11/16/2022 12:34 PM
 * @since
 *///设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 实现 MinStack 类:
//
//
// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。
// void pop() 删除堆栈顶部的元素。
// int top() 获取堆栈顶部的元素。
// int getMin() 获取堆栈中的最小元素。
//
//
//
//
// 示例 1:
//
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// -2³¹ <= val <= 2³¹ - 1
// pop、top 和 getMin 操作总是在 非空栈 上调用
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次
//
//
// Related Topics 栈 设计 👍 1452 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    public MinStack() {

    }


    private Stack<Integer> mainStack = new Stack<Integer>();

    private Stack<Integer> minStack = new Stack<>();

    //前缀最小值,指的是从初始位置(一般是0),到当前位置的最小值
    //后缀同理,指的是从当前位置到最后的最小值,本题使用栈来维护前缀最小值
    //保证辅助栈的栈顶一直是 前缀最小值


    public void push(int val) {
        if (mainStack.isEmpty()){
            mainStack.push(val);
            minStack.push(val);
        }else{
            mainStack.push(val);
            minStack.push(Math.min(val,minStack.peek()));
        }


    }

    public void pop() {
        if (!mainStack.isEmpty()){
            mainStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

