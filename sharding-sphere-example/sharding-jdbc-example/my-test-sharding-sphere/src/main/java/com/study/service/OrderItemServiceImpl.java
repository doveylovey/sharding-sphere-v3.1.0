package com.study.service;

import com.study.entity.OrderItem;
import com.study.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public int deleteByPrimaryKey(Long orderItemId) {
        return orderItemMapper.deleteByPrimaryKey(orderItemId);
    }

    @Override
    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(OrderItem record) {
        return orderItemMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(OrderItem record) {
        return orderItemMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }

    @Override
    public OrderItem selectByPrimaryKey(Long orderItemId) {
        return orderItemMapper.selectByPrimaryKey(orderItemId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<OrderItem> list) {
        return orderItemMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<OrderItem> list) {
        return orderItemMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<OrderItem> list) {
        return orderItemMapper.batchInsert(list);
    }
}
