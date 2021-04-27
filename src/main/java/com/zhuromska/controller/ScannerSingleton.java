package com.zhuromska.controller;

import com.zhuromska.model.Answer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerSingleton {
    final private static Logger logger = LogManager.getLogger();

    public static class ScannerWrapper {

        private final Scanner scanner;


        private ScannerWrapper(InputStream source) {
            this.scanner = new Scanner(source);
        }

        public Scanner getScanner() {
            return scanner;
        }

        public Answer readYN() {
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Y")) {
                return Answer.YES;
            } else if (answer.equalsIgnoreCase("N")) {
                return Answer.NO;
            } else {
                logger.warn("Can't read Y/N answer from scanner");
                System.out.println("Please, try again. Answer Y/N");
                return readYN();
            }
        }

        public int readInt() {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                logger.warn("Can't read int from scanner");
                System.out.println("Incorrect format(int). Try again...");
                return readInt();
            }
        }
        public String readString() {
            while (true) {
                if (scanner.hasNext()) {
                    return scanner.next();
                } else {
                    System.out.println("Incorrect format(String). Try again...");
                }
            }
        }
    }

    private static ScannerSingleton instance;

    private final ScannerWrapper scanner;

    private ScannerSingleton() {
        scanner = new ScannerWrapper(System.in);
    }

    public ScannerWrapper getScanner() {
        return scanner;
    }

    public static ScannerSingleton getInstance() {
        if (instance == null) {
            instance = new ScannerSingleton();
        }
        return instance;
    }
}
