package com.z.learn.io.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zhaoxu
 * @date 2022/8/30 17:08
 * @since
 */
public class NettyBaseClient {
    public static void main(String[] args) {

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //对应服务端的ServerBootstrap
        Bootstrap bootstrap = new Bootstrap();

        bootstrap
                // 1.指定线程模型
                .group(workerGroup)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                // 3.IO 处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                    }
                });


        // 4.建立连接
        bootstrap.connect("juejin.cn", 80).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
            } else {
                System.err.println("连接失败!");
                //retry logic 采用指数退避的方式
            }

        });
    }

}
