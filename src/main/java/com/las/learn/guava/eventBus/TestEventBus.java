package com.las.learn.guava.eventBus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * @author las
 * @date 18-11-14
 */
public class TestEventBus {

    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListenerImpl listener = new EventListenerImpl();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));


        System.out.println("LastMessage:" + listener.getLastMessage());
    }
}
