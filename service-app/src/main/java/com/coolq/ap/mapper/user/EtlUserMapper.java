package com.coolq.ap.mapper.user;


import com.coolq.ap.entity.user.EtlUser;
import com.coolq.ap.mapper.BaseMapper;

public interface EtlUserMapper extends BaseMapper<EtlUser> {

    EtlUser selectByUserName(String userName);

}