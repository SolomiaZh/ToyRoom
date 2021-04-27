package com.zhuromska.model;

import java.util.Objects;

public class Car extends Toy {

    private String color;
    private boolean isPlayingSound;
    private boolean isRemoteControl;

    public Car(Size size, int price, String color, boolean isPlayingSound, boolean isRemoteControl) {
        super(size, price);
        this.color = color;
        this.isPlayingSound = isPlayingSound;
        this.isRemoteControl = isRemoteControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return isPlayingSound == car.isPlayingSound &&
                isRemoteControl == car.isRemoteControl &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, isPlayingSound, isRemoteControl);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPlayingSound() {
        return isPlayingSound;
    }

    public void setPlayingSound(boolean playingSound) {
        isPlayingSound = playingSound;
    }

    public boolean isRemoteControl() {
        return isRemoteControl;
    }

    @Override
    public String toString() {
        return "A " + color + " сar is " + super.getSize() +
                ", it is " + (isPlayingSound ? "" : "not ") + "playing sound. " +
                "The car has" +  (isPlayingSound ? " got ":"n't got ") + "remote mode. " +
                "It costs " + super.getPrice() + " ₴\n";
    }

    public void setRemoteControl(boolean remoteControl) {
        isRemoteControl = remoteControl;
    }


}
