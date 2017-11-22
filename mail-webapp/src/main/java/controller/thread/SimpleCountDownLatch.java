package controller.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhongdepeng on 2017/11/22.
 */
public class SimpleCountDownLatch {

    /**
     * 计数器，用来控制线程
     */
    private final static CountDownLatch mCoutDownLatch = new CountDownLatch(2);


    /**
     * 示例工作线程类
     */
    private static class WorkingThread extends Thread {
        private final String mThreadName;
        private final int mSleepTime;
        public WorkingThread (String name,int sleepTime) {
            mThreadName = name;
            mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("["+mThreadName+"] started!");
            try {
                Thread.sleep(mSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mCoutDownLatch.countDown();
            System.out.println("["+mThreadName+"] end!");
        }
    }

    /**
     * 示例线程类
     */
    private static class SampleThread extends Thread {
        @Override
        public void run() {
            System.out.println("[SampleThread] start");
            try {
                //会堵塞在这里等待mCountDownLatch里的count变W为0
                //也就是等待另外的workingThread调用countDown()
                mCoutDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mCoutDownLatch.getCount());
            System.out.println("[SampleThread] end");
        }
    }

    /**
     * 开始
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //最先run SampleThread
        new SampleThread().start();
        //运行两个工作线程
        //工作线程1运行5秒
        new WorkingThread("workingThread1",5000).start();
        //工作线程2y运行2秒
        new WorkingThread("workingThread2",2000).start();
    }
}
