package com.study.service;

import com.study.entity.Order;
import com.study.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Order record) {
        return orderMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Order record) {
        return orderMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Order> list) {
        return orderMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Order> list) {
        return orderMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Order> list) {
        return orderMapper.batchInsert(list);
    }
}
