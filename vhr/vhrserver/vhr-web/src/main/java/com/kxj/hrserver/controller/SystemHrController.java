package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.Menu;
import com.kxj.hrserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SystemHrController
 * @Description TODO
 * @Author kxj
 * @Date 2019/11/18 21:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/system/config")
public class SystemHrController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByHrId();
    }

}
