package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhongdepeng on 2017/10/9.
 */
public class FindApplication {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/spring-context.xml");
        System.out.println(ac.getBean("test"));
    }
}
