package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.model.Answer;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteToysCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        if (service.isPlayingRoomEmpty()) {
            System.out.println("Are you sure that you want to delete all toys? (Y/N)");
            Answer answer = ScannerSingleton.getInstance().getScanner().readYN();
            if (answer == Answer.YES) {
                service.deleteAllToys();
                System.out.println("Successfully removed all toys");
                logger.info("All toys were deleted");
            } else {
                logger.info("User has changed their mind and hasn't deleted toys");
                System.out.println("Nothing was changed");
            }
        } else {
            logger.warn("User has tried to delete toys in empty room");
            System.out.println("The room is empty");
        }
    }

    @Override
    public String toString() {
        return "DeleteToysCommand";
    }
}
