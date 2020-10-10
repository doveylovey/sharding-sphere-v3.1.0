package com.study.mapper;

import com.study.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProductMapper {
    /**
     * delete by primary key
     *
     * @param productId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Product record);

    int insertOrUpdate(Product record);

    int insertOrUpdateSelective(Product record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Product record);

    /**
     * select by primary key
     *
     * @param productId primary key
     * @return object by primary key
     */
    Product selectByPrimaryKey(Long productId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Product record);

    int updateBatch(List<Product> list);

    int updateBatchSelective(List<Product> list);

    int batchInsert(@Param("list") List<Product> list);
}