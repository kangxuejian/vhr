package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.Role;
import com.kxj.hrserver.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/31 16:13
 * @Version 1.0
 **/
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }


    public Integer addRole(Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid){
        return roleMapper.deleteByPrimaryKey(rid);
    }

}
