package controller.test;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import test.service.DubboDemo;


/**
 * Created by zhongdepeng on 2017/9/26.
 */
@Controller
@RequestMapping("/login")
public class TestController {

    private static Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private DubboDemo testClient;


    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public  ModelAndView login()  {
        logger.debug("I am debug");
        String param1 = "keyparms";
        String  a = testClient.getTestRedis(param1);
        ModelAndView modelAndView = new ModelAndView("jsp/first");
        modelAndView.addObject("demo",a);
        return modelAndView;
    }
}
