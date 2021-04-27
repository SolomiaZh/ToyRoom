package com.zhuromska.util;

import com.zhuromska.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class GenerateToy {

    public final static int MIN_PRICE = 100;
    final static int MIN_DIAMETER = 3;
    final static int MAX_PRICE = 3000;
    private static final Logger logger = LogManager.getLogger();
    static Random random = new Random();


    public static Toy generateToy(int rand) {
        // int rand = new Random().nextInt(5);
        switch (rand) {
            case 0:
                return generateLego();
            case 1:
                return generateTrain();
            case 2:
                return generateCar();
            case 3:
                return generateMonster();
            case 4:
                return generateBall();
            default:
                logger.error("RuntimeException cannot generate toys ");
                throw new RuntimeException("Cannot generate toys");

        }
    }

    static Lego generateLego() {
        Lego randomLego = new Lego(generateSize(), generatePrice(), generateAgeCategory(), generateLegoSeries());
        logger.info("{} was generated", randomLego);
        return randomLego;
    }

    static Ball generateBall() {
        Ball randomBall = new Ball(generateSize(), generatePrice(), generateDiameter(), generateMaterial(), generateColor());
        logger.info("{} was generated", randomBall);
        return randomBall;
    }

    static Car generateCar() {
        Car randomCar = new Car(generateSize(), generatePrice(), generateColor(), generateBoolean(), generateBoolean());
        logger.info("{} was generated", randomCar);
        return randomCar;
    }

    static Monster generateMonster() {
        Monster randomMonster = new Monster(generateSize(), generatePrice(), generateColor(), generateShoutVolume(), generateBoolean());
        logger.info("{} was generated", randomMonster);
        return randomMonster;
    }

    static Train generateTrain() {

        Train randomTrain = new Train(generateSize(), generatePrice(), generateQuantityOfWagons(), generateBoolean());
        logger.info("{} was generated", randomTrain);
        return randomTrain;
    }

    static Size generateSize() {
        Size[] sizes = Size.values();
        int enumSize = sizes.length;
        Size randomSize = sizes[random.nextInt(enumSize)];
        logger.info("Single size [{}] for random toy was generated ", randomSize);
        return randomSize;
    }

    static AgeCategory generateAgeCategory() {
        AgeCategory[] categories = AgeCategory.values();
        int enumSize = categories.length;
        AgeCategory randomAgeCategory = categories[random.nextInt(enumSize)];
        logger.info("Single age category [{}] for random toy was generated ", randomAgeCategory);
        return randomAgeCategory;
    }

    static int generatePrice() {
        int randomPrice = random.nextInt(MAX_PRICE / 10) * 10 + MIN_PRICE;
        logger.info("Single price[{}] for random toy was generated ", randomPrice);
        return randomPrice;
    }

    static String generateLegoSeries() {
        String[] series = new String[]{"Disney", "Friends", "Ninjago",
                "Marvel", "Super Mario", "Harry Potter", "Technic"};
        String randomString = series[random.nextInt(series.length)];
        logger.info("Single string [{}] for random toy was generated ", randomString);
        return randomString;
    }


    static int generateDiameter() {
        int randomDiameter = random.nextInt(30) + MIN_DIAMETER;
        logger.info("Single diameter [{}] for random toy was generated ", randomDiameter);
        return randomDiameter;
    }

    static int generateShoutVolume() {
        int randomShoutVolume = random.nextInt(10) + 1;
        logger.info("Single shout volume [{}] for random toy was generated ", randomShoutVolume);
        return randomShoutVolume;
    }

    static int generateQuantityOfWagons() {
        int randomQuantityOfWagons = random.nextInt(20) + 1;
        logger.info("Single quantity of wagons [{}] for random toy was generated ", randomQuantityOfWagons);
        return randomQuantityOfWagons;
    }

    static String generateMaterial() {
        String[] materials = new String[]{"orbeez", "rubber", "wooden", "cotton", "silk", "metal"};
        String randomMaterial = materials[random.nextInt(materials.length)];
        logger.info("Single material [{}] for random toy was generated ", randomMaterial);
        return randomMaterial;
    }

    static String generateColor() {
        String[] colors = new String[]{"red", "blue", "green", "yellow", "black", "white", "turquoise", "purple","daisy", "pink", "grey", "gold", "silver"};

        String randomColor = colors[random.nextInt(colors.length)];
        logger.info("Single color [{}] for random toy was generated ", randomColor);
        logger.error("Solomiia's Entering to the cs");
        return randomColor;
    }

    static boolean generateBoolean() {
        boolean randomBoolean = random.nextBoolean();
        logger.info("Single boolean value [{}] for random toy was generated ", randomBoolean);
        return randomBoolean;
    }

}
