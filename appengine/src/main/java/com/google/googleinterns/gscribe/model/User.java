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

package com.google.googleinterns.gscribe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class User {

    private String accessToken;
    private String refreshToken;
    private String id;
    private Timestamp timestamp;

    public User(String id, String accessToken, String refreshToken, Timestamp timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
