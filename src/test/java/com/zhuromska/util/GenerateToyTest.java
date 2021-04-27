package com.zhuromska.util;

import com.zhuromska.model.*;
import com.zhuromska.service.PlayingRoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class MainTest {
    final PlayingRoomService service = PlayingRoomService.getInstance();

    @Test
    void testGenerateLego() {

        Toy toy = GenerateToy.generateToy(0);
        Assertions.assertTrue(toy.getPrice() != 0);
        Assertions.assertNotNull(toy.getSize());
        Assertions.assertTrue(toy instanceof Lego);
        Assertions.assertNotNull(((Lego) toy).getAgeCategory());
        Assertions.assertNotNull(((Lego) toy).getSeries());


    }

    @Test
    void testGenerateTrain() {

        Toy toy1 = GenerateToy.generateToy(1);
        Assertions.assertTrue(toy1.getPrice() != 0);
        Assertions.assertNotNull(toy1.getSize());
        Assertions.assertTrue(toy1 instanceof Train);
        Assertions.assertTrue(((Train) toy1).getQuantityOfWagons() != 0);


    }

    @Test
    void testGenerateMonster() {

        Toy toy3 = GenerateToy.generateToy(3);
        Assertions.assertTrue(toy3.getPrice() != 0);
        Assertions.assertNotNull(toy3.getSize());
        Assertions.assertTrue(toy3 instanceof Monster);
        Assertions.assertNotNull(((Monster) toy3).getColor());
        Assertions.assertTrue(((Monster)toy3).getShoutVolume() != 0);

    }

    @Test
    void testGenerate() {
//NullPointerException
        int sum = 0;
        int s = 12254;
        if (service.generateToys(s) != 0) {
            for (Toy g : service.getAllToys()) {
                sum += g.getPrice();
            }
            Assertions.assertTrue(sum != 0);
        }

    }

    @Test
    void testGenerateBall() {

        Toy toy4 = GenerateToy.generateToy(4);
        Assertions.assertTrue(toy4.getPrice() != 0);
        Assertions.assertNotNull(toy4.getSize());
        Assertions.assertTrue(toy4 instanceof Ball);
        Assertions.assertTrue(((Ball) toy4).getDiameter() != 0);
        Assertions.assertNotNull(((Ball) toy4).getMaterial());
        Assertions.assertNotNull(((Ball) toy4).getColor());
    }

    @Test
    void testExpectedException() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            GenerateToy.generateToy(5);
        });

    }

    @Test
    void testExpectedException1() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            GenerateToy.generateToy(1012);
        });

    }

    @Test
    public void testAdd() {

        service.createNewRoom();
        service.addToy(GenerateToy.generateToy(4));
        Assertions.assertEquals( 1, service.getAllToys().size());
    }

    @Test
    public void testToysGeneration() {

        service.createNewRoom();
        service.addToy(GenerateToy.generateToy(4));
        Assertions.assertEquals( 1, service.getAllToys().size());
    }

    @Test
    public void testSortByPrice() {

        service.createNewRoom();
        service.addToy(new Car(Size.TINY, 12365, "blue", true, false));
        service.addToy(new Lego(Size.ENORMOUS, 1489, AgeCategory.GRADESCHOOLER, "Duplo"));
        service.addToy(new Train(Size.TINY, 15, 3, false));
        service.addToy(new Ball(Size.BIG, 123875, 12565, "leather", "red"));
        List<Toy> sortedToys = service.getToysSortedListByPrice();
        Toy toyWithTheLowestPrice = new Train(Size.TINY, 15, 3, false);
        Toy toyWithTheBiggestPrice = new Ball(Size.BIG, 123875, 12565, "leather", "red");
        Assertions.assertEquals(sortedToys.get(0), toyWithTheLowestPrice);
        Assertions.assertEquals(sortedToys.get(sortedToys.size() - 1), toyWithTheBiggestPrice);
    }

    @Test
    public void testSortBySize() {

        service.createNewRoom();
        service.addToy(new Car(Size.SMALL, 12365, "blue", true, false));
        service.addToy(new Lego(Size.BIG, 1489, AgeCategory.GRADESCHOOLER, "Duplo"));
        service.addToy(new Train(Size.TINY, 15, 3, false));
        service.addToy(new Ball(Size.ENORMOUS, 1875, 12565, "leather", "red"));
        List<Toy> sortedToys = service.getToysSortedListBySize();
        Toy toyWithTheLowestSize = new Train(Size.TINY, 15, 3, false);
        Toy toyWithTheBiggestSize = new Ball(Size.ENORMOUS, 1875, 12565, "leather", "red");
        Assertions.assertEquals(sortedToys.get(0), toyWithTheLowestSize);
    }




/*
    @Test
    public void toStrings() {
        MainMenu menu = new MainMenu();
        String j = menu.printCommands();
        Assert.assertEquals("{0=ExitCommand{}, " +
                "1=CreateRoomCommand{}, " +
                "2=AddToyToRoomCommand{}, " +
                "3=AddToysToRoomCommand, " +
                "4=ListToysCommand{}, " +
                "5=DeleteToyCommand{}, " +
                "6=DeleteToysCommand{}, " +
                "7=SortByPriceCommand{}, " +
                "8=SortBySizeCommand{}, " +
                "9=FindByPriceCommand{}, " +
                "10=FindBySizeCommand{}}", j);
    }
*/

}
