package com.zhuromska.menu;


import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddToysToRoomCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private final ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {

        System.out.println("Enter your budget:  ");
        int sum = scannerSingleton.getScanner().readInt();
        if (service.isPlayingRoomExisting()) {
            System.out.printf("Successfully added %d toys to the room", service.generateToys(sum));
            logger.info("Successfully added {} toys to the room", service.generateToys(sum));
        } else {
            logger.warn("Cannot add toys to non-existing room");
            System.out.println("Firstly create playing room");

        }
    }

    @Override
    public String toString() {
        return "AddToysToRoomCommand";
    }
}
