package redisTest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.redisimplment.CustomDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/25.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:META-INF/spring/application.xml"})
public class RedisTest{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomDao c;

//    @Test
    public void test() {
        logger.info("=====start======");

        //String 操作
//        c.insertString("java:string:english","java_insert_string");
//        logger.info("查询redis中值:{}",c.select("java:string:english"));
//        c.insertString("java:string:cn","redis学习");
//        logger.info("查看redis中值:{}",c.select("java:string:cn"));
//
//        List<Object> list = new ArrayList();
//        list.add("redis学习");
//        list.add("123456789");
//        c.insertList("java:list", list);
//        logger.info("查询redis中的值:{}",c.select("java:list"));
//        //创建一个列表之后 再次添加一个Map到列表里面
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("A", "sss");
//        map.put("AB", "sssdf");
//        c.insertList("java:list", map.toString());
          logger.info("查询redis中的值:{}",c.select("name"));

//
        //创建一个列表之后，再次添加一个Map到列表里面
        Map<String,String> map  = new HashMap<String,String>();
        map.put("A","sss");
        map.put("AB","sssdf");
        c.insertList("java:list",map.toString());
        logger.info("查询redis中值:{}",c.select("java:list"));

        //删除缓存的数据
        c.delete("name");
        logger.info("查询redis 中的值:{}",c.select("name")); ;


    }
}
