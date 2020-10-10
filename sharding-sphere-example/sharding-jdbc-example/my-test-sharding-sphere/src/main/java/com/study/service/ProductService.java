package com.study.service;

import com.study.entity.Product;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProductService {
    int deleteByPrimaryKey(Long productId);

    int insert(Product record);

    int insertOrUpdate(Product record);

    int insertOrUpdateSelective(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int updateBatch(List<Product> list);

    int updateBatchSelective(List<Product> list);

    int batchInsert(List<Product> list);
}
