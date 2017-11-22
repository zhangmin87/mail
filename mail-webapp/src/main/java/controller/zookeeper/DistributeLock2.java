package controller.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhongdepeng on 2017/11/20.
 */
public class DistributeLock2 implements Watcher{

    private int threadId;
    private ZooKeeper zk = null;
    private String selfPath;
    private String waitPath;
    private String LOG_PREFIX_OF_THREAD;
    private static final int SESSION_TIME0UT = 10000;
    private static final String GROUP_PATH = "/disLocks";
    private static final String SUB_PATH = "/disLocks/sub";
    private static final String CONNECTION_STRING = "192.168.*.*:2181";

    private static final int THREAD_NUM = 10;
    //确保连接zk 成功
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);
    //确保所有线程运行结束
    private static final CountDownLatch threadSemaphore = new CountDownLatch(THREAD_NUM);
    public DistributeLock2 (int id) {
        this.threadId = id;
        System.out.println("第"+threadId+"线程");
    }

//    public static void main(String[] args) {
//        for(int i=0;i<THREAD_NUM;i++) {
//            final int threadId = i+1;
//            new Thread(){
//                @Override
//                public void run() {
//                    DistributeLock2 dis = new DistributeLock2(threadId);
//                    dis.createConnection(CONNECTION_STRING, SESSION_TIME0UT);
//                }
//            };
//        }
//    }

    /**
     * 创建连接
     *
     * @param connectString ZK服务器地址列表
     * @param sessionTimeout 超时时间
     * @throws IOException
     * @throws InterruptedException
     */
    public void createConnection(String connectString,int sessionTimeout) throws IOException,InterruptedException{
        zk = new ZooKeeper(connectString,sessionTimeout,this);
        connectedSemaphore.await();
    }

    public void getLockSuccess() throws KeeperException, InterruptedException {
        if (zk.exists(this.selfPath,false) == null) {
            System.out.println(LOG_PREFIX_OF_THREAD+"本节点已不存在");
            return;
        }
        System.out.println(LOG_PREFIX_OF_THREAD+"获取锁成功,赶紧干活!");
        Thread.sleep(2000);
        System.out.println(LOG_PREFIX_OF_THREAD+"删除本节点"+selfPath);
        zk.delete(this.selfPath,-1);
    }

    /**
     * 关闭连接
     */
    public void releaseConnection() {
        if (this.zk != null) {
            try {
                this.zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LOG_PREFIX_OF_THREAD+"释放连接");
        }
    }

    public boolean checkMinPath() throws KeeperException, InterruptedException {
        List<String> subNodes = zk.getChildren(GROUP_PATH,false);
        Collections.sort(subNodes);
        int index = subNodes.indexOf(selfPath.substring(GROUP_PATH.length()+1));
        switch (index) {
            case -1:{
                System.out.println(LOG_PREFIX_OF_THREAD+"本节点已不存在.."+selfPath);
                return false;
            }
            case 0: {
                System.out.println(LOG_PREFIX_OF_THREAD+"子节点中，我果然是老大"+selfPath);
            }
            default:{
                this.waitPath = GROUP_PATH +"/"+ subNodes.get(index - 1);
                System.out.println(LOG_PREFIX_OF_THREAD+"获取节点，排在我前面的"+waitPath);
                try {
                    zk.getData(waitPath,true,new Stat());
                    return false;
                }catch (KeeperException E){
                    if (zk.exists(waitPath,false) == null) {
                        System.out.println(LOG_PREFIX_OF_THREAD+"子节点中，排在我前面的"+waitPath+"已经失踪，幸福来的太突然");
                        return checkMinPath();
                    }else {
                        throw E;
                    }
                }

            }
        }
    }


    @Override
    public void process(WatchedEvent event) {

    }
}
