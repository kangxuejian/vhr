package com.kxj.hrserver.service;

import com.kxj.hrserver.bean.JobLevel;
import com.kxj.hrserver.dao.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName JobLevelService
 * @Description TODO
 * @Author kxj
 * @Date 2019/12/8 15:43
 * @Version 1.0
 **/
@Service
public class JobLevelService {

    @Autowired
    private JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        if (jobLevelMapper.getJobLevelByName(jobLevel.getName())!=null){
            return -1;
        }
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.addJobLevel(jobLevel);
    }

    public boolean deleteJobLevelById(String ids){
        String[] split = ids.split(",");
        return jobLevelMapper.deleteJobLevelById(split) == split.length;
    }

    public int updateJobLevel(JobLevel jobLevel){
        return jobLevelMapper.updateJobLevel(jobLevel);
    }
}
