package com.kxj.hrserver.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRoleMapper {


    void deleteByRid(Integer rid);


    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);


}
