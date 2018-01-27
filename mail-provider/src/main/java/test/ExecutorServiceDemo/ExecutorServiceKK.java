package test.ExecutorServiceDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/19.
 */
public class ExecutorServiceKK {
    public static void main(String[] args) {
        //创建一个线程池对象,控制要创建几个线程对象
        ExecutorService pool = Executors.newFixedThreadPool(1);
        //可以执行Runnalbe 对象 或者 Callable 对想代表线程
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
    }
}

