package com.zhuromska.model;

import java.util.Objects;

public class Ball extends Toy {

    private int diameter;
    private String material;
    private String color;

    public Ball(Size size, int price, int diameter, String material, String color) {
        super(size, price);
        this.diameter = diameter;
        this.material = material;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        if (!super.equals(o)) return false;
        Ball ball = (Ball) o;
        return diameter == ball.diameter &&
                Objects.equals(material, ball.material) &&
                Objects.equals(color, ball.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, material, color);
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "A " + color + " " + material + " ball is " + super.getSize() + ", its diameter is " + diameter + " cm. " +
                "It costs " + super.getPrice() + " ₴\n";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
