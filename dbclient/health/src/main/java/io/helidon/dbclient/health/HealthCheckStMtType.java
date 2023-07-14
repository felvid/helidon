/*
 * Copyright (c) 2021, 2023 Oracle and/or its affiliates.
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
package io.helidon.dbclient.health;

import java.util.HashMap;
import java.util.Map;

/**
 * Health check statement type.
 */
enum HealthCheckStMtType {

    /** Statement typeName: DML. */
    DML("dml"),
    /** Statement typeName: QUERY. */
    QUERY("query");

    static final int SIZE = HealthCheckStMtType.values().length;

    // Configuration strings resolver based on types enum content.
    private static final Map<String, HealthCheckStMtType> NAME_TO_TYPE = new HashMap<>(SIZE);

    // Initialize resolver content.
    static {
        for (HealthCheckStMtType value : HealthCheckStMtType.values()) {
            NAME_TO_TYPE.put(value.typeName, value);
        }
    }

    // Converts typeName name from Config to  HealthCheckStMtType instance
    // Returns null when name matches no existing typeName name
    static HealthCheckStMtType nameToType(String typeName) {
        return (NAME_TO_TYPE.get(typeName.toLowerCase()));
    }

    // Name of the statement typeName in Config node
    private final String typeName;

    HealthCheckStMtType(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Name of the statement typeName.
     *
     * @return Name of the statement typeName to be stored in {@code db.health-check} {@code Config}.
     */
    String typeName() {
        return typeName;
    }

}
