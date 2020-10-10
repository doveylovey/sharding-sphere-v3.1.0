package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 地址表
 *
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long addressId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 性别：1-男；2-女
     */
    private Integer gender;
}