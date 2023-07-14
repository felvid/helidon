/*
 * Copyright (c) 2020, 2023 Oracle and/or its affiliates.
 *
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
 */
package io.helidon.tests.integration.dbclient.app.tests;

import java.util.Map;
import java.util.Optional;

import io.helidon.dbclient.DbClient;
import io.helidon.dbclient.DbRow;

/**
 * Service to test simple get statements.
 */
public class SimpleGetService extends AbstractGetService {

    /**
     * Creates an instance of web resource to test set of basic DbClient gets.
     *
     * @param dbClient   DbClient instance
     * @param statements statements from configuration file
     */
    public SimpleGetService(DbClient dbClient, Map<String, String> statements) {
        super(dbClient, statements);
    }

    @Override
    protected Optional<DbRow> testCreateNamedGetStrStrNamedArgs(String name) {
        return dbClient().execute()
                .createNamedGet("select-pikachu", statement("select-pokemon-named-arg"))
                .addParam("name", name)
                .execute();
    }

    @Override
    protected Optional<DbRow> testCreateNamedGetStrNamedArgs(String name) {
        return dbClient().execute()
                .createNamedGet("select-pokemon-named-arg")
                .addParam("name", name)
                .execute();
    }

    @Override
    protected Optional<DbRow> testCreateNamedGetStrOrderArgs(String name) {
        return dbClient().execute()
                .createNamedGet("select-pokemon-order-arg")
                .addParam(name)
                .execute();
    }

    @Override
    protected Optional<DbRow> testCreateGetNamedArgs(String name) {
        return dbClient().execute()
                .createGet(statement("select-pokemon-named-arg"))
                .addParam("name", name)
                .execute();
    }

    @Override
    protected Optional<DbRow> testCreateGetOrderArgs(String name) {
        return dbClient().execute()
                .createGet(statement("select-pokemon-order-arg"))
                .addParam(name)
                .execute();
    }

    @Override
    protected Optional<DbRow> testNamedGetStrOrderArgs(String name) {
        return dbClient().execute()
                .namedGet("select-pokemon-order-arg", name);
    }

    @Override
    protected Optional<DbRow> testGetStrOrderArgs(String name) {
        return dbClient().execute()
                .get(statement("select-pokemon-order-arg"), name);
    }
}
