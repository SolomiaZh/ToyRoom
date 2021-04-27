package com.zhuromska.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExitCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public void execute() {
        System.out.println("Exiting...");
        logger.info("The program was successfully finished" );
        System.exit(0);
    }

    @Override
    public String toString() {
        return "ExitCommand";
    }
}
