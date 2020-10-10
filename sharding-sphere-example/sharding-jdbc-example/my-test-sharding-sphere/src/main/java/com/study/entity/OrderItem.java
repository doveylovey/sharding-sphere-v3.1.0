package com.study.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单明细表
 *
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long orderItemId;

    /**
     * 订单 id
     */
    private Long orderId;

    /**
     * 商品 id
     */
    private Long productId;

    /**
     * 单价
     */
    private BigDecimal itemPrice;

    /**
     * 数量
     */
    private Integer totalNum;

    /**
     * 订单总额
     */
    private BigDecimal totalPrice;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 用户 id
     */
    private Long userId;
}