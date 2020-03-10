package com.las.learn.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther: liansheng
 * @Date: 2020/3/10 21:29
 * @Description:
 */
@Slf4j
public class JdkProxy implements InvocationHandler {
    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        log.info("JDK动态代理，监听开始！");
        Object result = method.invoke(target, objects);
        log.info("JDK动态代理，监听结束！");
        return result;
    }

    public static Object getProxy(Object targetObject) {
        log.info("{}",targetObject.getClass());
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), new JdkProxy(targetObject));
    }
}
