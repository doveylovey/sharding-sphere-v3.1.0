package com.study.sharding;

import com.study.util.DateUtils;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 自定义精确查询(主要处理：IN、= 查询)算法，参考 https://blog.csdn.net/fh_luchenxi/article/details/105072081
 *
 * @author Administrator
 */
@Slf4j
public class LocalDateTimePreciseShardingTableAlgorithm implements PreciseShardingAlgorithm<LocalDateTime> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<LocalDateTime> shardingValue) {
        log.info("》》》》》》》》》》精确分表算法生效《《《《《《《《《《");
        LocalDateTime creatTime = shardingValue.getValue();
        if (creatTime != null) {
            // 获取 creatTime 所在周的周一，然后再转换成字符串表名
            String mondayStr = DateUtils.localDateTime2String(creatTime.with(DayOfWeek.MONDAY), "yyyyMMdd");
            log.info("目标表后缀：{}", mondayStr);
            for (String each : availableTargetNames) {
                if (each.endsWith(mondayStr)) {
                    log.info("实际表：{}", each);
                    return each;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
