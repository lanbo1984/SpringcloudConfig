package com.coolq.feign.controller;

import com.coolq.feign.dto.UserReq;
import com.coolq.feign.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/17
 */
@RestController
public class HiController {

    private Logger logger = LoggerFactory.getLogger(HiController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        UserReq userReq = new UserReq();
        userReq.setUserName(name);
        logger.info("client:{},name:{}", "feign", name);
        return userService.getUserInfo(userReq);
    }

}
