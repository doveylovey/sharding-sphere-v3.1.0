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

package io.shardingsphere.core.parsing.parser.dialect.oracle.clause;

import io.shardingsphere.core.parsing.lexer.LexerEngine;
import io.shardingsphere.core.parsing.lexer.dialect.oracle.OracleKeyword;
import io.shardingsphere.core.parsing.lexer.token.Keyword;
import io.shardingsphere.core.parsing.parser.clause.SelectListClauseParser;
import io.shardingsphere.core.parsing.parser.context.selectitem.SelectItem;
import io.shardingsphere.core.parsing.parser.sql.dql.select.SelectStatement;
import io.shardingsphere.core.rule.ShardingRule;

/**
 * Select list clause parser for Oracle.
 *
 * @author zhangliang
 */
public final class OracleSelectListClauseParser extends SelectListClauseParser {

    public OracleSelectListClauseParser(final ShardingRule shardingRule, final LexerEngine lexerEngine) {
        super(shardingRule, lexerEngine);
    }

    @Override
    protected Keyword[] getSkippedKeywordsBeforeSelectItem() {
        return new Keyword[]{OracleKeyword.CONNECT_BY_ROOT};
    }

    @Override
    protected boolean isRowNumberSelectItem() {
        return false;
    }

    @Override
    protected SelectItem parseRowNumberSelectItem(final SelectStatement selectStatement) {
        throw new UnsupportedOperationException("Cannot support special select item.");
    }
}
