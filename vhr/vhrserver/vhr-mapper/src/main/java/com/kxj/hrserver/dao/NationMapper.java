package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.Nation;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NationMapper {


    List<Nation> getAllNations();


}
