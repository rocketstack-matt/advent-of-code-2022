package co.rocketstack.aoc.day1;

import co.rocketstack.aoc.day1.CalorieCounter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class CalorieCounterTest {
    @Test
    void testEmptyFileConstructor() throws IOException {
        try {
            String filepath = getClass().getResource("CalorieCounterEmptyFile.input").getFile();
            CalorieCounter counter = new CalorieCounter(filepath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testSampleFileConstructor() throws IOException {
        try {
            String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
            CalorieCounter counter = new CalorieCounter(filepath);

            Assert.assertEquals(6000, counter.getCalorieCountForElf(0));
            Assert.assertEquals(4000, counter.getCalorieCountForElf(1));
            Assert.assertEquals(11000, counter.getCalorieCountForElf(2));
            Assert.assertEquals(24000, counter.getCalorieCountForElf(3));
            Assert.assertEquals(10000, counter.getCalorieCountForElf(4));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testGettingHighestCalorieCount() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(24000, counter.getHighestCalorieCount());
    }

    @Test
    void testGetTheElfWithTheHighestCalorieCount() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(4, counter.getTheElfWithTheHighestCalorieCount());
    }

    @Test
    void testGetCalorieCountForTop3Elves() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(45000, counter.getTotalCalorieCountForTheTopNElves(3));
    }
}