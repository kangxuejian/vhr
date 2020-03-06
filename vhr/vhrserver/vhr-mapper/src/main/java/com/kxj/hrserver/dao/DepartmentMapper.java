package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Department;

import java.util.List;

public interface DepartmentMapper {


    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
