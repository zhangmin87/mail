package redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by zhangmin on 2018/1/25.
 */
public class BaseDao {
    protected RedisTemplate<String,Object> redisTemplate;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "redisTemplate")
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
