package com.zhuromska.model;

import java.util.ArrayList;
import java.util.List;

public class PlayingRoom {

    private List<Toy> toys = new ArrayList<>();

    public PlayingRoom() {
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void deleteAllToys() {
        toys.clear();
    }
    public void changeAllToys(List<Toy> toys) {
        this.toys = toys;
    }
    public void deleteToy(int index) {
        toys.remove(index);
    }

}
