package com.tms;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;

import java.io.IOException;

public class Runner {

    private final static Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {

        MapMessage mm = new MapMessage();
        mm.put("msg1", "Message one");
        mm.put("msg2", "Message two");

        logger.log(Level.DEBUG, mm);

        logger.debug("Message from direct debug");

        ServiceClass.doSomething();

    }
}
