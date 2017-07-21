package com.coolq.ap.service.impl.user;

import com.coolq.ap.datasource.annotation.DbMsEnum;
import com.coolq.ap.datasource.annotation.SwitchDs;
import com.coolq.ap.entity.WfJobs;
import com.coolq.ap.mapper.user.WfJobsMapper;
import com.coolq.ap.service.user.WfJobsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WfJobsServiceImpl implements WfJobsService {

    private Logger logger = LoggerFactory.getLogger(WfJobsServiceImpl.class);

    @Resource
    private WfJobsMapper wfJobsMapper;


    @SwitchDs(ms = DbMsEnum.OOZIE)
    @Override
    public WfJobs queryById(String id) {
        return wfJobsMapper.selectByPrimaryKey(id);
    }
}