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

package com.google.googleinterns.gscribe.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.googleinterns.gscribe.dao.ExamDAO;
import com.google.googleinterns.gscribe.model.Exam;
import com.google.googleinterns.gscribe.model.ExamMetadata;
import com.google.googleinterns.gscribe.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDAOImpl implements ExamDAO {

    @Override
    public int saveExamMetadata(ExamMetadata metadata, Connection con) throws SQLException {
        int id = -1;
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "INSERT INTO exam( created_by,spreadsheet_id,duration ) VALUES ( ?,?,? )";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, metadata.getUserID());
            pst.setString(2, metadata.getSpreadsheetID());
            pst.setInt(3, metadata.getDuration());
            pst.execute();
            query = "SELECT LAST_INSERT_ID() as id";
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    @Override
    public String saveExam(Exam exam, Connection con) throws SQLException {
        String status = null;
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "INSERT INTO questions( exam_id,question_num,question ) VALUES ( ?,?,? )";
            PreparedStatement pst = con.prepareStatement(query);
            ObjectMapper mapper = new ObjectMapper();
            pst.setInt(1, exam.getId());
            for (int i = 0; i < exam.getQuestions().size(); i++) {
                pst.setInt(2, i + 1);
                pst.setString(3, mapper.writeValueAsString(exam.getQuestions().get(i)));
                pst.execute();
            }
            status = "Successful";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }

    @Override
    public Exam getExam(String id, Connection con) {
        return null;
    }

    @Override
    public Exam getExamsByUser(String userID, Connection con) {
        return null;
    }
}
