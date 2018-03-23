package com.coolq.app.service.impl;

import com.coolq.app.mapper.BaseMapper;
import com.coolq.app.service.BaseService;

/**
 * 基础Service接口
 *
 * @author
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public int deleteById(Long id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return getBaseMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getBaseMapper().insertSelective(record);
    }

    @Override
    public T getById(Long id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public T getById(Integer id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateSelective(T record) {
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }
}
