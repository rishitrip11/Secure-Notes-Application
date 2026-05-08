package com.rishi.securenotes.service;

import com.rishi.securenotes.storage.FileManager;

public class ExportService {

    public static void export(String user) {
        String data = FileManager.readAll("src/main/resources/data/notes/" + user + ".txt");
        FileManager.overwrite("src/main/resources/data/" + user + "_export.enc", data);
    }
}