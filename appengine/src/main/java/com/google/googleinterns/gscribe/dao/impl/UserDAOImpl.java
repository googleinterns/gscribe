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

import com.google.googleinterns.gscribe.dao.UserDAO;
import com.google.googleinterns.gscribe.model.User;
import com.google.googleinterns.gscribe.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public String save(User user, Connection con) throws SQLException {
        String status = "";
        if (user.getAccessToken() == null || user.getId() == null || user.getRefreshToken() == null) {
            status = "ERROR: credentials missing in user class";
            return status;
        }
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "INSERT into user(id,access_token,refresh_token) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getId());
            pst.setString(2, user.getAccessToken());
            pst.setString(3, user.getRefreshToken());
            pst.execute();
            status = "Successful";
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
    public User getUserByID(String id, Connection con) throws SQLException {
        User user = null;
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "SELECT access_token, refresh_token, id, timestamp from user where id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("access_token"), rs.getString("refresh_token"), rs.getTimestamp("timestamp"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public String updateAccessToken(User user, Connection con) throws SQLException {
        String status = "";
        if (user.getAccessToken() == null || user.getId() == null) {
            status = "ERROR: credentials missing in user class";
            return status;
        }
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "UPDATE user set access_token = ? where id = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getAccessToken());
            pst.setString(2, user.getId());
            pst.execute();
            status = "Successful";
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
    public String updateTokens(User user, Connection con) throws SQLException {
        String status = "";
        if (user.getAccessToken() == null || user.getId() == null || user.getRefreshToken() == null) {
            status = "ERROR: credentials missing in user class";
            return status;
        }
        if (con == null) con = new DatabaseConnection().getConnection();
        try {
            String query = "UPDATE user set access_token = ?, refresh_token = ?, timestamp = CURRENT_TIMESTAMP where id = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getAccessToken());
            pst.setString(1, user.getRefreshToken());
            pst.setString(3, user.getId());
            pst.execute();
            status = "Successful";
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
