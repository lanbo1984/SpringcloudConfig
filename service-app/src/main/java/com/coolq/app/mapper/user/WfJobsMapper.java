package com.coolq.app.mapper.user;


import com.coolq.app.entity.user.WfJobs;

import java.util.List;
import java.util.Map;

public interface WfJobsMapper {

    WfJobs selectByPrimaryKey(String id);

    List<WfJobs> selectWfJobsList(Map<String, Object> map);

}