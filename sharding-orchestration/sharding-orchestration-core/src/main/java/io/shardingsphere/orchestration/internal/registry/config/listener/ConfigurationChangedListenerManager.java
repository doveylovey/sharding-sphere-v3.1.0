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

package io.shardingsphere.orchestration.internal.registry.config.listener;

import io.shardingsphere.orchestration.reg.api.RegistryCenter;
import io.shardingsphere.orchestration.reg.listener.DataChangedEvent.ChangedType;

import java.util.Collection;

/**
 * Configuration changed listener manager.
 *
 * @author zhangliang
 * @author panjuan
 */
public final class ConfigurationChangedListenerManager {

    private final SchemaChangedListener schemaChangedListener;

    private final PropertiesChangedListener propertiesChangedListener;

    private final AuthenticationChangedListener authenticationChangedListener;

    private final ConfigMapChangedListener configMapChangedListener;

    public ConfigurationChangedListenerManager(final String name, final RegistryCenter regCenter, final Collection<String> shardingSchemaNames) {
        schemaChangedListener = new SchemaChangedListener(name, regCenter, shardingSchemaNames);
        propertiesChangedListener = new PropertiesChangedListener(name, regCenter);
        authenticationChangedListener = new AuthenticationChangedListener(name, regCenter);
        configMapChangedListener = new ConfigMapChangedListener(name, regCenter);
    }

    /**
     * Initialize all configuration changed listeners.
     */
    public void initListeners() {
        schemaChangedListener.watch(ChangedType.UPDATED, ChangedType.DELETED);
        propertiesChangedListener.watch(ChangedType.UPDATED);
        authenticationChangedListener.watch(ChangedType.UPDATED);
        configMapChangedListener.watch(ChangedType.UPDATED);
    }
}
