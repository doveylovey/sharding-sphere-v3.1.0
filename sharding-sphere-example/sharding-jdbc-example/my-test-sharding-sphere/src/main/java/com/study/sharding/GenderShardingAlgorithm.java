package com.study.sharding;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 用户表、用户地址表：用 user_id 取模来分库，使用 gender 来分表
 *
 * @author Administrator
 */
public class GenderShardingAlgorithm implements PreciseShardingAlgorithm<Integer>, RangeShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        String dbName = availableTargetNames.stream().findFirst().get();
        for (String target : availableTargetNames) {
            if (target.endsWith(genderToTableSuffix(shardingValue.getValue()))) {
                dbName = target;
            }
        }
        return dbName;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        Collection<String> dbNameSet = new LinkedHashSet<>(availableTargetNames.size());
        Range<Integer> valueRange = shardingValue.getValueRange();
        for (int i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String target : availableTargetNames) {
                if (target.endsWith(genderToTableSuffix(i))) {
                    dbNameSet.add(target);
                }
            }
        }
        return dbNameSet;
    }

    /**
     * 字段与分库的映射关系
     *
     * @param userId
     * @return
     */
    private String genderToTableSuffix(Integer userId) {
        return userId % 4 == 0 ? "0" : "1";
    }
}
