package com.google.googleinterns.gscribe.resources.io;

public class AuthenticationRequest {

  private String accessToken;

  // Required for deserialization
  private AuthenticationRequest() {
  }

  public AuthenticationRequest(String accessToken) {
    this.accessToken = accessToken;
  }
}
