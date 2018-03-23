package com.coolq.app.service.impl.user;

import com.coolq.app.common.page.PageConverts;
import com.coolq.app.common.page.PageRsp;
import com.coolq.app.common.datasource.annotation.DbMsEnum;
import com.coolq.app.common.datasource.annotation.SwitchDs;
import com.coolq.app.dto.UserReq;
import com.coolq.app.entity.user.WfJobs;
import com.coolq.app.mapper.user.WfJobsMapper;
import com.coolq.app.service.user.WfJobsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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


    @SwitchDs(ms = DbMsEnum.OOZIE)
    @Override
    public PageRsp<WfJobs> queryWfJobList(UserReq userReq) {

        PageInfo<WfJobs> pageInfo = PageHelper.startPage(userReq.getPage(), userReq.getRows()).doSelectPageInfo(() -> wfJobsMapper.selectWfJobsList(null));

        PageRsp<WfJobs> pageRsp = PageConverts.convert(pageInfo);

        return pageRsp;
    }
}