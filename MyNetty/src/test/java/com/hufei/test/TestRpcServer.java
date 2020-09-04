package com.hufei.test;

import com.hufei.myrpc.server.MyRpcServer;
import org.junit.Test;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:测试
 */
public class TestRpcServer {

    @Test
    public void testServer() {
        MyRpcServer myRpcServer = new MyRpcServer();
        myRpcServer.start(9527);
    }

}
