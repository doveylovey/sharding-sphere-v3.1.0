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

package io.shardingsphere.dbtest.engine.dml;

import io.shardingsphere.core.constant.DatabaseType;
import io.shardingsphere.core.constant.SQLType;
import io.shardingsphere.dbtest.cases.assertion.dml.DMLIntegrateTestCaseAssertion;
import io.shardingsphere.dbtest.cases.assertion.root.SQLValue;
import io.shardingsphere.dbtest.engine.util.IntegrateTestParameters;
import io.shardingsphere.dbtest.env.DatabaseTypeEnvironment;
import io.shardingsphere.dbtest.env.IntegrateTestEnvironment;
import io.shardingsphere.test.sql.SQLCaseType;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertFalse;

public final class AdditionalDMLIntegrateTest extends BaseDMLIntegrateTest {

    private static IntegrateTestEnvironment integrateTestEnvironment = IntegrateTestEnvironment.getInstance();

    private final DMLIntegrateTestCaseAssertion assertion;

    public AdditionalDMLIntegrateTest(final String sqlCaseId, final String path, final DMLIntegrateTestCaseAssertion assertion, final String shardingRuleType,
                                      final DatabaseTypeEnvironment databaseTypeEnvironment, final SQLCaseType caseType) throws IOException, JAXBException, SQLException, ParseException {
        super(sqlCaseId, path, assertion, shardingRuleType, databaseTypeEnvironment, caseType);
        this.assertion = assertion;
    }

    @Parameters(name = "{0} -> Rule:{3} -> {4} -> {5}")
    public static Collection<Object[]> getParameters() {
        return integrateTestEnvironment.isRunAdditionalTestCases() ? IntegrateTestParameters.getParametersWithAssertion(SQLType.DML) : Collections.<Object[]>emptyList();
    }

    @Test
    public void executeUpdateWithAutoGeneratedKeys() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeUpdateForStatementWithAutoGeneratedKeys(connection) : executeUpdateForPreparedStatementWithAutoGeneratedKeys(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeUpdateForStatementWithAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(String.format(getSql(), assertion.getSQLValues().toArray()), Statement.NO_GENERATED_KEYS);
        }
    }

    private int executeUpdateForPreparedStatementWithAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), Statement.NO_GENERATED_KEYS)) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            return preparedStatement.executeUpdate();
        }
    }

    @Test
    public void assertExecuteUpdateWithColumnIndexes() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || DatabaseType.PostgreSQL == getDatabaseTypeEnvironment().getDatabaseType() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeUpdateForStatementWithColumnIndexes(connection) : executeUpdateForPreparedStatementWithColumnIndexes(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeUpdateForStatementWithColumnIndexes(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(String.format(getSql(), assertion.getSQLValues().toArray()), new int[]{1});
        }
    }

    private int executeUpdateForPreparedStatementWithColumnIndexes(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), new int[]{1})) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            return preparedStatement.executeUpdate();
        }
    }

    @Test
    public void assertExecuteUpdateWithColumnNames() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || DatabaseType.PostgreSQL == getDatabaseTypeEnvironment().getDatabaseType() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeUpdateForStatementWithColumnNames(connection) : executeUpdateForPreparedStatementWithColumnNames(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeUpdateForStatementWithColumnNames(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(String.format(getSql(), assertion.getSQLValues().toArray()));
        }
    }

    private int executeUpdateForPreparedStatementWithColumnNames(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), new String[]{"TODO"})) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            return preparedStatement.executeUpdate();
        }
    }

    @Test
    public void assertExecuteWithoutAutoGeneratedKeys() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeForStatementWithoutAutoGeneratedKeys(connection) : executeForPreparedStatementWithoutAutoGeneratedKeys(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeForStatementWithoutAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            assertFalse("Not a DML statement.", statement.execute(String.format(getSql(), assertion.getSQLValues().toArray()), Statement.NO_GENERATED_KEYS));
            return statement.getUpdateCount();
        }
    }

    private int executeForPreparedStatementWithoutAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), Statement.NO_GENERATED_KEYS)) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            assertFalse("Not a DML statement.", preparedStatement.execute());
            return preparedStatement.getUpdateCount();
        }
    }

    @Test
    public void assertExecuteWithAutoGeneratedKeys() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeForStatementWithAutoGeneratedKeys(connection) : executeForPreparedStatementWithAutoGeneratedKeys(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeForStatementWithAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            assertFalse("Not a DML statement.", statement.execute(String.format(getSql(), assertion.getSQLValues().toArray()), Statement.RETURN_GENERATED_KEYS));
            return statement.getUpdateCount();
            // TODO assert statement.getGeneratedKeys();
        }
    }

    private int executeForPreparedStatementWithAutoGeneratedKeys(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), Statement.RETURN_GENERATED_KEYS)) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            assertFalse("Not a DML statement.", preparedStatement.execute());
            return preparedStatement.getUpdateCount();
            // TODO assert preparedStatement.getGeneratedKeys();
        }
    }

    @Test
    public void assertExecuteWithColumnIndexes() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || DatabaseType.PostgreSQL == getDatabaseTypeEnvironment().getDatabaseType() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeForStatementWithColumnIndexes(connection) : executeForPreparedStatementWithColumnIndexes(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeForStatementWithColumnIndexes(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            assertFalse("Not a DML statement.", statement.execute(String.format(getSql(), assertion.getSQLValues().toArray()), new int[]{1}));
            return statement.getUpdateCount();
        }
    }

    private int executeForPreparedStatementWithColumnIndexes(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), new int[]{1})) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            assertFalse("Not a DML statement.", preparedStatement.execute());
            return preparedStatement.getUpdateCount();
        }
    }

    @Test
    public void assertExecuteWithColumnNames() throws JAXBException, IOException, SQLException, ParseException {
        // TODO fix masterslave
        if (!getDatabaseTypeEnvironment().isEnabled() || DatabaseType.PostgreSQL == getDatabaseTypeEnvironment().getDatabaseType() || "masterslave".equals(getShardingRuleType())) {
            return;
        }
        int actualUpdateCount;
        try (Connection connection = getDataSource().getConnection()) {
            actualUpdateCount = SQLCaseType.Literal == getCaseType() ? executeForStatementWithColumnNames(connection) : executeForPreparedStatementWithColumnNames(connection);
        }
        assertDataSet(actualUpdateCount);
    }

    private int executeForStatementWithColumnNames(final Connection connection) throws SQLException, ParseException {
        try (Statement statement = connection.createStatement()) {
            assertFalse("Not a DML statement.", statement.execute(String.format(getSql(), assertion.getSQLValues().toArray()), new String[]{"TODO"}));
            return statement.getUpdateCount();
        }
    }

    private int executeForPreparedStatementWithColumnNames(final Connection connection) throws SQLException, ParseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSql(), new String[]{"TODO"})) {
            for (SQLValue each : assertion.getSQLValues()) {
                preparedStatement.setObject(each.getIndex(), each.getValue());
            }
            assertFalse("Not a DML statement.", preparedStatement.execute());
            return preparedStatement.getUpdateCount();
        }
    }
}
