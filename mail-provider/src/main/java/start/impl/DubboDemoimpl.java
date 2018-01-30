package start.impl;

        import org.apache.zookeeper.ZooKeeper;
        import org.springframework.stereotype.Service;
        import test.service.DubboDemo;

/**
 * Created by zhangmin on 2017/10/13.
 */

@Service("dubboDemo")
public class DubboDemoimpl implements DubboDemo {



    @Override
    public String doSave() {
        return "stary hungry,stary folish";
    }

    @Override
    public String getTestRedis() {
        String redisString = "helloWorld";

        return redisString;
    }
}
