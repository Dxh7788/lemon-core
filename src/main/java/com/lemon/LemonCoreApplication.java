package com.lemon;

import com.fdubbo.rpc.LogService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by lemon-core
 *
 * @author xh.d
 * @since 2018/6/25 15:08
 */
public class LemonCoreApplication{

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"/dubbo/dubbo-lemon-consumer.xml"});
        context.start();
//        ExtensionLoader<Protocol> refprotocol = ExtensionLoader.getExtensionLoader(Protocol.class);
//        Protocol protocol = refprotocol.getAdaptiveExtension();

        // obtain proxy object for remote invocation
        LogService logService = (LogService) context.getBean("logService");
        // execute remote invocation
        logService.showVersion("world");
    }
}
