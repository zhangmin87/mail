package start.impl;

import org.springframework.stereotype.Service;
import start.service.test;

/**
 * Created by zhangmin on 2017/9/25.
 *用于验证Zoookier和dubbo
 */

@Service("test")
public class testImpl implements test {
    public void show() {
        System.out.println("stary hungry,stary folish");
    }
}
