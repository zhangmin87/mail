package test.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-jms.xml"})
public class SynCousumerActiveMQtest {

    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name="consumerServiceImpl")
    private ConsumerService consumerService;

    @Resource(name = "queueDestination")
    private Destination receiveQueue;

    @Resource(name="responseQueue")
    private Destination replyQueue;

    @Test
    public void producerTest() {

        String result = consumerService.receiveMessage(receiveQueue,replyQueue);
        ;logger.info("result");
    }
}
