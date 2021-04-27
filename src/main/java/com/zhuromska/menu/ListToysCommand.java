package com.zhuromska.menu;

import com.zhuromska.model.Toy;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListToysCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        if (service.isPlayingRoomExisting()) {
            List<Toy> list = service.getAllToys();
            int len = list.size();
            for (int i = 0; i < len; i++) {
                System.out.println(i + " " + list.get(i));
            }
            logger.info("The list of commands was printed");
        } else {
            logger.warn("User has tried to print the list of toys in non-existing room");
            System.out.println("Firstly create playing room");
        }
    }

    @Override
    public String toString() {
        return "ListToysCommand";
    }
}
