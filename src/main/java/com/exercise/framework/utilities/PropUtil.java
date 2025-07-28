package com.exercise.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
    public static Properties readData(String fileName) {
        Properties prop = new Properties();

        try {
            // Construct the file path using the user's working directory and the `Config` folder
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Config\\" + fileName);

            // Load all the properties available within the file into the `prop` variable
            prop.load(fis);

        } catch (FileNotFoundException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        } catch (IOException e) {
            // Print stack trace if an I/O error occurs
            System.err.println("Error loading properties file: " + e.getMessage());
        }

        return prop;
    }

}
