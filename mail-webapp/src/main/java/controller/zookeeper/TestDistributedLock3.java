package controller.zookeeper;

/**
 * Created by Administrator on 2018/6/13.
 */
public class TestDistributedLock3 {
    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {

            Runnable runnable = new Runnable() {
                public void run() {
                    DistributedLock3 lock = null;
                    try {
                        lock = new DistributedLock3("127.0.0.1:2181", "test1");
                        lock.lock();
                        secskill();
                        System.out.println(Thread.currentThread().getName() + "正在运行");
                    } finally {
                        if (lock != null) {
                            lock.unlock();
                        }
                    }
                }
            };

            for (int i = 0; i < 20; i++) {
                Thread t = new Thread(runnable);
                t.start();
        }
    }
    }
