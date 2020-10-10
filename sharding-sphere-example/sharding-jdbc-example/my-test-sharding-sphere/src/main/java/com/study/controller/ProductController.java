package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.entity.Product;
import com.study.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Boolean insert() {
        for (int i = 0; i < 10; i++) {
            Product product = Product.builder().productId(Long.valueOf(i)).code("ProductCode-" + i).name("ProductName-" + i).desc("ProductDesc-" + i).build();
            int insert = productService.insert(product);
            log.info("新增结果：{}，参数{}", insert, JSON.toJSONString(product));
        }
        return true;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Product find() {
        long productId = 1L;
        return productService.selectByPrimaryKey(productId);
    }
}
