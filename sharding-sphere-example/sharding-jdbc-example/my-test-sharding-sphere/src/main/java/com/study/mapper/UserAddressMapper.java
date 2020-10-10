package com.study.mapper;

import com.study.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface UserAddressMapper {
    /**
     * delete by primary key
     *
     * @param addressId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long addressId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserAddress record);

    int insertOrUpdate(UserAddress record);

    int insertOrUpdateSelective(UserAddress record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserAddress record);

    /**
     * select by primary key
     *
     * @param addressId primary key
     * @return object by primary key
     */
    UserAddress selectByPrimaryKey(Long addressId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserAddress record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserAddress record);

    int updateBatch(List<UserAddress> list);

    int updateBatchSelective(List<UserAddress> list);

    int batchInsert(@Param("list") List<UserAddress> list);
}