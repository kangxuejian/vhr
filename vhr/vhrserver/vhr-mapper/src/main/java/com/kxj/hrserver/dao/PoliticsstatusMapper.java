package com.kxj.hrserver.dao;


import com.kxj.hrserver.bean.PoliticsStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticsstatusMapper {

    List<PoliticsStatus> getAllPoliticsstatus();

}
