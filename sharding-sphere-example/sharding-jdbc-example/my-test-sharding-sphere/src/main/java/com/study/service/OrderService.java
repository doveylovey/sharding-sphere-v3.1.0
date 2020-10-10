package com.study.service;

import com.study.entity.Order;

import java.util.List;

/**
 * @author Administrator
 */
public interface OrderService {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertOrUpdate(Order record);

    int insertOrUpdateSelective(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int updateBatch(List<Order> list);

    int updateBatchSelective(List<Order> list);

    int batchInsert(List<Order> list);
}
