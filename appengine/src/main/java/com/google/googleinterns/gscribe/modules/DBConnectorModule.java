package com.google.googleinterns.gscribe.modules;

import com.google.googleinterns.gscribe.config.MySQLConfig;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.skife.jdbi.v2.DBI;

public class DBConnectorModule extends AbstractModule {

  @Inject
  @Provides
  @Singleton
  public DBI dBIProvider(MySQLConfig mySQLConfig) throws Exception {
    return new DBI(mySQLConfig.getUrl(), mySQLConfig.getUserName(), mySQLConfig.getPassword());
  }
}
