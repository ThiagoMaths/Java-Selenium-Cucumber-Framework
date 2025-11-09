package com.tutorialsninja.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyFileReader implements ConfigurationReader {


    private static final Logger log = LoggerFactory.getLogger(PropertyFileReader.class);

    private static final String CONFIG_FILE = "ConfigurationFile/config.properties";
    private static final String URL_KEY = "url";
    private static final String BROWSER_KEY = "browser";
    private static final String PAGE_LOAD_TIMEOUT_KEY = "pageLoadTimeout";



    private final Properties properties;

    public PropertyFileReader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IOException("Configuration file not found: " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            log.error("Error loading configuration file : {}", CONFIG_FILE, e);
            throw new RuntimeException("Failed to load configuration file.", e);
        }
    }


    @Override
    public String getUrl() {
        return properties.getProperty(URL_KEY);
    }

    @Override
    public String getBrowser() {
        return properties.getProperty(BROWSER_KEY);
    }

    @Override
    public int getPageLoadTimeOut() {
        return Integer.parseInt(properties.getProperty(PAGE_LOAD_TIMEOUT_KEY));
    }


}
