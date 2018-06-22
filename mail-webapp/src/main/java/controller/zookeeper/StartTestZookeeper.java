package controller.zookeeper;

/**
 * Created by zhongdepeng on 2017/11/21.
 */
public class StartTestZookeeper {

    public static void main(String[] args) {

        DistributedLock3 distributedLock3 = new DistributedLock3("127.0.0.1:2181","name");

        distributedLock3.lock();

//共享资源
//        if (distributedLock3 !=null) {
//            distributedLock3.unlock();
//        }
    }

            }
