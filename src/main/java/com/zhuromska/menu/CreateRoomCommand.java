package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.model.Answer;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateRoomCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        if (service.isPlayingRoomExisting()) {
            System.out.println("Are you sure that you want to delete existing playing room and create new? (Y/N)");
            Answer answer = ScannerSingleton.getInstance().getScanner().readYN();
            if (answer == Answer.YES) {
                logger.info("User has decided to remove existing room and create a new one");
                service.createNewRoom();
                System.out.println("Successfully removed old room and created new");
            }else{
                logger.info("User has decided to not create a new one");
            }
        } else {
            service.createNewRoom();
            System.out.println("Successfully created room");
        }
    }

    @Override
    public String toString() {
        return "CreateRoomCommand";
    }
}
