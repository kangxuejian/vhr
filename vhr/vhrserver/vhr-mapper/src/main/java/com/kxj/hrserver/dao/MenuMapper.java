package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description TODO
 * @Author kxj
 * @Date 2019/11/18 20:43
 * @Version 1.0
 **/
@Repository
public interface MenuMapper {

    //通过hrId获取菜单
    List<Menu> getMenuByHrId(Integer hrId);

    //根据前台的url,获取菜单所有的角色
    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}
