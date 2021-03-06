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

package io.shardingsphere.core.parsing.antlr.rule.jaxb.loader.filler;

import com.google.common.base.Preconditions;
import io.shardingsphere.core.parsing.antlr.rule.jaxb.entity.filler.FillerRuleDefinitionEntity;
import io.shardingsphere.core.parsing.antlr.rule.jaxb.loader.RuleDefinitionEntityLoader;
import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;

/**
 * Filler rule definition entity loader for JAXB.
 *
 * @author zhangliang
 */
public final class FillerRuleDefinitionEntityLoader implements RuleDefinitionEntityLoader {

    @Override
    @SneakyThrows
    public FillerRuleDefinitionEntity load(final String fillerRuleDefinitionFile) {
        InputStream inputStream = FillerRuleDefinitionEntityLoader.class.getClassLoader().getResourceAsStream(fillerRuleDefinitionFile);
        Preconditions.checkNotNull(inputStream, "Cannot load SQL filler rule definition file :%s, ", fillerRuleDefinitionFile);
        return (FillerRuleDefinitionEntity) JAXBContext.newInstance(FillerRuleDefinitionEntity.class).createUnmarshaller().unmarshal(inputStream);
    }
}
