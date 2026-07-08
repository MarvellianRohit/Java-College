package com.playground;

import com.playground.core.*;
import com.playground.libraries.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("====================================================");
        logger.info("   JAVA PLAYGROUND & CORE REFERENCE ENVIRONMENT     ");
        logger.info("====================================================");

        // --- Core Java Features ---
        CollectionsDemo.runDemo();
        StreamsDemo.runDemo();
        ConcurrencyDemo.runDemo();
        FileIODemo.runDemo();
        NetworkingDemo.runDemo();

        // --- Third-Party Libraries ---
        JacksonDemo.runDemo();
        LombokDemo.runDemo();
        GuavaDemo.runDemo();

        logger.info("====================================================");
        logger.info("        ALL DEMONSTRATIONS EXECUTED SUCCESSFULLY    ");
        logger.info("====================================================");
    }
}
