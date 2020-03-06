package com.kxj.hrserver.dao;

import com.kxj.hrserver.bean.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName JobLevelMapper
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/8 15:33
 * @Version 1.0
 **/
public interface JobLevelMapper {

    JobLevel getJobLevelByName(String name);

    List<JobLevel> getAllJobLevels();

    Integer addJobLevel(@Param("jobLevel") JobLevel jobLevel);

    int deleteJobLevelById(@Param("ids") String[] ids);

    int updateJobLevel(@Param("jobLevel") JobLevel jobLevel);

}
