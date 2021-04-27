package com.zhuromska.model;

public enum Size {
    TINY, SMALL, BIG, ENORMOUS;

    private final String description;

    Size() {
        String uppercaseDescription = super.toString();
        description = uppercaseDescription.toLowerCase();
    }

    @Override
    public String toString() {
        return description;
    }
}


