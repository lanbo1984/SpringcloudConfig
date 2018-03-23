package com.coolq.app.service.user;

import com.coolq.app.entity.user.EtlUser;
import com.coolq.app.service.BaseService;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/19
 */
public interface UserService extends BaseService<EtlUser> {

    /**
     *  查询用户
     * @param userName
     * @return
     */
    EtlUser getUserInfo(String userName);
}
