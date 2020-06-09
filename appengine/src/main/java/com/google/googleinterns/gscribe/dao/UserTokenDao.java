package com.google.googleinterns.gscribe.dao;

import com.google.googleinterns.gscribe.dao.data.UserToken;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public interface UserTokenDao {

  class UserTokenMapper implements ResultSetMapper<UserToken> {

    @Override
    public UserToken map(int i, ResultSet resultSet, StatementContext statementContext)
        throws SQLException {
      return new UserToken(
          resultSet.getString("id"),
          resultSet.getString("access_token"),
          resultSet.getString("refresh_token"),
          resultSet.getLong("timestamp")
      );
    }
  }

  @Mapper(UserTokenMapper.class)
  @SqlQuery("SELECT * from user where id = :id")
  UserToken getUserToken(@Bind("id") String id);

  @SqlUpdate("INSERT INTO user( id, access_token, refresh_token ) VALUES ( :id, :accessToken, :refreshToken )")
  void insertUserToken(@BindBean UserToken userToken);
}
