package com.kai.controller;

import com.kai.jedis.SecKill_Redis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller

//@RequestMapping("/test")
public class MyController {

    @RequestMapping("/Seckill.do")
    public ModelAndView doSeckills(HttpServletResponse response, String proid){
        ModelAndView mv = new ModelAndView();

        String uid = new Random().nextInt(5000) + "";
        boolean isSuccess = SecKill_Redis.doSeckill(uid, proid);

//        mv.addObject("uid", uid);
//        mv.addObject("proid", proid);
        mv.setViewName("forward:/index.jsp");
        return mv;

    }


}
