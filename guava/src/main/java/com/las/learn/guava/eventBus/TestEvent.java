package com.las.learn.guava.eventBus;

/**
 * @author las
 * @date 18-11-14
 */
public class TestEvent {
    private final int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}
