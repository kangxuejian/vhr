package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author kxj
 * @Date 2019/11/16 15:07
 * @Version 1.0
 **/
@RestController
public class LoginController {
    
    /**
     * 返回一个json数据
     */
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录,请登录");
    }



    /**
     * 测试接口
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}

