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

package com.google.googleinterns.gscribe.models;

public class Question {

    private final QuestionType type;
    private final String statement;
    private final int points;
    private final int questionNumber;


    public Question(QuestionType type, String statement, int points, int questionNumber) {
        this.type = type;
        this.statement = statement;
        this.points = points;
        this.questionNumber = questionNumber;
    }

    public QuestionType getType() {
        return type;
    }

    public String getStatement() {
        return statement;
    }

    public int getPoints() {
        return points;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

}
