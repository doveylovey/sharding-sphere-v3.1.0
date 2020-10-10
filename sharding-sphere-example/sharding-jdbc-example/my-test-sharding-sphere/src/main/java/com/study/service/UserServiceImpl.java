package com.study.service;

import com.study.entity.User;
import com.study.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    /*@Override
    public int insertOrUpdate(User record) {
        return userMapper.insertOrUpdate(record);
    }*/

    /*@Override
    public int insertOrUpdateSelective(User record) {
        return userMapper.insertOrUpdateSelective(record);
    }*/

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /*@Override
    public int updateBatch(List<User> list) {
        return userMapper.updateBatch(list);
    }*/

    /*@Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }*/

    /*@Override
    public int batchInsert(List<User> list) {
        return userMapper.batchInsert(list);
    }*/
}
