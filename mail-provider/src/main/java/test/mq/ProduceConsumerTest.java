package test.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-jms.xml"})
public class ProduceConsumerTest {

    private static final  Logger logger = LoggerFactory.getLogger(ProduceConsumerTest.class);
    @Autowired
    private ProducerService producerService;

    @Resource(name = "queueDestination")
    private Destination destination;

    @Test
    public void testSend() {
        for (int i=0;i<3;i++) {
            producerService.sendMessage(destination,"hello world"+(i+1));
        }
    }

}
