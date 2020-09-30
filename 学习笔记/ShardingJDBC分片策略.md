ShardingJDBC 分片策略及分片算法
============================

### 分片策略
ShardingJDBC 分片策略有两种维度：
- 数据源分片策略(DatabaseShardingStrategy)：数据被分配的目标数据源
- 表分片策略(TableShardingStrategy)：数据被分配的目标表
> 两种分片策略 API 完全相同，但是表分片策略是依赖于数据源分片策略的(即：先分库然后才有分表)

### 分片算法
分片算法继承自 ShardingStrategy，提供了 5 种分片策略。

1、StandardShardingStrategy：标准分片策略。提供对 SQL 语句中的 =、IN、BETWEEN AND 的分片操作支持。
> StandardShardingStrategy 只支持单分片键，提供 PreciseShardingAlgorithm 和 RangeShardingAlgorithm 两个分片算法。PreciseShardingAlgorithm 是必选的，用于处理 = 和 IN 的分片；RangeShardingAlgorithm 是可选的，用于处理 BETWEEN AND 分片，如果不配置 RangeShardingAlgorithm，SQL 中的 BETWEEN AND 将按照全库路由处理。

2、ComplexShardingStrategy：复合分片策略。提供对 SQL 语句中的 =、IN、BETWEEN AND 的分片操作支持。
> ComplexShardingStrategy 支持多分片键，由于多分片键之间的关系复杂，因此 ShardingJDBC 并未做过多的封装，而是直接将分片键值组合以及分片操作符交于算法接口，完全由应用开发者实现，提供最大的灵活度。

3、InlineShardingStrategy：Inline 表达式分片策略。使用 Groovy 的 Inline 表达式，提供对 SQL 语句中的 =、IN 的分片操作支持。
> InlineShardingStrategy 只支持单分片键，对于简单的分片算法，可以通过简单的配置使用，从而避免繁琐的 Java 代码开发，如: t_user${user_id % 8} 表示 t_user 表按照 user_id 按 8 取模分成 8 个表，表名称为 t_user_0 到 t_user_7。

4、HintShardingStrategy：通过 Hint 而非 SQL 解析的方式分片的策略。

5、NoneShardingStrategy：不分片的策略。

注：由于分片算法和业务实现紧密相关，因此 ShardingJDBC 并未提供内置分片算法，而是通过分片策略将各种场景提炼出来，提供更高层级的抽象，并提供接口让应用开发者自行实现分片算法。

### 自定义分片算法
ShardingJDBC 提供了 4 种算法接口：PreciseShardingAlgorithm、RangeShardingAlgorithm、HintShardingAlgorithm、ComplexKeysShardingAlgorithm，可以自定义分片算法。下面以 t_order_item 表为例实现自定义分片算法。

### 参考
- https://blog.csdn.net/justry_deng/article/details/90815986
- https://www.cnblogs.com/mr-yang-localhost/p/8313360.html
- https://blog.csdn.net/womenyiqilalala/category_9915733.html