package com.zhuromska.menu;

import com.zhuromska.controller.ScannerSingleton;
import com.zhuromska.model.Size;
import com.zhuromska.model.Toy;
import com.zhuromska.service.PlayingRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class FindByPriceCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private final PlayingRoomService service = PlayingRoomService.getInstance();
    private final ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Enter price range to find toys:  ");
        int min = scannerSingleton.getScanner().readInt();
        int max = scannerSingleton.getScanner().readInt();
            if (service.isPlayingRoomEmpty() && service.getAllToys().size() !=0) {
                List<Toy> filteredList = service.getAllToys().stream()
                        .filter(p -> p.getPrice() >= min)
                        .filter(p -> p.getPrice() <= max)
                        .collect(Collectors.toList());
                filteredList.forEach(System.out::println);
                logger.info("There was found the toy in {} - {} price range", min, max);
            } else {
                logger.warn("User has tried to find a toy by price range in empty room");
                System.out.println("Firstly fill the room");
            }
        }


    @Override
    public String toString() {
        return "FindByPriceCommand";
    }
}
