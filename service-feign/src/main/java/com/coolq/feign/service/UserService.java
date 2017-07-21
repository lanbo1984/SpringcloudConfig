package com.coolq.feign.service;

import com.coolq.feign.FeignConfig;
import com.coolq.feign.dto.UserReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/17
 */
@FeignClient(value = "APP", configuration = FeignConfig.class, fallback = ServiceHiHystric.class)
public interface UserService {

    @RequestMapping(value = "/user/getUserInfo", method = RequestMethod.POST,consumes = "application/json")
    String getUserInfo(@RequestBody UserReq userReq);


}
