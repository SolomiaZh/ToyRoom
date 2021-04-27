package com.zhuromska.model;

import java.util.Objects;

public class Monster extends Toy {

    private String color;
    private int shoutVolume;
    private boolean isMoving;

    public Monster(Size size, int price, String color, int shoutVolume, boolean isMoving) {
        super(size, price);
        this.color = color;
        this.shoutVolume = shoutVolume;
        this.isMoving = isMoving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return shoutVolume == monster.shoutVolume &&
                isMoving == monster.isMoving &&
                Objects.equals(color, monster.color);
    }

    @Override
    public String toString() {
        return "A " + color + " monster is " + super.getSize() +
                ". The monster is shouting at " + shoutVolume + "/10 level and "+
                 (isMoving? "":"not ") + "moving. " +
                "It costs " + super.getPrice() + " ₴\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, shoutVolume, isMoving);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getShoutVolume() {
        return shoutVolume;
    }

    public void setShoutVolume(int shoutVolume) {
        this.shoutVolume = shoutVolume;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
