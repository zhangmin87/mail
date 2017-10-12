package start.impl;

import org.springframework.stereotype.Service;
import start.service.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmin on 2017/9/25.
 *用于验证Zoookier和dubbo
 */

@Service("test")
public class testImpl implements Test {
    public String show() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = simpleDateFormat.format(date);
        String a = "what time is it"+todayDate;
        return a;
    }
}
