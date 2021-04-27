package com.zhuromska.menu;

import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortBySizeCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    private final PlayingRoomService service = PlayingRoomService.getInstance();

    @Override
    public void execute() {
        if (service.isPlayingRoomEmpty()) {
            service.changeAllToys(service.getToysSortedListBySize());
            logger.info("The toys were sorted by size");
        } else {
            logger.warn("User has tried to sort toys by size in empty room");
            System.out.println("Firstly fill the room");
        }
    }

    @Override
    public String toString() {
        return "SortBySizeCommand{}";
    }
}
