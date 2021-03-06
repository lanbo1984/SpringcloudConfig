package com.coolq.app.service.impl.user;

import com.coolq.app.entity.user.EtlUser;
import com.coolq.app.mapper.BaseMapper;
import com.coolq.app.mapper.user.EtlUserMapper;
import com.coolq.app.service.impl.BaseServiceImpl;
import com.coolq.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lanbo
 * @Description:
 * @date 17/7/19
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<EtlUser> implements UserService {

    @Autowired
    private EtlUserMapper etlUserMapper;

    @Override
    protected BaseMapper<EtlUser> getBaseMapper() {
        return etlUserMapper;
    }

    @Override
    @Transactional
    public EtlUser getUserInfo(String userName) {
        return etlUserMapper.selectByUserName(userName);
    }
}

