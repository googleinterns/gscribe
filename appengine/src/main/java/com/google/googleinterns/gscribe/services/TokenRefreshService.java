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

package com.google.googleinterns.gscribe.services;

import com.google.googleinterns.gscribe.models.UserToken;

import java.io.IOException;

public interface TokenRefreshService {

    /**
     * When the access Token expires then this method uses refreshToken to generate a new accessToken
     *
     * @param userToken ( contains refreshToken )
     * @throws IOException ( if credentials file is not found or invalid )
     */
    void refresh(UserToken userToken) throws IOException;

}
