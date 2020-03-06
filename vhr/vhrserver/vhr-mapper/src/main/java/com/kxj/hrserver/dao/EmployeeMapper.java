package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeMapper {

    List<Employee> getEmployeeByPage(@Param("page") Integer page,@Param("size")Integer size,
                                     @Param("emp") Employee employee,
                                     @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee,@Param("beginDateScope") Date[] beginDateScope);

    Integer insertSelective(Employee employee);

    Integer maxWorkID();

    Integer deleteByPrimaryKey(Integer id);

    Integer updateByPrimaryKey(Employee employee);

    Integer addEmps(List<Employee> list);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page,@Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid")Integer eid, @Param("sid") Integer sid);

}
