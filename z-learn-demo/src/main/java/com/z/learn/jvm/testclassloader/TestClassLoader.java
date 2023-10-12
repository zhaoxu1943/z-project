package com.z.learn.jvm.testclassloader;

public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {

        //首先定义类加载器的加载路径,即classPath,class文件位于该路径下
        ZClassLoader zClassLoader = new ZClassLoader("D://");

        //再使用loadClass方法,将类的全限定名称传入,即可加载该类,返回值为class对象
        Class clazz = zClassLoader.loadClass("com.z.trace.model.enums.SortParameter");

        //然后正常使用class对象即可
    }
}
