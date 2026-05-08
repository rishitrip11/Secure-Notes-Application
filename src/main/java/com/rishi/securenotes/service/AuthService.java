package com.rishi.securenotes.service;

import com.rishi.securenotes.storage.DBConnection;
import com.rishi.securenotes.utils.PasswordHasher;

import java.sql.*;

public class AuthService {


    public static boolean register(String user, String pass) {

        try (Connection con = DBConnection.getConnection()) {


            String checkSql = "SELECT * FROM users WHERE username=?";
            PreparedStatement checkStmt = con.prepareStatement(checkSql);
            checkStmt.setString(1, user);

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                System.out.println("User already exists");
                return false;
            }


            String insertSql = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(insertSql);

            insertStmt.setString(1, user);
            insertStmt.setString(2, PasswordHasher.hash(pass));

            insertStmt.executeUpdate();

            System.out.println("User registered successfully");
            return true;

        } catch (SQLException e) {
            System.out.println("SQL ERROR during register:");
            e.printStackTrace();
            return false;

        } catch (Exception e) {
            System.out.println("GENERAL ERROR during register:");
            e.printStackTrace();
            return false;
        }
    }


    public static boolean login(String user, String pass) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, user);
            stmt.setString(2, PasswordHasher.hash(pass));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Invalid credentials");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("SQL ERROR during login:");
            e.printStackTrace();
            return false;

        } catch (Exception e) {
            System.out.println("GENERAL ERROR during login:");
            e.printStackTrace();
            return false;
        }
    }
}