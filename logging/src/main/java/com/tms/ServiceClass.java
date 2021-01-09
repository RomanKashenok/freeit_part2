package com.tms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceClass {

    private final static Logger logger = LogManager.getLogger(ServiceClass.class);

    public static void doSomething() {
        int i = 10;
        int a = 5;
        int result = i * a;

        logger.debug("Result of mult 10 on 5 = {}", result);

        try {
            result = i / 0;
        } catch (Exception ex) {
            logger.warn("Error while div 10 on 0 : {}", ex.getLocalizedMessage());
        }

    }

    public static void doSomethingElse() {
        int i = 10;
        int a = 5;

        int result = i / a;
    }
}
