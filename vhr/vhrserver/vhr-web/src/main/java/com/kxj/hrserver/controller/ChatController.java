package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.Hr;
import com.kxj.hrserver.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ChatController
 * @Description TODO
 * @Author kxj
 * @Date 2020/2/25 22:14
 * @Version 1.0
 **/
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;


    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrsExceptCurrentHr();
    }

}
