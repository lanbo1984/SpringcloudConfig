package com.coolq.ap.service.user;


import com.coolq.ap.entity.WfJobs;

public interface WfJobsService {


    /**
     * @param id
     * @return
     */
    WfJobs queryById(String id);
}