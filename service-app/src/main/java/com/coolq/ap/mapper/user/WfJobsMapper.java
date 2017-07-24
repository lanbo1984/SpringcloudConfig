package com.coolq.ap.mapper.user;


import com.coolq.ap.entity.WfJobs;

import java.util.List;
import java.util.Map;

public interface WfJobsMapper {

    WfJobs selectByPrimaryKey(String id);

    List<WfJobs> selectWfJobsList(Map<String, Object> map);

}