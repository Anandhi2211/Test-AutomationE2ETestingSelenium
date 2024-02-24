package com.solvd.testautomation.ui.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class MyListener implements ISuiteListener {

//    @Override
//    public void onStart(ISuite suite) {
//        System.out.println("Test Suite name is:"+suite.);
//    }

    @Override
    public void onFinish(ISuite suite) {
//        try {
//            FileUtils.deleteDirectory(new File("reports"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            Files.walk(Path.of("reports"))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


