package com.example.admintor.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OpenFileImpl extends Component implements OpenFile {
    String path = "";
    @Override
    @NonNull
    public String openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                path = selectedFile.getAbsolutePath();
            }
        }
        if (path == null || path.isEmpty()) {
            return "0";
        }

        return path;
    }

    @Override
    @NonNull
    public List<String> readerFile() {
        List<String> internalList = new ArrayList<>();
        if (!this.path.isEmpty()) {

            try (Stream<String> stream = Files.lines(Paths.get(this.path))) {
                internalList = stream.collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return internalList;
    }
}
