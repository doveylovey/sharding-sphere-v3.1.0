package com.study.service;

import com.study.entity.OrderItem;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderItemService {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(OrderItem record);

    int insertOrUpdate(OrderItem record);

    int insertOrUpdateSelective(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    int updateBatch(List<OrderItem> list);

    int updateBatchSelective(List<OrderItem> list);

    int batchInsert(List<OrderItem> list);
}
