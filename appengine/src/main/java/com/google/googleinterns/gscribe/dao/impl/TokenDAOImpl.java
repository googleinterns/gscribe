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

import com.google.googleinterns.gscribe.dao.TokenDAO;
import com.google.googleinterns.gscribe.model.Token;
import com.google.googleinterns.gscribe.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDAOImpl implements TokenDAO {

    @Override
    public Token getTokenForUser(String userID, Connection con) throws SQLException {
        Token token = null;
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "SELECT id,access_token,refresh_token,timestamp from user where id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                token = new Token(rs.getString("id"), rs.getString("access_token"), rs.getString("refresh_token"), rs.getTimestamp("timestamp"));
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
        return token;
    }

    @Override
    public String postToken(Token token, Connection con) throws SQLException {
        String status = null;
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "INSERT INTO user( id,access_token,refresh_token ) VALUES ( ?,?,? )";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, token.getUserID());
            pst.setString(2, token.getAccessToken());
            pst.setString(3, token.getRefreshToken());
            pst.execute();
            status = "Successful";
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

}
