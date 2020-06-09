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

package com.google.googleinterns.gscribe.util;

import java.util.List;

public class ValidateExam {

    // Validate correct points allotted to the question
    boolean validPoints(String pointsAllotted) {
        try {
            int points = Integer.parseInt(pointsAllotted);
            if (points <= 0 || points > 100) {
                System.out.print("Points for the question not a valid range");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.print("Points for the question not a valid integer");
            return false;
        }
        return true;
    }

    // Validate MCQ type of questions
    boolean checkMCQQuestion(List<Object> question) {
        boolean questionCorrect = true;
        if (question.get(1).equals("")) {
            questionCorrect = false;
            System.out.print("Question statement missing ");
        }
        for (int i = 2; i < 6; i++) {
            if (question.get(i).equals("")) {
                questionCorrect = false;
                System.out.print("Question option missing ");
            }
        }
        questionCorrect = questionCorrect & validPoints((String) question.get(6));
        return questionCorrect;
    }

    // Validate Subjective type of questions
    boolean checkSubjectiveQuestion(List<Object> question) {
        boolean questionCorrect = true;
        if (question.get(1).equals("")) {
            questionCorrect = false;
            System.out.print("Question statement missing ");
        }
        for (int i = 2; i < 6; i++) {
            if (!question.get(i).equals("")) {
                questionCorrect = false;
                System.out.print("Question option extra ");
            }
        }
        questionCorrect = questionCorrect & validPoints((String) question.get(6));
        return questionCorrect;
    }

    // Check if the given exam question paper is correct or not
    boolean isCorrect(List<List<Object>> exam) {
        int totalQuestions = exam.size();
        boolean examCorrect = true;

        // Validate each question
        for (int i = 0; i < totalQuestions; i++) {
            List<Object> currentQuestion = exam.get(i);
            if (currentQuestion.size() != 7) {
                System.out.println("Question " + i + "fields are not 7");
                examCorrect = false;
            } else {
                // Check question based on question type
                if (currentQuestion.get(0).equals("MCQ")) {
                    examCorrect = examCorrect & checkMCQQuestion(currentQuestion);
                } else if (currentQuestion.get(0).equals("SUBJECTIVE")) {
                    examCorrect = examCorrect & checkSubjectiveQuestion(currentQuestion);
                } else {
                    examCorrect = false;
                    System.out.println("Wrong value at isMCQ field");
                }
            }
        }
        return examCorrect;
    }

}
