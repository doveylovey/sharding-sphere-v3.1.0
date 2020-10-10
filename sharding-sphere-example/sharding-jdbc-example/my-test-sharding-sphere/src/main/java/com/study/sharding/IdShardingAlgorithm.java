package com.study.sharding;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 订单、订单明细表：使用 user_id 取模来分库，order_id 取模来分表
 *
 * @author Administrator
 */
public class IdShardingAlgorithm implements PreciseShardingAlgorithm<Long>, RangeShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String tableName = availableTargetNames.stream().findFirst().get();
        for (String target : availableTargetNames) {
            if (target.endsWith(idToTableSuffix(shardingValue.getValue()))) {
                tableName = target;
            }
        }
        return tableName;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        LinkedHashSet<String> tableNameSet = new LinkedHashSet<>(availableTargetNames.size());
        Range<Long> valueRange = shardingValue.getValueRange();
        for (long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String tableName : availableTargetNames) {
                if (tableName.endsWith(idToTableSuffix(i))) {
                    tableNameSet.add(tableName);
                }
            }
        }
        return tableNameSet;
    }

    /**
     * 字段与分表的映射关系
     *
     * @param id
     * @return 表后缀，如：202006、202007
     */
    private String idToTableSuffix(Long id) {
        return String.valueOf(id % 2);
    }
}
