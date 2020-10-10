package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.entity.User;
import com.study.entity.UserAddress;
import com.study.service.UserAddressService;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @author Administrator
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserAddressService userAddressService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Boolean insert() {
        for (int i = 0; i < 10; i++) {
            User user = User.builder().userId(Long.valueOf(i)).idNumber("idNumber-" + i).name("name" + i).age(20 + i).gender((i + 1) % 2).birthDate(LocalDate.now().minusDays(i)).build();
            int insert = userService.insert(user);
            log.info("新增 User 结果：{}，参数{}", insert, JSON.toJSONString(user));
            UserAddress userAddress = UserAddress.builder().addressId(Long.valueOf(i)).userId(Long.valueOf(i)).gender((i + 1) % 2).build();
            insert = userAddressService.insert(userAddress);
            log.info("新增 UserAddress 结果：{}，参数{}", insert, JSON.toJSONString(userAddress));
        }
        return true;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User find() {
        long userId = 1L;
        return userService.selectByPrimaryKey(userId);
    }
}
