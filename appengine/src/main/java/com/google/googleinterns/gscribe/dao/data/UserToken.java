package com.google.googleinterns.gscribe.dao.data;

public class UserToken {

  private String id;
  private String accessToken;
  private String refreshToken;
  private long timestamp;

  public UserToken(String id, String accessToken, String refreshToken, long timestamp) {
    this.id = id;
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
    this.timestamp = timestamp;
  }

  public String getId() {
    return id;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public long getTimestamp() {
    return timestamp;
  }
}
