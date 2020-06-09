/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.googleinterns.gscribe.modules;

import com.google.googleinterns.gscribe.Environment;
import com.google.googleinterns.gscribe.config.MySQLConfig;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ConfigModule extends AbstractModule {

    private final Environment environment;

    public ConfigModule(Environment environment) {
        this.environment = environment;
    }

    @Provides
    @Singleton
    public MySQLConfig mySQLConfigProvider() {
        // TODO: Return based on the environment
        return new MySQLConfig("jdbc:mysql://localhost:3306/gscribe", "root", "password");
    }
}
