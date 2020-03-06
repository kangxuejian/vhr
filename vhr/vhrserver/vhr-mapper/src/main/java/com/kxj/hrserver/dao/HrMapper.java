package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Hr;
import com.kxj.hrserver.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {

    Hr loadUserByUsername(String userName);


    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid,@Param("keywords") String keywords);

    int updateByPrimaryKeySelective(Hr hr);

    Integer deleteByPrimaryKey(Integer id);

    List<Hr> getAllHrsExceptionCurrentHr(@Param("id") Integer id);
}
