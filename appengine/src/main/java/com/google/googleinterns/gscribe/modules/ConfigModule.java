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
