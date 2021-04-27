package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.model.Size;
import com.zhuromska.model.Toy;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class FindBySizeCommand implements Command {

    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private final ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void execute() {
        System.out.println("Choose the size of a toy you want to find: \tTiny, small, big or enormous");
        String answer = scannerSingleton.getScanner().readString();
        if (service.isPlayingRoomEmpty()) {
            try {
                List<Toy> filteredList = service.getAllToys().stream()
                        .filter(p -> p.getSize().equals(Size.valueOf(answer.toUpperCase())))
                        .collect(Collectors.toList());
                filteredList.forEach(System.out::println);
                logger.info("There was found the toy by exact size");
            } catch (IllegalArgumentException e) {
                logger.error(e);
                System.out.println("There is not a toy with this size");
            }

        } else {
            logger.warn("User has tried to find toy in empty room");
            System.out.println("Firstly fill the room");
        }
    }
    @Override
    public String toString() {
        return "FindBySizeCommand";
    }
}
