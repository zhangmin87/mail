package controller.redisController;

import controller.zookeeper.DistributedLock3;
import dto.StudentGradeDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import redis.IredisService;
import test.service.DubboDemo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Administrator on 2018/2/12.
 */
@Controller
@RequestMapping("/redis")
public class PageController {

    private static Logger logger = Logger.getLogger(PageController.class);

    @Autowired
    private DubboDemo dubboDemo;

    /**
     * 初始化
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView cacheable(HttpServletRequest request) throws Exception {
        logger.debug("I am debug");
       // Set<String> msgList = iredisService.cacheable(key);
        DistributedLock3 lock = null;
        try {
            lock = new DistributedLock3("127.0.0.1:2181", "test1");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在运行");
            String   a  =  dubboDemo.getTestRedis("1");
            ModelAndView modelAndView = new ModelAndView("jsp/first");
            modelAndView.addObject("demo",a);
            return modelAndView;
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }



//    @RequestMapping(value = "put",method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView cachePut(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        logger.debug("I am debug");
//        int key = Integer.valueOf(request.getParameter("key"));
//        String msg = iredisService.cachePut(key);
//        ModelAndView modelAndView = new ModelAndView("jsp/first");
//        modelAndView.addObject("demo",msg);
//        return modelAndView;
//    }
//
//    /**
//     * 删除redis中redis缓存的信息
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "evict",method = {RequestMethod.GET,RequestMethod.POST})
//    public ModelAndView cacheEvict(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        logger.debug("I am debug");
//        int key = Integer.valueOf(request.getParameter("key"));
//        String msg = iredisService.cacheEvict(key);
//        ModelAndView modelAndView = new ModelAndView("jsp/first");
//        modelAndView.addObject("demo",msg);
//        return modelAndView;
//    }
}
