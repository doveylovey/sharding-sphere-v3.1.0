/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.example.config;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * 创建数据源的工具类
 *
 * @author Administrator
 */
public class DataSourceUtil {
    /**
     * 主机地址：默认
     */
    public static final String HOST_DEFAULT = "localhost";
    /**
     * 主机地址：默认
     */
    public static final String HOST_CUSTOM = "127.0.0.1";
    /**
     * 端口号：默认
     */
    public static final int PORT_DEFAULT = 3306;
    /**
     * 端口号：主
     */
    public static final int PORT_MASTER = 3337;
    /**
     * 端口号：从1
     */
    public static final int PORT_SLAVE_0 = 3338;
    /**
     * 端口号：从2
     */
    public static final int PORT_SLAVE_1 = 3339;
    /**
     * 用户名
     */
    public static final String USERNAME = "root";
    /**
     * 密码
     */
    public static final String PASSWORD = "root";

    /**
     * 创建一个默认的数据源(主机地址：127.0.0.1、端口号：3306、用户名：root、密码：root)
     *
     * @param dbName 数据库名称
     * @return
     */
    public static DataSource createDataSource(final String dbName) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        ds.setUrl(String.format("jdbc:mysql://%s:%s/%s", HOST_DEFAULT, PORT_DEFAULT, dbName));
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        return ds;
    }

    /**
     * 根据提供的参数创建数据源
     *
     * @param dbName   数据库名称
     * @param host     主机地址
     * @param port     端口号
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static DataSource createDataSource(final String host, final int port, final String dbName, final String userName, final String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        ds.setUrl(String.format("jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false", host, port, dbName));
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
