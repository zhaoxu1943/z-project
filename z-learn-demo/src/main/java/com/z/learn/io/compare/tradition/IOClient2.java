package com.z.learn.io.compare.tradition;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author zhaoxu
 * @date 2022/8/30 15:56
 * @since
 */
public class IOClient2 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world2").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}