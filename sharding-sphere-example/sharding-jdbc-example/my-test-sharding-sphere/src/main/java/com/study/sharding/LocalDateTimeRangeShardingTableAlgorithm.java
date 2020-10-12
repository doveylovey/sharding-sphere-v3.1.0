package com.study.sharding;

import com.google.common.collect.Range;
import com.study.util.DateUtils;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义范围查询(主要处理 between ... and ... 查询)算法，参考 https://blog.csdn.net/fh_luchenxi/article/details/105072081
 *
 * @author Administrator
 */
@Slf4j
public class LocalDateTimeRangeShardingTableAlgorithm implements RangeShardingAlgorithm<LocalDateTime> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<LocalDateTime> shardingValue) {
        Collection<String> queryTables = new ArrayList<>();
        log.info("》》》》》》》》》》范围分表算法生效《《《《《《《《《《");
        Range<LocalDateTime> timeRange = shardingValue.getValueRange();
        if (timeRange != null) {
            // 分别获取查询的开始时间、结束时间
            LocalDateTime start = timeRange.lowerEndpoint();
            LocalDateTime end = timeRange.upperEndpoint();
            // 分别获取查询开始时间、结束时间所在周的周一，然后再转换成 LocalDate 对象
            LocalDate startDate = start.with(DayOfWeek.MONDAY).toLocalDate();
            LocalDate endDate = end.with(DayOfWeek.MONDAY).toLocalDate();
            log.info("目标表后缀范围：{}", DateUtils.localDate2String(startDate, "yyyyMMdd") + " ~ " + DateUtils.localDate2String(endDate, "yyyyMMdd"));
            for (String each : availableTargetNames) {
                // 实际表名 t_order_20191125
                String[] arr = each.split("_");
                // 将实际表名中的日期后缀解析成 LocalDate
                LocalDate curDate = DateUtils.string2LocalDate(arr[2], "yyyyMMdd");
                if (curDate.compareTo(startDate) >= 0 && curDate.compareTo(endDate) <= 0) {
                    // 在查询范围内的所有表名集合
                    queryTables.add(each);
                }
            }
            log.info("实际表：{}", queryTables);
            return queryTables;
        }
        throw new IllegalArgumentException();
    }
}
