package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.Department;
import com.kxj.hrserver.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/4 22:19
 * @Version 1.0
 **/
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }


    //添加部门
    public void addDep(Department dep){
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    //删除部门
    public void deleteDepById(Department dep){
        departmentMapper.deleteDepById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
