package com.zhuromska.service;

import com.zhuromska.model.PlayingRoom;
import com.zhuromska.model.Toy;
import com.zhuromska.util.GenerateToy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PlayingRoomService {

    private final static int MAX_GENERATING_ERRORS = 3;
    private static PlayingRoomService instance;
    private PlayingRoom playingRoom;

    private static final Logger logger = LogManager.getLogger();

    private PlayingRoomService() {

    }

    public static PlayingRoomService getInstance() {
        if (instance == null) {
            instance = new PlayingRoomService();
        }
        logger.info("The instance of a play room was returned");
        return instance;
    }

    public void createNewRoom() {
        playingRoom = new PlayingRoom();
        logger.info("The new room was created");
    }

    public boolean isPlayingRoomExisting() {
        return playingRoom != null;
    }

    public boolean isPlayingRoomEmpty() {
        return playingRoom.getToys() != null;
    }

    public void addToy(Toy toy) {
        playingRoom.addToy(toy);
        logger.info("A single toy was added to the room ");
    }


    public void deleteAllToys() {
        playingRoom.deleteAllToys();
        logger.info("Toys were deleted from the room ");
    }

    public void deleteToy(int index) {
        playingRoom.deleteToy(index);
        logger.info("A single toy was deleted from the room ");
    }

    public void changeAllToys(List<Toy> toys) {
        playingRoom.changeAllToys(toys);
        logger.info("All toys were replaced in the room ");
    }

    public List<Toy> getAllToys() {
        logger.info("The list of all toys was returned");
        return new ArrayList<>(playingRoom.getToys());
    }

    public List<Toy> getToysSortedListBySize() {
        logger.info("All toys were sorted by size ");
        return playingRoom.getToys().stream().sorted(Comparator.comparing(Toy::getSize)).collect(Collectors.toList());
    }

    public List<Toy> getToysSortedListByPrice() {
        logger.info("All toys were sorted by size ");
        return playingRoom.getToys().stream().sorted(Comparator.comparing(Toy::getPrice)).collect(Collectors.toList());
    }

    public int generateToys(int sum) {

        int numOfGeneratedToys = 0;
        int generationErrors = 0;
        while (sum > GenerateToy.MIN_PRICE) {
            Toy toy = GenerateToy.generateToy(new Random().nextInt(5));
            if (toy.getPrice() < sum) {
                addToy(toy);
                sum -= toy.getPrice();
                numOfGeneratedToys++;
                generationErrors = 0;
            } else {
                generationErrors++;
            }
            if (generationErrors > MAX_GENERATING_ERRORS) {
                return numOfGeneratedToys;
            }
        }
        logger.info("Toys for the {} price were generated", sum);
        return numOfGeneratedToys;
    }
}
