package test.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/29.
 * mq 信息的发送
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-jms.xml"})
public class ProduceConsumerTest {

    private static final  Logger logger = LoggerFactory.getLogger(ProduceConsumerTest.class);
    @Autowired
    private ProducerService producerService;

//    @Test
    public void testSend() {
        for (int i=0;i<3;i++) {
            producerService.sendMessage("mail.mqs","hello world"+(i+1),"api_send_outbound_customs_cargo" );
        }
    }
}
