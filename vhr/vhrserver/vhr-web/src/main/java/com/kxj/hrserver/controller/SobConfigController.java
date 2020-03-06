package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.RespBean;
import com.kxj.hrserver.bean.RespPageBean;
import com.kxj.hrserver.bean.Salary;
import com.kxj.hrserver.service.EmployeeService;
import com.kxj.hrserver.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SobConfigController
 * @Description TODO
 * @Author kxj
 * @Date 2020/2/15 16:29
 * @Version 1.0
 **/
@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size){
        return employeeService.getEmployeeByPageWithSalary(page,size);
    }


    @GetMapping("/salaries")
    public List<Salary> getAllSalaries(){
        return salaryService.getAllSalaries();
    }


    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid,Integer sid){
        Integer result = employeeService.updateEmployeeSalaryById(eid,sid);
        if (result == 1 || result == 2) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }


}
