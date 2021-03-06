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

package io.shardingsphere.opentracing.hook;

import io.opentracing.Span;
import io.opentracing.tag.Tags;
import io.shardingsphere.opentracing.constant.ShardingErrorLogTags;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Sharding error span.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShardingErrorSpan {

    /**
     * Set error.
     *
     * @param span  span to be set
     * @param cause failure cause of span
     */
    public static void setError(final Span span, final Exception cause) {
        span.setTag(Tags.ERROR.getKey(), true).log(System.currentTimeMillis(), getReason(cause));
    }

    private static Map<String, ?> getReason(final Throwable cause) {
        Map<String, String> result = new HashMap<>(3, 1);
        result.put(ShardingErrorLogTags.EVENT, ShardingErrorLogTags.EVENT_ERROR_TYPE);
        result.put(ShardingErrorLogTags.ERROR_KIND, cause.getClass().getName());
        result.put(ShardingErrorLogTags.MESSAGE, cause.getMessage());
        return result;
    }
}
