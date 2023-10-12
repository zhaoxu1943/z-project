package com.z.learn.jvm.testclassloader;

/**
 * 一个普通的类,用于测试自定义的类加载器
 * 经过javac Test.java编译后,生成Test.class字节码文件
 * @author zhaoxu
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("hello classloader");
    }
}
