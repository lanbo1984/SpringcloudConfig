package com.coolq.ribbon.service;

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

    public String hiService(String name) {
        return restTemplate.getForObject("http://app/user/getUserInfo?userName=" + name, String.class);
    }


}
