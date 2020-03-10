package com.las.learn.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @auther: liansheng
 * @Date: 2020/3/10 21:31
 * @Description:
 */
@Slf4j
public class ProxyTest {

    @Test
    public void testJdkProxy() {
        BookService bookService = (BookService) JdkProxy.getProxy(new BookServiceImpl());
        bookService.addBook(new Book(2L, "算法导论"));
        Book book = bookService.getBook(2L);
        log.info("{}", book);
    }

    @Test
    public void testCglibProxy() {
        BookService bookService = (BookService) CglibProxy.getProxy(new BookServiceImpl());
        bookService.addBook(new Book(2L, "算法导论"));
        Book book = bookService.getBook(2L);
        log.info("{}", book);
    }

}