package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.entity.Order;
import com.study.entity.OrderItem;
import com.study.service.OrderItemService;
import com.study.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Administrator
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemService orderItemService;

    @PostMapping("/insert")
    public Boolean insert() {
        for (int i = 0; i < 10; i++) {
            Order order = Order.builder().orderId(Long.valueOf(i)).orderNo("OrderNo-" + i).userId(Long.valueOf(i)).orderAmount(BigDecimal.ZERO).remark("OrderRemark-" + i).orderStatus(i % 3 + 1).build();
            int insert = orderService.insert(order);
            log.info("新增 Order 结果：{}，参数{}", insert, JSON.toJSONString(order));
            OrderItem orderItem = OrderItem.builder().orderItemId(Long.valueOf(i)).orderId(Long.valueOf(i)).productId(Long.valueOf(i)).itemPrice(BigDecimal.ONE).totalNum(0).totalPrice(BigDecimal.ZERO).userId(Long.valueOf(i)).orderTime(LocalDateTime.now()).userId(Long.valueOf(i)).build();
            insert = orderItemService.insert(orderItem);
            log.info("新增 OrderItem 结果：{}，参数{}", insert, JSON.toJSONString(orderItem));
        }
        return true;
    }

    @GetMapping("/find")
    public Order find() {
        long orderId = 1L;
        return orderService.selectByPrimaryKey(orderId);
    }
}
