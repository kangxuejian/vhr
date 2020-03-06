package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.Menu;
import com.kxj.hrserver.dao.MenuMapper;
import com.kxj.hrserver.dao.MenuRoleMapper;
import com.kxj.hrserver.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author kxj
 * @Date 2019/11/18 21:16
 * @Version 1.0
 **/
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenuByHrId(HrUtils.getCurrentHr().getId());
    }

    //@Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid){
        return menuMapper.getMidsByRid(rid);
    }


    @Transactional
    public boolean updateMenuRole(Integer rid,Integer[] mids){
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result == mids.length;
    }

}
