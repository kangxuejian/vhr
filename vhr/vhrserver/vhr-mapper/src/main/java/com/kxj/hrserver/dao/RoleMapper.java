package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> getAllRoles();

    Integer insert(Role record);


    Integer deleteByPrimaryKey(Integer rid);
}
