package com.lemon.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by lemon-core
 *
 * @author xh.d
 * @since 2018/7/4 12:59
 */
@Activate(group = Constants.CONSUMER)
public class LemonFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();
        //这个是RPC的实现体，Result就是RPC的执行结果，和Servlet的过滤器有些类似
        Result result = invoker.invoke(invocation);
        System.out.println("time = " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("hello world!!!");
        System.out.println(result.getValue());
        return result;
    }
}
