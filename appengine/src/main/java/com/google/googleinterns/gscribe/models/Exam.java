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


import java.util.Objects;

public class Exam {

    private ExamMetadata examMetadata;
    private Questions questions;

    public Exam() {
    }

    public Exam(ExamMetadata examMetadata, Questions questions) {
        this.examMetadata = examMetadata;
        this.questions = questions;
    }

    public ExamMetadata getExamMetadata() {
        return examMetadata;
    }

    public void setExamMetadata(ExamMetadata examMetadata) {
        this.examMetadata = examMetadata;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;
        Exam exam = (Exam) o;
        return examMetadata.equals(exam.examMetadata) &&
                questions.equals(exam.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examMetadata, questions);
    }
}
