package test.mq;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/27.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-jms.xml"})
public class SynProducerActiveMQTest {

    @Resource(name="producerServiceImpl")
    private ProducerService producerService;

    @Resource(name="queueDestination")
    private Destination receiveQueue;

    @Test
    public void producerTest() {
        producerService.sendMessage(receiveQueue,"my name  is zhangmin");
    }
}
