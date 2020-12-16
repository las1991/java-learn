package com.las.learn.proxy;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
