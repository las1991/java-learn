package com.las.learn.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.DebuggingClassWriter;
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
        BookService bookService = JdkProxy.getProxy(new BookServiceImpl());
        bookService.addBook(new Book(2L, "算法导论"));
        Book book = bookService.getBook(2L);
        log.info("{}", book);
        log.info("bookService: {}", bookService.getClass());
    }

    /**
     *
     */
    @Test
    public void testCglibProxy() {
        String location = ProxyTest.class.getResource("").getPath();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, location);

        BookService bookService = CglibProxy.getProxy(new BookServiceImpl());
        bookService.addBook(new Book(2L, "算法导论"));
        Book book = bookService.getBook(2L);
        log.info("{}", book);
        log.info("bookService: {}", bookService.getClass());
    }

}