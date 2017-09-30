package start.impl;

import org.springframework.stereotype.Service;
import start.service.Test;
/**
 * Created by zhangmin on 2017/9/25.
 *用于验证Zoookier和dubbo
 */

@Service("test")
public class testImpl implements Test {
    public String show() {
       String a = "ni  you are  hello";
       return a;
    }
}
