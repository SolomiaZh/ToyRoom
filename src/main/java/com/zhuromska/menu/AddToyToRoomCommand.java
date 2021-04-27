package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.model.Answer;
import com.zhuromska.service.PlayingRoomService;
import com.zhuromska.util.GenerateToy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class AddToyToRoomCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        if (service.isPlayingRoomExisting()) {
            System.out.print("Are you sure you want to add a new toy?"
                    + (service.isPlayingRoomEmpty() ? " (Y/N) " : " Because it will be beyond your budget. (Y/N)") );
            Answer answer = ScannerSingleton.getInstance().getScanner().readYN();
            if (answer == Answer.YES) {
                logger.info("A user wants to add new toy to the room");
                service.addToy(GenerateToy.generateToy(new Random().nextInt(5)));
                System.out.println("Successfully added a new toy");

            } else {
                System.out.println("Nothing was changed");
                logger.info("User has chosen not to add a new toy");
            }
        } else {
            logger.warn("An attempt to add toy to add toy to non-existing room");
            System.out.println("Firstly create playing room");
        }
    }

    @Override
    public String toString() {
        return "AddToyToRoomCommand";
    }
}
