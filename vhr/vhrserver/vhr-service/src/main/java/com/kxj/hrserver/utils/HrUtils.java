package com.kxj.hrserver.utils;

import com.kxj.hrserver.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName HrUtils
 * @Description TODO
 * @Author kxj
 * @Date 2019/11/18 21:17
 * @Version 1.0
 **/
public class HrUtils {

    public static Hr getCurrentHr(){
        return (Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
