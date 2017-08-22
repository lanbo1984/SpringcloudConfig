package com.coolq.ribbon.service;

import com.coolq.ribbon.dto.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/17
 */
@Service
public class HiService {


    @Autowired
    RestTemplate restTemplate;

    public String hiService(UserReq userReq) {

        return restTemplate.postForObject("http://app/user/getUserInfo", userReq, String.class);

    }


}
