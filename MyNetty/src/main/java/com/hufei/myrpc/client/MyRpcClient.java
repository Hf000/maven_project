package com.hufei.myrpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:rpc客户端
 */
public class MyRpcClient {

    public void start(String host, int port) {
        EventLoopGroup worker = null;
        try {
            worker = new NioEventLoopGroup();//创建工作线程组
            Bootstrap bootstrap = new Bootstrap(); //开启client客户端
            bootstrap.group(worker)                         //设置工作线程组
                    .channel(NioSocketChannel.class)        //设置socket通道
                    .handler(new MyClientHandler());        //设置业务处理handler
            ChannelFuture future = bootstrap.connect(host, port).sync();//建立远程连接
            future.channel().closeFuture().sync(); //关闭连接
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (worker != null) worker.shutdownGracefully();//关闭工作线程
        }
    }

}
