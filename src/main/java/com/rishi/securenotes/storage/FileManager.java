package com.rishi.securenotes.storage;

import java.io.*;

public class FileManager {

    public static void write(String path, String data) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(data + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Write error");
        }
    }

    public static String readAll(String path) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            return "";
        }

        return sb.toString();
    }

    public static void overwrite(String path, String data) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(data);
        } catch (Exception e) {
            throw new RuntimeException("Overwrite error");
        }
    }
}