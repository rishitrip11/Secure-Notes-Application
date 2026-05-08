package com.rishi.securenotes.storage;

public class SessionManager {

    private static String currentUser;
    private static String password;

    public static void startSession(String username, String pass) {
        currentUser = username;
        password = pass;
    }

    public static String getUser() {
        return currentUser;
    }

    public static String getPassword() {
        return password;
    }

    public static void endSession() {
        currentUser = null;
        password = null;
    }
}