package controller.zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by Administrator on 2018/6/12.
 */
public class LockTest {
    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 3000);
        SimpleDistributedLock simple = new SimpleDistributedLock(zkClient, "/ymk");

        for (int i = 0; i < 10; i++) {
            try {
                simple.acquire();
                System.out.println("正在进行运算操作：" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                simple.release();
                System.out.println("=================\r\n");
            }
        }
    }
}
