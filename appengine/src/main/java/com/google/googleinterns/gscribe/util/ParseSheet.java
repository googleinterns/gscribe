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

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.googleinterns.gscribe.dao.impl.TokenDAOImpl;
import com.google.googleinterns.gscribe.model.ExamMetadata;
import com.google.googleinterns.gscribe.model.Token;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.List;

public class ParseSheet {

    private int getNumberOfQuestions(Sheets service, String spreadsheetId, String sheetName) throws IOException {
        final String noOfQuestionsChecker = sheetName + "!A:A";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, noOfQuestionsChecker).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            return 0;
        } else {
            return values.size();
        }
    }

    public List<List<Object>> processQuestionPaper(ExamMetadata metadata) throws IOException, GeneralSecurityException, SQLException {

        Token token = new TokenDAOImpl().getTokenForUser(metadata.getUserID(), null);
        token.refreshToken();

        // Set access token to get the spreadsheet Instance
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(token.getAccessToken());
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName("Gscribe").build();

        // Get duration of exam
        String range = metadata.getSheetName() + "!B1:B1";
        ValueRange response = service.spreadsheets().values().get(metadata.getSpreadsheetID(), range).execute();
        List<List<Object>> durationOfExam = response.getValues();
        int duration;
        if (durationOfExam.isEmpty() || durationOfExam.get(0).isEmpty()) {
            System.out.println("Empty field");
            return null;
        }
        try {
            duration = Integer.parseInt(durationOfExam.get(0).get(0).toString());
            if (duration <= 0 || duration > 300) {
                System.out.print("Duration of exam not in a valid range");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.print("Duration of exam not in a valid range");
            return null;
        }
        metadata.setDuration(duration);

        // Getting all the questions from the spreadsheet
        int numberOfQuestions = getNumberOfQuestions(service, metadata.getSpreadsheetID(), metadata.getSheetName());
        range = metadata.getSheetName() + "!A3:G" + numberOfQuestions;
        response = service.spreadsheets().values().get(metadata.getSpreadsheetID(), range).execute();
        List<List<Object>> exam = response.getValues();

        boolean isPaperCorrect = new ValidateExam().isCorrect(exam);
        if (!isPaperCorrect) {
            return null;
        }
        return exam;
    }

}
