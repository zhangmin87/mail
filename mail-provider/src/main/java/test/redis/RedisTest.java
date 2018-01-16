package test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2018/1/12.
 */
public class RedisTest {
    public static void main(String[] args) {
//        String a = "abcdefg";
//        System.out.println(a.startsWith("abc"));
////        //连接本地的reis服务
////        Jedis jedis = new Jedis("localhost");
////        System.out.println("连接本地的Redis服务成功");
////        //查看服务是不是正常
////        System.out.println("服务 正在运行:"+jedis.ping());
        //连接本地的redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接本地连接的redis 服务成功");
        //查看服务是不是运行
        System.out.println("服务 正在运行:"+jedis.ping());
    }
    @Test
    public void TestRedisString() {
        //连接本地的redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection to server successfully");
        //设置redis 字符串数据
        // jedis.set("runnoobkery","redis tutorial")
        //
        String name = jedis.get("theName");
        System.out.println("stored theName in redis::"+name);
    }

}
