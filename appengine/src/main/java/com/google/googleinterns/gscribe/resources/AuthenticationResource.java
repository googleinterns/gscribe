package com.google.googleinterns.gscribe.resources;

import com.google.googleinterns.gscribe.handlers.TokenVerificationHandler;
import com.google.googleinterns.gscribe.resources.io.AuthenticationException;
import com.google.googleinterns.gscribe.resources.io.AuthenticationResponse;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/authorize")
public class AuthenticationResource {

  private TokenVerificationHandler tokenVerificationHandler;

  @Inject
  public AuthenticationResource(
      TokenVerificationHandler tokenVerificationHandler) {
    this.tokenVerificationHandler = tokenVerificationHandler;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AuthenticationResponse saveToken(@HeaderParam("authorization-code") String idToken,
      String accessCode)
      throws AuthenticationException {
    try {
      tokenVerificationHandler.verify(null);
      // Add relevant code here
      return new AuthenticationResponse();
    } catch (Exception e) {
      throw new AuthenticationException("Unable to Authenticate User");
    }
  }
}
