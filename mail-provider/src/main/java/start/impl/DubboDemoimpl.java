package start.impl;

        import org.apache.zookeeper.ZooKeeper;
        import org.springframework.cache.annotation.Cacheable;
        import org.springframework.stereotype.Service;
        import test.service.DubboDemo;

/**
 * Created by zhangmin on 2017/10/13.
 */

@Service("dubboDemo")
public class DubboDemoimpl implements DubboDemo {



    @Cacheable
    @Override
    public String doSave() {
        return "stary hungry,stary folish";
    }

    @Override
    public String getTestRedis() {
        String redisString = "hello zhang";
        return redisString;
    }
}
