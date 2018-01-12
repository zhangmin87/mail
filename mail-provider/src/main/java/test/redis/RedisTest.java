package test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2018/1/12.
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的reis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接本地的Redis服务成功");
        //查看服务是不是正常
        System.out.println("服务 正在运行:"+jedis.ping());

    }
    @Test
    public void TestRedisString() {
        //连接本地服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("connecte to server");
        //设置redis 字符串数据
        //获取存储的数据并输出
        String nmae
    }

}
