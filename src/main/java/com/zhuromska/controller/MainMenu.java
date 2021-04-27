package com.zhuromska.controller;

import java.util.HashMap;
import java.util.Map;

import com.zhuromska.menu.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMenu {
    private static final Logger logger = LogManager.getLogger(MainMenu.class);

    private final HashMap<Integer, Command> commands = new HashMap<>(Map.of(
            0, new ExitCommand(),
            1, new CreateRoomCommand(),
            2, new AddToyToRoomCommand(),
            3, new AddToysToRoomCommand(),
            4, new ListToysCommand(),
            5, new DeleteToyCommand(),
            6, new DeleteToysCommand(),
            7, new SortByPriceCommand(),
            8, new SortBySizeCommand(),
            9, new FindByPriceCommand()
    ));
    {
        commands.put(10, new FindBySizeCommand());
    }

    private final ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();

    public void printCommands() {
                commands.forEach((n, command) -> System.out.printf("%3d - %s\n", n, command));
    }

    public void run() {
        while (true) {
            printCommands();
            int commandNumber = scannerSingleton.getScanner().readInt();
            commands
                    .getOrDefault(commandNumber, () -> {
                        System.out.println("Please, try again. Choose command from the list above");
                        logger.warn(String.format("Can't execute command with %d number", commandNumber));
                    }).execute();
            logger.info("Successfully executed {}", () -> commands.getClass().getSimpleName());
        }
    }
}
