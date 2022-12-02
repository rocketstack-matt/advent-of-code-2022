package co.rocketstack.aoc.day1;

import co.rocketstack.aoc.CalorieCounter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class Day1 {
    @Test
    void getTheHighestCalorieCountForAnElf() throws FileNotFoundException {
        String filepath = getClass().getResource("Day1.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);
        System.out.println(counter.getHighestCalorieCount());
    }
}