package com.study.mapper;

import com.study.entity.User;

/**
 * @author Administrator
 */
public interface UserMapper {
    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入一条记录
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据 userId 删除一条记录
     *
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 根据 userId 查询一条记录
     *
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Long userId);

    /**
     * 修改记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 修改记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 查询数量
     *
     * @param query
     * @return
     */
    //int count(@Param("condition") ListUserVo query);

    /**
     * 查询列表
     *
     * @param query
     * @return
     */
    //List<User> listByCondition(@Param("condition") ListUserVo query);
}
