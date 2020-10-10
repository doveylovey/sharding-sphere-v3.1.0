package com.study.mapper;

import com.study.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderItemMapper {
    /**
     * delete by primary key
     *
     * @param orderItemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long orderItemId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(OrderItem record);

    int insertOrUpdate(OrderItem record);

    int insertOrUpdateSelective(OrderItem record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderItem record);

    /**
     * select by primary key
     *
     * @param orderItemId primary key
     * @return object by primary key
     */
    OrderItem selectByPrimaryKey(Long orderItemId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderItem record);

    int updateBatch(List<OrderItem> list);

    int updateBatchSelective(List<OrderItem> list);

    int batchInsert(@Param("list") List<OrderItem> list);
}