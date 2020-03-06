package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.Nation;
import com.kxj.hrserver.dao.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName NationService
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/13 22:36
 * @Version 1.0
 **/
@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }

}
