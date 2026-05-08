package com.rishi.securenotes;

import com.rishi.securenotes.service.*;
import com.rishi.securenotes.storage.SessionManager;
import com.rishi.securenotes.ui.*;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LoginUI loginUI = new LoginUI();

            loginUI.addLoginListener(e -> {

                String user = loginUI.getUsername();
                String pass = new String(loginUI.getPassword());

                if (loginUI.isLoginMode()) {

                    if (AuthService.login(user, pass)) {

                        SessionManager.startSession(user, pass);
                        loginUI.dispose();
                        openDashboard(user);

                    } else {
                        loginUI.showError("Invalid credentials ");
                    }

                } else {

                    if (AuthService.register(user, pass)) {
                        loginUI.showSuccess("Registered ");
                    } else {
                        loginUI.showError("User exists ");
                    }
                }
            });

            loginUI.setVisible(true);
        });
    }

    private static void openDashboard(String username) {

        DashboardUI dashboard = new DashboardUI();
        NoteService service = new NoteService();

        dashboard.setUsername(username);

        Runnable refresh = () -> {

            List<ViewNotesUI.NoteRow> notes = service.getNotes();
            dashboard.setNoteStats(notes.size(), notes.size());
        };

        refresh.run();


        dashboard.addCreateNoteListener(e -> {

            NoteEditorUI editor = new NoteEditorUI();

            editor.addSaveListener(ev -> {

                service.saveNote(
                        editor.getNoteTitle(),
                        editor.getNoteContent()
                );

                editor.dispose();
                refresh.run();
            });

            editor.setVisible(true);
        });


        dashboard.addViewNotesListener(e -> {

            dashboard.setVisible(false);

            ViewNotesUI view = new ViewNotesUI();
            List<ViewNotesUI.NoteRow> notes = service.getNotes();

            view.setNotes(notes);


            view.addDecryptListener(ev -> {

                int i = view.getSelectedIndex();

                if (i != -1) {

                    String decrypted = service.decryptNote(notes.get(i).content);

                    view.setPreviewContent(decrypted, false);
                }
            });


            view.addDeleteListener(ev -> {

                int i = view.getSelectedIndex();

                if (i != -1) {

                    service.deleteNote(notes.get(i).id);

                    List<ViewNotesUI.NoteRow> updated = service.getNotes();
                    view.setNotes(updated);
                }
            });

            view.addBackListener(ev -> {
                view.dispose();
                dashboard.setVisible(true);
                refresh.run();
            });

            view.setVisible(true);
        });

        dashboard.setVisible(true);
    }
}