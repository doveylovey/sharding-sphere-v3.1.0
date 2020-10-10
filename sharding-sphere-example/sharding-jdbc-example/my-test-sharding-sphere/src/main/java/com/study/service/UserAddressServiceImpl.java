package com.study.service;

import com.study.entity.UserAddress;
import com.study.mapper.UserAddressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public int deleteByPrimaryKey(Long addressId) {
        return userAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insert(UserAddress record) {
        return userAddressMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserAddress record) {
        return userAddressMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserAddress record) {
        return userAddressMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserAddress record) {
        return userAddressMapper.insertSelective(record);
    }

    @Override
    public UserAddress selectByPrimaryKey(Long addressId) {
        return userAddressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAddress record) {
        return userAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAddress record) {
        return userAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserAddress> list) {
        return userAddressMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserAddress> list) {
        return userAddressMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserAddress> list) {
        return userAddressMapper.batchInsert(list);
    }
}
