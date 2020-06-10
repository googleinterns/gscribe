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

package com.google.googleinterns.gscribe.dao.data;

public class UserToken {

    private final String id;
    private final String accessToken;
    private final String refreshToken;
    private final long timestamp;

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
