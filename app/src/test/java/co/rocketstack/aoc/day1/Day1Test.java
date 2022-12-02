package co.rocketstack.aoc.day1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class Day1Test {
    @Test
    void getTheHighestCalorieCountForAnElf() throws FileNotFoundException {
        String filepath = getClass().getResource("Day1.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);
        System.out.println(counter.getHighestCalorieCount());
    }

    @Test
    void getTheTotalCalorieCountForTheTop3Elves() throws FileNotFoundException {
        String filepath = getClass().getResource("Day1.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);
        System.out.println(counter.getTotalCalorieCountForTheTopNElves(3));
    }
}