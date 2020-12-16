package com.las.learn.concurrent.concurrentbook;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/9
 */
public class MultiTHread {
    public static void main(String[] args) {
        //获取java线程管理MXBean
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }
    }
}
