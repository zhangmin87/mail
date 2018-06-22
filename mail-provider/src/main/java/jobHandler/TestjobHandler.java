package jobHandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/22.
 */
@Component
@JobHandler("TestjobHandler")
public class TestjobHandler extends IJobHandler {

    /**
     * execute handler, invoked when executor receives a scheduling request
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        String str = "开始调度任务了哦";

        return new ReturnT<>(String.format("共成功推送%s个",5));
    }
}
