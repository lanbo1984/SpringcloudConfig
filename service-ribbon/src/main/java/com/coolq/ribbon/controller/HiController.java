package com.coolq.ribbon.controller;

import com.coolq.ribbon.dto.UserReq;
import com.coolq.ribbon.service.HiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private HiService hiService;

    @RequestMapping(value = "/hi")
    public String hi(UserReq userReq) {
        logger.info("client:{},name:{}", "ribbon", userReq);
        return hiService.hiService(userReq);
    }

}
