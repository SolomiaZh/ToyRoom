package com.zhuromska.model;

import java.util.Objects;

public class Toy {

    private  Size size;
    private  int price;

    public Toy(Size size, int price) {
        this.size = size;
        this.price = price;
    }

    public Toy setSize(Size size) {
        this.size = size;
        return this;
    }

    public Toy setPrice(int price) {
        this.price = price;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return price == toy.price &&
                size == toy.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, price);
    }
}
