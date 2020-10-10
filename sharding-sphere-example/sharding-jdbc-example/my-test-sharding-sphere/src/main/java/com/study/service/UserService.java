package com.study.service;

import com.study.entity.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserService {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    //int insertOrUpdate(User record);

    //int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //int updateBatch(List<User> list);

    //int updateBatchSelective(List<User> list);

    //int batchInsert(List<User> list);
}
