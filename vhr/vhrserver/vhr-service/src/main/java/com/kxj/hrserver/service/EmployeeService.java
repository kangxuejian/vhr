package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.Employee;
import com.kxj.hrserver.bean.RespPageBean;
import com.kxj.hrserver.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/11 23:23
 * @Version 1.0
 **/
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page,Integer size,Employee employee,Date[] beginDateScope) {
        if (page != null && size!=null){
            page = (page - 1) * size;
        }

        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,employee,beginDateScope);
        Long total = employeeMapper.getTotal(employee,beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;

    }

    public Integer addEmp(Employee employee) {
        //自动计算合同期限
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //求出月数/12
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(
                beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(
                        monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        return employeeMapper.insertSelective(employee);

    }

    public Integer maxWorkID(){
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public RespPageBean getEmployeeByPageWithSalary(Integer page,Integer size) {

        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> list = employeeMapper.getEmployeeByPageWithSalary(page,size);
        RespPageBean respPageBean  = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(employeeMapper.getTotal(null,null));
        return respPageBean;

    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid,sid);
    }
}
