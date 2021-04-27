package com.zhuromska;

import com.zhuromska.model.Size;
import com.zhuromska.model.Toy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest1 {
    private final Toy toy = new Toy(Size.TINY,1236);

    @Test
    void getSize() {
        Assertions.assertEquals("tiny", toy.getSize().toString());
    }

    @Test
    void setPrice() {
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(1236, toy.getPrice());
    }

    @Test
    void setSize() {
    }
}