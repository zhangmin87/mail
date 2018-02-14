package controller.redisController;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import redis.IredisService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/12.
 */
@Controller
@RequestMapping("/redis")
public class PageController {

    private static Logger logger = Logger.getLogger(PageController.class);

    @Autowired
    private IredisService iredisService;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView cacheable(HttpServletRequest request) throws Exception {
        logger.debug("I am debug");
        int key = Integer.valueOf(request.getParameter("key"));
        String msg =  iredisService.cacheable(key);
        ModelAndView modelAndView = new ModelAndView("jsp/first");
        modelAndView.addObject("demo",msg);
        return modelAndView;
    }
}
