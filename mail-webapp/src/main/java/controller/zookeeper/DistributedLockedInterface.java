package controller.zookeeper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/6/12.
 */
public interface DistributedLockedInterface {

    /**
     * 获取锁，如果没有得到锁就一直等待
     * @throws Exception
     */
    public void acquire() throws Exception;

    public boolean acquire(long time, TimeUnit unit) throws Exception;

    public void release() throws Exception;
}
