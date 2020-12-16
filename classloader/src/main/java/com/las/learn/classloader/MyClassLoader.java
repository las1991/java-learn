package com.las.learn.classloader;

public class MyClassLoader extends ClassLoader {

    private final String name;
    private final String path;

    public MyClassLoader(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
