package redis;

import dto.StudentGradeDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


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
     *
     * @param key
     * @return
     * @throws Exception
     */
    /**
     * list
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(value = "data",key= "'com.forwarder.entity.sys.Menu@menuId='+#key",condition = "#key<10")
    
    public Set<StudentGradeDTO> cacheable(int key) throws Exception {
        //// FIXME: 2018/3/16 redis 设计成缓存
//        //学生一
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setScore(25.0);
        studentGradeDTO.setStudentName("zhangmin");

        //学生二
        StudentGradeDTO studentGradeDTO1 = new StudentGradeDTO();
        studentGradeDTO1.setStudentName("juFang");
        studentGradeDTO1.setScore(340.0);
        //学生三
        StudentGradeDTO studentGradeDTO2 = new StudentGradeDTO();
        studentGradeDTO2.setStudentName("Lujiang");
        studentGradeDTO2.setScore(34.0);

        SortedSet<StudentGradeDTO> studentGradeDTOs = new TreeSet<>();
        studentGradeDTOs.add(studentGradeDTO);
        studentGradeDTOs.add(studentGradeDTO1);
        studentGradeDTOs.add(studentGradeDTO2);
        Jedis jedis = new Jedis("127.0.0.1",6381);
//        jedis.zadd("n".getBytes(),studentGradeDTO1.getScore(),)

//
//
//        return studentGradeDTOs;
        //使用Redis  Sorted Set 解决游戏中排行榜问题
//        Jedis jedis = new Jedis("127.0.0.1",6381);
//
//        //比如坐骑排行榜,需求中仅仅设计排名问题.
//        jedis.zadd("n", Math.random(), "UserName_House_1");
//        jedis.zadd("n", Math.random(), "UserName_House_2");
//        jedis.zadd("n", Math.random(), "UserName_House_3");
//        jedis.zadd("n", Math.random(), "UserName_House_4");
//
//        //获取指定区间排名
//        Set<String> fset = jedis.zrange("HouseRank", 0, 5);


//        //获取指定成员排名
//        Long rank = jedis.zrank("n", "UserName_House_3");
//        System.out.println("排名:"+rank);
//
//        //获取指定成员分数
//        Double score = jedis.zscore("n", "UserName_House_3");
//        System.out.println("分数:"+score);
        return null;
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
