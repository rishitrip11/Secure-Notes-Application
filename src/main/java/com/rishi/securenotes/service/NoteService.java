package com.rishi.securenotes.service;

import com.rishi.securenotes.storage.DBConnection;
import com.rishi.securenotes.storage.SessionManager;
import com.rishi.securenotes.ui.ViewNotesUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteService {


    public void saveNote(String title, String content) {

        String query = "INSERT INTO notes (title, content, username) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            String encrypted = EncryptionService.encrypt(
                    content,
                    SessionManager.getPassword()
            );

            ps.setString(1, title);
            ps.setString(2, encrypted);
            ps.setString(3, SessionManager.getUser());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<ViewNotesUI.NoteRow> getNotes() {

        List<ViewNotesUI.NoteRow> notes = new ArrayList<>();

        String query = "SELECT id, title, content FROM notes WHERE username=? ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, SessionManager.getUser());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                notes.add(new ViewNotesUI.NoteRow(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notes;
    }


    public void deleteNote(int id) {

        String query = "DELETE FROM notes WHERE id=? AND username=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.setString(2, SessionManager.getUser());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String decryptNote(String encrypted) {

        return EncryptionService.decrypt(
                encrypted,
                SessionManager.getPassword()
        );
    }
}