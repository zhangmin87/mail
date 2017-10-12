package DubbProvider;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhongdepeng on 2017/9/21.
 * 
 */
public class DubboProviderd {


    public static void main(String[] args) {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
            context.start();

        synchronized (DubboProviderd.class) {
            while (true) {
                try {
                    DubboProviderd.class.wait();
                } catch (InterruptedException e) {

                }
            }
        }
    }

}
