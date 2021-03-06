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

package io.shardingsphere.core.merger.dql.orderby;

import io.shardingsphere.core.constant.OrderDirection;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * Compare util.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class CompareUtil {

    /**
     * Compare two object with order type.
     *
     * @param thisValue          this value
     * @param otherValue         other value
     * @param orderDirection     order direction
     * @param nullOrderDirection order direction for null value
     * @return compare result
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static int compareTo(final Comparable thisValue, final Comparable otherValue, final OrderDirection orderDirection, final OrderDirection nullOrderDirection) {
        if (null == thisValue && null == otherValue) {
            return 0;
        }
        if (null == thisValue) {
            return orderDirection == nullOrderDirection ? -1 : 1;
        }
        if (null == otherValue) {
            return orderDirection == nullOrderDirection ? 1 : -1;
        }
        return OrderDirection.ASC == orderDirection ? thisValue.compareTo(otherValue) : -thisValue.compareTo(otherValue);
    }
}
