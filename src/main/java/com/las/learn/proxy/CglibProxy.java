package com.las.learn.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther: liansheng
 * @Date: 2020/3/10 21:47
 * @Description:
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {
    private Object target;//需要代理的目标对象

    public CglibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Cglib动态代理，监听开始！");
        Object invoke = method.invoke(target, objects);//方法执行，参数：target 目标对象 arr参数数组
        log.info("Cglib动态代理，监听结束！");
        return invoke;
    }

    public static Object getProxy(Object targetObject) {
        log.info("{}",targetObject.getClass());
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(new CglibProxy(targetObject));// 设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }
}
