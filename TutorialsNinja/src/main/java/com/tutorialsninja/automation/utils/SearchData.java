package com.tutorialsninja.automation.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchData {

    private static final Logger logger = LoggerFactory.getLogger(SearchData.class);

    public static List<String> getSearchTerms() {
        List<String> searchTerms = new ArrayList<>();
        InputStream inputStream = SearchData.class.getClassLoader().getResourceAsStream("products.csv"); // Caminho relativo ao classpath

        if (inputStream == null) {
            logger.error("Arquivo products.csv não encontrado no classpath.");
            throw new RuntimeException("Arquivo products.csv não encontrado no classpath.");
        }

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                searchTerms.add(nextLine[0]);
            }
        } catch (IOException | CsvValidationException e) {
            logger.error("Erro ao ler o arquivo CSV: " + e.getMessage(), e);
            throw new RuntimeException("Erro ao ler o arquivo CSV: " + e.getMessage(), e);
        }

        return searchTerms;
    }

    public static void main(String[] args) {
        List<String> searchTerms = getSearchTerms();
        if (searchTerms != null) {
            for (String searchTerm : searchTerms) {
                System.out.println(searchTerm);
            }
        }
    }
}
