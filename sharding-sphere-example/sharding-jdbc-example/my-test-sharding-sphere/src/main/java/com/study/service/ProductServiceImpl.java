package com.study.service;

import com.study.entity.Product;
import com.study.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Long productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Product record) {
        return productMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Product record) {
        return productMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Long productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Product> list) {
        return productMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Product> list) {
        return productMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Product> list) {
        return productMapper.batchInsert(list);
    }
}
