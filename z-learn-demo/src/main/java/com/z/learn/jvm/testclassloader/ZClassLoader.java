package com.z.learn.jvm.testclassloader;

import java.io.IOException;

public class ZClassLoader extends ClassLoader {


    private String classpath;

    public ZClassLoader(String classpath) {
        this.classpath = classpath;
    }

    /**
     * ClassLoader 重写findClass 即可
     *
     * @param name 类的全限定名称
     * @return Class对象3
     * @author zhaoxu
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        try {
            byte[] classData = getData(name);
            if (classData != null) {
                //defineClass方法将字节码转化为类
                return defineClass(name, classData, 0, classData.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return super.findClass(name);
    }

    //加载类的字节码数据
    private byte[] getData(String className) throws IOException {
        //读取类文件的字节
        return null;
    }


}
