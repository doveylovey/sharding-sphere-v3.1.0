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

package io.shardingsphere.example.jdbc.nodep.config;

import io.shardingsphere.api.config.rule.MasterSlaveRuleConfiguration;
import io.shardingsphere.example.config.DataSourceUtil;
import io.shardingsphere.example.config.ExampleConfiguration;
import io.shardingsphere.example.constant.PropertiesPool;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 主从数据源配置
 */
public final class MasterSlaveConfiguration implements ExampleConfiguration {
    @Override
    public DataSource getDataSource() throws SQLException {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName("demo_ds_master_slave");
        masterSlaveRuleConfig.setMasterDataSourceName("demo_ds_master");
        masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("demo_ds_slave_1", "demo_ds_slave_2"));
        //masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("demo_ds_slave"));
        Properties properties = new Properties();
        properties.put("sql.show", PropertiesPool.SHOW_SQL);
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(), masterSlaveRuleConfig, new ConcurrentHashMap<String, Object>(), properties);
        return dataSource;
    }

    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("demo_ds_master", DataSourceUtil.createDataSource(DataSourceUtil.HOST_CUSTOM, DataSourceUtil.PORT_MASTER, "demo_master_slave", DataSourceUtil.USERNAME, DataSourceUtil.PASSWORD));
        result.put("demo_ds_slave_1", DataSourceUtil.createDataSource(DataSourceUtil.HOST_CUSTOM, DataSourceUtil.PORT_SLAVE_0, "demo_master_slave", DataSourceUtil.USERNAME, DataSourceUtil.PASSWORD));
        result.put("demo_ds_slave_2", DataSourceUtil.createDataSource(DataSourceUtil.HOST_CUSTOM, DataSourceUtil.PORT_SLAVE_1, "demo_master_slave", DataSourceUtil.USERNAME, DataSourceUtil.PASSWORD));
        return result;
    }
}