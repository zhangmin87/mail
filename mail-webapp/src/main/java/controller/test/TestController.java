package controller.test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import start.service.Test;
import test.service.DubboDemo;


/**
 * Created by zhongdepeng on 2017/9/26.
 */
@Controller
@RequestMapping("/login")
public class TestController {

    @Autowired
    private Test testClient;

    @Autowired
    private DubboDemo dubboDemo;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    private ModelAndView login(){
        String  a = testClient.show();
        String  b = dubboDemo.doSave();
        ModelAndView modelAndView = new ModelAndView("jsp/first");
        modelAndView.addObject("demo",b);
        return modelAndView;
    }
}
