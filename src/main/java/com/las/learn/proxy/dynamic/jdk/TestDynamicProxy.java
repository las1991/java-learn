package com.las.learn.proxy.dynamic.jdk;

import com.las.learn.proxy.Book;
import com.las.learn.proxy.BookService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestDynamicProxy.class);


    @Test
    public void testProxy() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LOGGER.info("proxy:{}", proxy);
                LOGGER.info("method:{}", method);
                if (null != args) {
                    for (Object obj : args) {
                        LOGGER.info("args : {}", obj);
                    }
                }
                return null;
            }
        };

        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(),
                new Class[]{BookService.class}, handler);

        Boolean success = bookService.addBook(new Book(1l, "java"));

    }
}
