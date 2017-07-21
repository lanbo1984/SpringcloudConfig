package com.coolq.ap.service.user;

import com.coolq.ap.entity.EtlUser;
import com.coolq.ap.service.BaseService;

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
