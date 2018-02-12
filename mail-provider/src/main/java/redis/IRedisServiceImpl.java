package redis;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Administrator on 2018/2/12.
 */
public class IRedisServiceImpl implements IredisService {

    /**
     * 用于查询的注解，第一次查询的时候返回该方法返回值，并向redis服务器保存数据
     * 以后的查询将不再执行方法体内的代码，而是直接查询redis服务器获取数据并返回
     * value 属性做键，key 属性则可以看作为value的子键，
     * 一个value可以有多个key 组成不同值在redis 服务器，
     * 这里再介绍一个属性是condition,用法condition= '#key<10',
     */
    @Override
    @Cacheable(value = "redis",key= "#key",condition = "#key<10")
    public String cacheable(int key) throws Exception {
        return null;
    }

    /**
     *
     * 用于更新数据库或新增数据时的注解，更新redis服务器中该value的值
     */
    @Override
    @Cacheable(value="redis",key="#key",condition="#key<10")
    public String cacheEvict(int key) throws Exception {
        return null;
    }

    /**
     * 用于删除数据库操作时的注解，删除redis数据库中该value对应的数据
     *
     */
    @Override
    @Cacheable
    public String cachePut(int key) throws Exception {
        return null;
    }
}
