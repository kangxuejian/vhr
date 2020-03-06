package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.Position;
import com.kxj.hrserver.bean.RespBean;
import com.kxj.hrserver.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SystemBasicController
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/3 22:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {

    @Autowired
    PositionService positionService;


    @PostMapping("/position")
    public RespBean addPos(@RequestBody Position pos){
        int result = positionService.addPos(pos);
        if (result == 1){
            return RespBean.ok("添加成功!");
        }else if (result == -1){
            return RespBean.error("职位名重复，添加失败!");
        }
        return RespBean.error("添加失败!");
    }

    @GetMapping("/positions")
    public List<Position> getAllPos(){
        return positionService.getAllPos();
    }

    @RequestMapping("/position/{pids}")
    public RespBean deletePosById(@PathVariable String pids){
        if (positionService.deletePosById(pids)){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/position")
    public RespBean updatePosById(@RequestBody Position position){
        if (positionService.updatePosById(position) == 1){
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }
}
