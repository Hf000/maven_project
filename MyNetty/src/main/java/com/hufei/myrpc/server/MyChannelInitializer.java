package com.hufei.myrpc.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //将业务处理器加入到列表中
        socketChannel.pipeline().addLast(new MyChannelHandler());//这里可以接着调用 addLast(), 将需要处理的业务都加入进来
    }
}
