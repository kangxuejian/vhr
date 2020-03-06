package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.PoliticsStatus;
import com.kxj.hrserver.dao.PoliticsstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PoliticsstatusService
 * @Description TODO
 * @Author kxj
 * @Date 2020/1/13 22:52
 * @Version 1.0
 **/
@Service
public class PoliticsstatusService {

    @Autowired
    PoliticsstatusMapper politicsstatusMapper;


    public List<PoliticsStatus> getAllPoliticsstatus(){
        return politicsstatusMapper.getAllPoliticsstatus();
    }

}
