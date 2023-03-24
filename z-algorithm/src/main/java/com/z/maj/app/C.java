package com.z.maj.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class C {

    public static void main(String[] args) {
        // 创建目录
        File directory = new File("myDirectorydd");
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                System.out.println("Failed to create directory");
                return;
            }
        }

        // 创建文件
        File file = new File(directory, "myFile.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, World!111");
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to create file: " + e.getMessage());
        }
    }
}
