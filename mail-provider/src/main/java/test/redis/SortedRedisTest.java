package test.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/3/7.
 */
public class SortedRedisTest {

    public static void main(String[] args) {
//        //连接本地的redis服务
//        Jedis jedis = new Jedis("127.0.0.1",6381);
//        System.out.println("连接成功");
//        //密码验证
//        //存储zset类型缓存数据
//        jedis.zadd("test-zset",1,"java");
//        jedis.zadd("test-zset",3,"c++");
//        jedis.zadd("test-zset",2,"PHP");
//        jedis.zadd("test-zset",2,"PHP");
//        //获取zSet缓存数据类型
//        Set<String> setCache = jedis.zrange("test-zset",0,1);
//        for (String setStr : setCache) {
//            System.out.println("获取zset缓存数据:" +setStr);
//        }
        SortedSet<String> allSet = new TreeSet<String>();
        allSet.add("K");
        allSet.add("B");
        allSet.add("C");
        allSet.add("C");
        allSet.add("C");
        allSet.add("E");
        allSet.add("D");
        System.out.println("第一个元素"+allSet.first());
        System.out.println("最后一个元素"+allSet.last());
        System.out.println("headSet元素"+allSet.headSet("C"));
        System.out.println("tailSet元素"+allSet.tailSet("C"));
        System.out.println("subSet元素" +allSet.subSet("B","D"));
    }
}
