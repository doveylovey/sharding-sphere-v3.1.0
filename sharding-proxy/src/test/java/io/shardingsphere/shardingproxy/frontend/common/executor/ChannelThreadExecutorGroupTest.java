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

package io.shardingsphere.shardingproxy.frontend.common.executor;

import io.netty.channel.ChannelId;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public final class ChannelThreadExecutorGroupTest {

    @Test
    public void assertRegister() {
        ChannelId channelId = mock(ChannelId.class);
        ChannelThreadExecutorGroup.getInstance().register(channelId);
        assertNotNull(ChannelThreadExecutorGroup.getInstance().get(channelId));
        ChannelThreadExecutorGroup.getInstance().unregister(channelId);
    }

    @Test
    public void assertUnregister() {
        ChannelId channelId = mock(ChannelId.class);
        ChannelThreadExecutorGroup.getInstance().register(channelId);
        ChannelThreadExecutorGroup.getInstance().unregister(channelId);
        assertNull(ChannelThreadExecutorGroup.getInstance().get(channelId));
    }
}
