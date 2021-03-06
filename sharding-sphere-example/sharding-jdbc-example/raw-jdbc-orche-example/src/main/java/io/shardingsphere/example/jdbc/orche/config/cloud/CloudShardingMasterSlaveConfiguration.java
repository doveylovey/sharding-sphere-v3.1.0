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

package io.shardingsphere.example.jdbc.orche.config.cloud;

import io.shardingsphere.example.config.ExampleConfiguration;
import io.shardingsphere.orchestration.config.OrchestrationConfiguration;
import io.shardingsphere.orchestration.reg.api.RegistryCenterConfiguration;
import io.shardingsphere.shardingjdbc.orchestration.api.OrchestrationShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public final class CloudShardingMasterSlaveConfiguration implements ExampleConfiguration {
    private final RegistryCenterConfiguration registryCenterConfig;

    public CloudShardingMasterSlaveConfiguration(final RegistryCenterConfiguration registryCenterConfig) {
        this.registryCenterConfig = registryCenterConfig;
    }

    @Override
    public DataSource getDataSource() throws SQLException {
        return OrchestrationShardingDataSourceFactory.createDataSource(new OrchestrationConfiguration("orchestration-sharding-master-slave-data-source", registryCenterConfig, false));
    }
}
