package com.coolq.ap.service.user;


import com.coolq.ap.common.page.PageRsp;
import com.coolq.ap.dto.UserReq;
import com.coolq.ap.entity.WfJobs;

public interface WfJobsService {


    /**
     * @param id
     * @return
     */
    WfJobs queryById(String id);

    PageRsp<WfJobs> queryWfJobList(UserReq userReq);
}