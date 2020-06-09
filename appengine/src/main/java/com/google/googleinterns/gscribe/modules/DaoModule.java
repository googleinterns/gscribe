package com.google.googleinterns.gscribe.modules;

import com.google.googleinterns.gscribe.dao.UserTokenDao;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.skife.jdbi.v2.DBI;

public class DaoModule extends AbstractModule {

  @Inject
  @Provides
  @Singleton
  public UserTokenDao userTokenDaoProvider(DBI dbi) {
    return dbi.onDemand(UserTokenDao.class);
  }
}
