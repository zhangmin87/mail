package start.impl;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import test.service.DubboDemo;

import java.security.acl.LastOwnerException;

/**
 * Created by zhangmin on 2017/10/13.
 */

@Service("dubboDemo")
public class DubboDemoimpl implements DubboDemo {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String doSave() {
        return "stary hungry,stary folish";
    }

    @Cacheable(value = "user",condition = "")
    @Override
    public String getTestRedis() {
        logger.info("缓存失效,从数据库中取出来");
        String redisString = "hello zhang";
        return redisString;
    }
}
