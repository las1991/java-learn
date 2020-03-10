package com.las.learn.proxy;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @auther: liansheng
 * @Date: 2020/3/10 21:33
 * @Description:
 */
@Slf4j
public class BookServiceImpl implements BookService {
    private Map<Long, Book> map = Maps.newHashMap();

    @Override
    public Boolean addBook(Book book) {
        log.info("{}", book);
        map.put(book.getId(), book);
        return true;
    }

    @Override
    public Book getBook(Long id) {
        return map.get(id);
    }
}
