package com.kxj.hrserver.controller;

import com.kxj.hrserver.bean.Department;
import com.kxj.hrserver.bean.RespBean;
import com.kxj.hrserver.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/4 22:21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    
    /**
     *@Author kxj
     *@Description 加载全部部门
     */
    @GetMapping("/")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    /**
     *@Author kxj
     *@Description 添加部门
     */
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        departmentService.addDep(dep);
        if (dep.getResult() == 1){
            return RespBean.ok("添加成功",dep);
        }
        return RespBean.error("添加失败");
    }

    /**
     *@Author kxj
     *@Description 删除部门
     */
    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id){
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespBean.error("该部门下有子部门,删除失败");
        } else if (dep.getResult() == -1){
            return RespBean.error("该部门下有员工,删除失败");
        } else if (dep.getResult() == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
