package com.coolq.app.service.user;


import com.coolq.app.common.page.PageRsp;
import com.coolq.app.dto.UserReq;
import com.coolq.app.entity.user.WfJobs;

public interface WfJobsService {


    /**
     * @param id
     * @return
     */
    WfJobs queryById(String id);

    PageRsp<WfJobs> queryWfJobList(UserReq userReq);
}