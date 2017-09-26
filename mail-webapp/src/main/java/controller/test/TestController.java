package controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import start.service.Test;

/**
 * Created by zhongdepeng on 2017/9/26.
 */
@Controller
@RequestMapping("/login")
public class TestController {


    @Autowired
    private Test test;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(){
        String  a = test.show();
        ModelAndView modelAndView = new ModelAndView("jsp/first");
        modelAndView.addObject("demo",a);
        return modelAndView;
    }
}
