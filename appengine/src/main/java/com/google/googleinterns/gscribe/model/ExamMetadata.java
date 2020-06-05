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

public class ExamMetadata {

    private String spreadsheetID;
    private String sheetName;
    private String userID;
    private int id;
    private int duration;
    private Timestamp createdOn;

    @JsonProperty
    public String getSpreadsheetID() {
        return spreadsheetID;
    }

    @JsonProperty
    public void setSpreadsheetID(String spreadsheetID) {
        this.spreadsheetID = spreadsheetID;
    }

    @JsonProperty
    public String getSheetName() {
        return sheetName;
    }

    @JsonProperty
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    @JsonProperty
    public String getUserID() {
        return userID;
    }

    @JsonProperty
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public int getDuration() {
        return duration;
    }

    @JsonProperty
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    @JsonProperty
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;

    }
}
