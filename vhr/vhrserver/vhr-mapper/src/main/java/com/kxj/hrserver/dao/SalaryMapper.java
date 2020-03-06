package com.kxj.hrserver.dao;


import com.kxj.hrserver.bean.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalaryMapper {

    List<Salary> getAllSalaries();

    int insertSelective(Salary record);

    Integer deleteByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Salary salary);
}
