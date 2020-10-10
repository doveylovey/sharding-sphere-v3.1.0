package com.study.mapper;

import com.study.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderMapper {
    /**
     * delete by primary key
     *
     * @param orderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long orderId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Order record);

    int insertOrUpdate(Order record);

    int insertOrUpdateSelective(Order record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Order record);

    /**
     * select by primary key
     *
     * @param orderId primary key
     * @return object by primary key
     */
    Order selectByPrimaryKey(Long orderId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Order record);

    int updateBatch(List<Order> list);

    int updateBatchSelective(List<Order> list);

    int batchInsert(@Param("list") List<Order> list);
}
