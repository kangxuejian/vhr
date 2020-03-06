package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.JobLevel;
import com.kxj.hrserver.bean.RespBean;
import com.kxj.hrserver.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName JobLevelController
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/8 15:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getJobLevel(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        int result = jobLevelService.addJobLevel(jobLevel);
        if (result == 1){
            return RespBean.ok("添加成功");
        }else if (result == -1){
            return RespBean.ok("职称名重复，添加失败!");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/jobLevel/{ids}")
    public RespBean deleteJobLevelById(@PathVariable String ids){
        if (jobLevelService.deleteJobLevelById(ids)){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/jobLevel")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel) == 1){
            return RespBean.ok("修改成功!");
        }
        return RespBean.ok("修改失败!");
    }

}
