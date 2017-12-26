package test.mq;

import javax.print.attribute.standard.Destination;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface ProducerService {
    void sendMessage(Destination destination,final String message);
}
