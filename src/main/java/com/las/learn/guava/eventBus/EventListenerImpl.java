package com.las.learn.guava.eventBus;

/**
 * @author las
 * @date 18-11-14
 */
public class EventListenerImpl implements EventListener {
    public int lastMessage = 0;

    public void onEvent(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
