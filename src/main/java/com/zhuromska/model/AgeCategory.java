package com.zhuromska.model;

public enum AgeCategory {
    TODDLER("1-3"), PRESCHOOL("3-5"),
    GRADESCHOOLER("5-12"), TEEN("12+");

    private final String description;

    AgeCategory(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

