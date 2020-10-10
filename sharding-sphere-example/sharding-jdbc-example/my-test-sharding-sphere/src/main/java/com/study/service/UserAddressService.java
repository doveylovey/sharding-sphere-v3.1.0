package com.study.service;

import com.study.entity.UserAddress;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserAddressService {
    int deleteByPrimaryKey(Long addressId);

    int insert(UserAddress record);

    int insertOrUpdate(UserAddress record);

    int insertOrUpdateSelective(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    int updateBatch(List<UserAddress> list);

    int updateBatchSelective(List<UserAddress> list);

    int batchInsert(List<UserAddress> list);
}
