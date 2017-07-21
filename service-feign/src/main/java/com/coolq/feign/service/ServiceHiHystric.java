package com.coolq.feign.service;

import com.coolq.feign.dto.UserReq;
import org.springframework.stereotype.Component;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/17
 */
@Component
public class ServiceHiHystric implements UserService {

    @Override
    public String getUserInfo(UserReq userReq) {
        return "Hystric:sorry " + userReq.getUserName();
    }

}
