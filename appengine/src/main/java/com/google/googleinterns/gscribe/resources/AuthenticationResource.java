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

package com.google.googleinterns.gscribe.resources;

import com.google.googleinterns.gscribe.handlers.TokenVerificationHandler;
import com.google.googleinterns.gscribe.resources.io.AuthenticationException;
import com.google.googleinterns.gscribe.resources.io.AuthenticationResponse;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/authorize")
public class AuthenticationResource {

  private final TokenVerificationHandler tokenVerificationHandler;

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
