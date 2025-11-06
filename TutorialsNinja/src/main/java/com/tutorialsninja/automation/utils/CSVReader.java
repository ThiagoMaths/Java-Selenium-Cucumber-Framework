package com.tutorialsninja.automation.utils;

import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    private static final String CSV_PATH = "src//test//resources//csv//products.csv";
    private static final String INVALID_CSV_PATH = "src//test//resources//csv//productInvalid.csv";

    private static String readRandom(String csvPath) throws IOException {
        String randomString = null;
        try (com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(new FileReader(new File(csvPath)))) {
            List<List<String>> lines = new ArrayList<>();
            String[] columns;

            while ((columns = csvReader.readNext()) != null) {
                lines.add(Collections.singletonList(columns[0].trim()));
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                randomString = lines.get(randomIndex).get(0);
            }

        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return randomString;
    }

    public static String readCSVFile() throws IOException {
        return readRandom(CSV_PATH);
    }

    public static String readInvalidCSVFile() throws IOException {
        return readRandom(INVALID_CSV_PATH);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readCSVFile());
        System.out.println(readInvalidCSVFile());
    }


}
