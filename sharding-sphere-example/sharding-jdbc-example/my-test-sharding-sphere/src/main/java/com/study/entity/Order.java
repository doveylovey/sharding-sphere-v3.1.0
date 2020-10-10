package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单表
 *
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 订单总额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态：1-进行中，2-已完成，3-已取消
     */
    private Integer orderStatus;

    /**
     * 留言
     */
    private String remark;
}
