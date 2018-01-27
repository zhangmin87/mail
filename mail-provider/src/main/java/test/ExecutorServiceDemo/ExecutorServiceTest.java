package test.ExecutorServiceDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-thread.xml"} )
public class ExecutorServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorServiceTest.class);

    @Resource(name = "scheduledExecutorService")
    private ScheduledExecutorService scheduledExecutorService;

    @Test
    public void doTest() {
        scheduledExecutorService.execute(new MyRunnable());
        for (int i=0;i<1000;i++) {
            int finalI = i;
            scheduledExecutorService.execute(new Runnable() {
                @Override
                        public void run() {
                    logger.info("目前运行的线程为" + Thread.currentThread().getName() + ":" + finalI);
                }
            });
        }

    }
}
