package com.coolq.ap.controller;

import com.alibaba.fastjson.JSON;
import com.coolq.ap.common.AjaxResult;
import com.coolq.ap.common.page.PageRsp;
import com.coolq.ap.dto.UserReq;
import com.coolq.ap.entity.user.EtlUser;
import com.coolq.ap.entity.user.WfJobs;
import com.coolq.ap.enums.ResultMsgEnum;
import com.coolq.ap.service.user.UserService;
import com.coolq.ap.service.user.WfJobsService;
import com.coolq.ap.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/19
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Resource
    private UserService userService;

    @Resource
    private WfJobsService wfJobsService;


    final String userRedisKey = "dmeo:app:user";

    @Value("${bus.test}")
    private String testValue;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public AjaxResult getUserInfo(@RequestBody UserReq userReq) {
        try {
//            PageRsp<WfJobs> pageRsp = wfJobsService.queryWfJobList(userReq);
//
//            if (pageRsp != null) {
//                return AjaxResult.success(pageRsp);
//            }
            // 缓存中取
            String cacheUser = RedisUtil.hget(0, userRedisKey, userReq.getUserName());
            if (StringUtils.hasText(cacheUser)) {
                return AjaxResult.success(JSON.parse(cacheUser));
            } else {
                EtlUser user = userService.getUserInfo(userReq.getUserName());
                RedisUtil.hset(0, userRedisKey, userReq.getUserName(), JSON.toJSONString(user));
                return AjaxResult.success(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.failed(ResultMsgEnum.SYSTEM_ERROR);
        }

    }

    @RequestMapping("/test")
    @ResponseBody
    public AjaxResult test() {
        return AjaxResult.success(testValue);
    }

}
