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

import com.google.googleinterns.gscribe.model.Exam;
import com.google.googleinterns.gscribe.model.Question;
import com.google.googleinterns.gscribe.model.QuestionType;

import java.util.ArrayList;
import java.util.List;

public class CreateExam {

    public Exam create(List<List<Object>> examList, int examID) {
        Exam exam = new Exam(examID);
        int totalQuestions = examList.size();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < totalQuestions; i++) {
            List<Object> question = examList.get(i);
            Question newQuestion = new Question();
            newQuestion.setStatement((String) question.get(1));
            if (question.get(0).equals("MCQ")) {
                newQuestion.setType(QuestionType.MCQ);
                ArrayList<String> options = new ArrayList<>();
                options.add((String) question.get(2));
                options.add((String) question.get(3));
                options.add((String) question.get(4));
                options.add((String) question.get(5));
                newQuestion.setOptions(options);
            }
            if (question.get(0).equals("SUBJECTIVE")) {
                newQuestion.setType(QuestionType.SUBJECTIVE);
                newQuestion.setOptions(new ArrayList<>());
            }
            newQuestion.setPoints(Integer.parseInt((String) question.get(6)));
            newQuestion.setNumber(i + 1);
            questions.add(newQuestion);
        }
        exam.setQuestions(questions);
        return exam;
    }

}
