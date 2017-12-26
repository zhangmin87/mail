package test.mq;

import javax.print.attribute.standard.Destination;

/**
 * Created by Administrator on 2017/12/26.
 */
public interface ConsumerService {
    String receiveMessage(Destination destination,Destination replyDestination );
}
