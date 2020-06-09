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

import java.util.ArrayList;

public class Exam {

    ArrayList<Question> questions;
    private int id;

    public Exam(int id) {
        this.id = id;
    }

    @JsonProperty
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @JsonProperty
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String ret = " id: " + id;
        for (Question question : questions) {
            ret += "\n " + question.toString();
        }
        return ret;
    }
}
