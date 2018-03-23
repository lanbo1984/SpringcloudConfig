package com.coolq.app.mapper.user;


import com.coolq.app.entity.user.EtlUser;
import com.coolq.app.mapper.BaseMapper;

public interface EtlUserMapper extends BaseMapper<EtlUser> {

    EtlUser selectByUserName(String userName);

}