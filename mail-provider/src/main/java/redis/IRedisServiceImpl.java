package redis;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by Administrator on 2018/2/12.
 */

@Service("iredisService")
public class IRedisServiceImpl implements IredisService {

    /**
     * 用于查询的注解，第一次查询的时候返回该方法而是直接查询redis服务器获取数据并返回返回值，并向redis服务器保存数据
     * 以后的查询将不再执行方法体内的代码，
     * value 属性做键，key 属性则可以看作为value的子键，
     * 一个value可以有多个key 组成不同值在redis 服务器，
     * 这里再介绍一个属性是condition,用法condition= '#key<10',
     */
    /**
     * set 集合是一种无序集合
     * @param key
     * @return
     * @throws Exception
     */
    /**
     * re
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(value = "data",key= "'com.forwarder.entity.sys.Menu@menuId='+#key",condition = "#key<10")
    public SortedSet<String> cacheable(int key) throws Exception {
//        List<String> list = new ArrayList<>();
//        for (int i=0;i<50;i++) {
//            list.add(String.valueOf(i));
//        }
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("1");
        sortedSet.add("M");
        sortedSet.add("A");
        sortedSet.add("B");
        sortedSet.add("C");
        sortedSet.add("D");
        sortedSet.add("E");
        return sortedSet;
    }

    /**
     *
     * 用于更新数据库或新增数据时的注解，更新redis服务器中该value的值
     */
    @Override
    @CachePut(value="data",key="'com.forwarder.entity.sys.Menu@menuId='+#key",condition = "#key<10")
    public String cachePut(int key) throws Exception {
        return "redis checked";
    }

    /**
     * 用于删除数据
     */
    @Override
    @CacheEvict(value = "data",key = "'com.forwarder.entity.sys.Menu@menuId='+#key")
    public String cacheEvict(int key) throws Exception {
        return "redis evict";
    }
}
