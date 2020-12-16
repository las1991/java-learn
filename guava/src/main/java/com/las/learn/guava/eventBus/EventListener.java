package com.las.learn.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author las
 * @date 18-11-16
 */
public interface EventListener {
    @Subscribe
    void onEvent(TestEvent object);
}
