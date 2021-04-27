package com.zhuromska.model;

import java.util.Objects;

public class Train extends Toy {
    private int quantityOfWagons;
    private boolean isPlayingSounds;

    public Train(Size size, int price, int quantityOfWagons, boolean isPlayingSounds) {
        super(size, price);
        this.quantityOfWagons = quantityOfWagons;
        this.isPlayingSounds = isPlayingSounds;
    }

    public int getQuantityOfWagons() {
        return quantityOfWagons;
    }

    public void setQuantityOfWagons(int quantityOfWagons) {
        this.quantityOfWagons = quantityOfWagons;
    }

    public boolean isPlayingSounds() {
        return isPlayingSounds;
    }

    public void setPlayingSounds(boolean playingSounds) {
        isPlayingSounds = playingSounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return quantityOfWagons == train.quantityOfWagons &&
                isPlayingSounds == train.isPlayingSounds;
    }

    @Override
    public String toString() {
        return "A " + "train is " + super.getSize() +
                " and has " + quantityOfWagons + " wagons. " +
                "The train is " + (isPlayingSounds ? "" : "not ") + "playing sound. " +
                "It costs " + super.getPrice() + " ₴\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantityOfWagons, isPlayingSounds);
    }
}
