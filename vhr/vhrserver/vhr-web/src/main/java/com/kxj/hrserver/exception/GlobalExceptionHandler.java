package com.kxj.hrserver.exception;

import com.kxj.hrserver.bean.RespBean;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/5 23:04
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据,操作失败!");
        }
        return RespBean.error("数据库异常,操作失败!");
    }

}
