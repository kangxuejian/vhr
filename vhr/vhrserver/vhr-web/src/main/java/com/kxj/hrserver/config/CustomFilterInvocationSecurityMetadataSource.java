package com.kxj.hrserver.config;

import com.kxj.hrserver.bean.Menu;
import com.kxj.hrserver.bean.Role;
import com.kxj.hrserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MyFilter
 * @Description 提供权限访问
 * @Author kxj
 * @Date 2019/11/26 22:51
 * @Version 1.0
 * 作用：根据用户传来的请求地址，分析出请求需要的角色
 **/
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //当前请求的地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获取所有的菜单
        List<Menu> menus = menuService.getAllMenusWithRole();
        //比较requestUrl与menus里的url是否一致
        for (Menu menu:menus){
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                //获取角色
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                    
                }
                return SecurityConfig.createList(str);
            }
        }
        //没有匹配上的都是登录之后访问,ROLE_LOGIN做标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
