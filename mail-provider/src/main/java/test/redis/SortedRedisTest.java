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
        //使用Redis  Sorted Set 解决游戏中排行榜问题
        Jedis jedis = new Jedis("127.0.0.1",6381);

        //比如坐骑排行榜,需求中仅仅设计排名问题.
        jedis.zadd("k", 5, "UserName_House_1");
        jedis.zadd("k", 2, "UserName_House_2");
        jedis.zadd("k", 4, "UserName_House_3");
        jedis.zadd("k", 6, "UserName_House_4");

        //获取指定区间排名
        Set<String> fset = jedis.zrange("HouseRank", 0, 1);

        for (String s : fset) {
            System.out.println(s);
        }
        //获取指定成员排名
        Long rank = jedis.zrank("k", "UserName_House_3");
        System.out.println("排名:"+rank);

        //获取指定成员分数
        Double score = jedis.zscore("k", "UserName_House_3");
        System.out.println("分数:"+score);
    }
}
