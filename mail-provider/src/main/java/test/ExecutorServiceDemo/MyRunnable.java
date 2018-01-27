package test.ExecutorServiceDemo;

/**
 * Created by Administrator on 2018/1/19.
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<2;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
