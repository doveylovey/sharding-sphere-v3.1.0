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

package io.shardingsphere.core.routing.strategy;

import io.shardingsphere.api.algorithm.sharding.ShardingValue;

import java.util.Collection;

/**
 * Sharding strategy. 分片策略：ShardingJdbc 中的分片策略与分片算法是成对出现的，每种分片策略都对应 1~2 种分片算法(不分片策略 NoneShardingStrategy 除外)
 *
 * @author zhangliang
 */
public interface ShardingStrategy {
    /**
     * Get sharding columns. 获取分片列
     *
     * @return sharding columns
     */
    Collection<String> getShardingColumns();

    /**
     * Sharding. 分片
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValues       sharding values
     * @return sharding results for data sources or tables's names
     */
    Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues);
}
