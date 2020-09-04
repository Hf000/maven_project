package com.hufei.test;

import com.hufei.myrpc.client.MyRpcClient;
import org.junit.Test;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:rpc客户端测试
 */
public class TestRpcClient {

    @Test
    public void testClient() {
        MyRpcClient client = new MyRpcClient();
        client.start("127.0.0.1", 9527);
    }

}
