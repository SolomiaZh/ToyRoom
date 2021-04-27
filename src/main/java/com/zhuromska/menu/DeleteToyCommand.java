package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteToyCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private final ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        int size = service.getAllToys().size();
        if (service.isPlayingRoomEmpty()) {
            System.out.println("Enter the index of a toy you want to delete:  ");
            int index = scannerSingleton.getScanner().readInt();
            if (index > 0 && index < size) {
                service.deleteToy(index);
                logger.info("The toy with {} index was deleted", index );
            }else {
                System.out.println("There is not such toy");
                logger.warn("User has tried to delete non-existing toy");
            }


        } else {
            logger.warn("User has tried to delete toy in empty room");
            System.out.println("The room is empty");
        }
    }

    @Override
    public String toString() {
        return "DeleteToyCommand ";
    }
}
