package com.hufei.myrpc.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:rpc服务
 */
public class MyRpcServer {

    public void start(int port) {
        EventLoopGroup boss = null;
        EventLoopGroup worker = null;
        try {
            boss = new NioEventLoopGroup(1); //创建主线程, 不处理任何业务, 只负责客户端连接
            worker = new NioEventLoopGroup(); //创建工作线程,  默认是CPU核数*2
            ServerBootstrap serverBootstrap = new ServerBootstrap();//服务器启动类
            serverBootstrap.group(boss, worker)         //设置工作线程组
                    .channel(NioServerSocketChannel.class)  //配置server通道
                    .childHandler(new MyChannelInitializer());//设置worker线程的处理器
            ChannelFuture future = serverBootstrap.bind(port).sync();//绑定端口
            future.channel().closeFuture().sync();//等待服务端监听端口关闭
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (boss != null) boss.shutdownGracefully();  //关闭主线程
            if (worker != null) worker.shutdownGracefully(); //关闭工作线程
        }
    }

}
