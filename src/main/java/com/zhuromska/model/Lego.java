package com.zhuromska.model;

import java.util.Objects;

public class Lego extends Toy {

    private AgeCategory ageCategory;
    private String series;

    public Lego(Size size, int price, AgeCategory ageCategory, String series) {
        super(size, price);
        this.ageCategory = ageCategory;
        this.series = series;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getSeries() {
        return series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lego)) return false;
        if (!super.equals(o)) return false;
        Lego lego = (Lego) o;
        return ageCategory == lego.ageCategory &&
                Objects.equals(series, lego.series);
    }

    @Override
    public String toString() {
        return "A " + super.getSize() + " box of lego " + "\"" + series + "\" " +
                "is for " + ageCategory + " age kids. "+
                "It costs " + super.getPrice() + " ₴\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ageCategory, series);
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
