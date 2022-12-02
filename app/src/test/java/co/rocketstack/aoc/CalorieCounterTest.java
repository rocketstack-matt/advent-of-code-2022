package co.rocketstack.aoc;

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

            Assert.assertEquals(counter.getCalorieCountForElf(0), 6000);
            Assert.assertEquals(counter.getCalorieCountForElf(1), 4000);
            Assert.assertEquals(counter.getCalorieCountForElf(2), 11000);
            Assert.assertEquals(counter.getCalorieCountForElf(3), 24000);
            Assert.assertEquals(counter.getCalorieCountForElf(4), 10000);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testGettingHighestCalorieCount() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(counter.getHighestCalorieCount(), 24000);
    }

    @Test
    void testGetTheElfWithTheHighestCalorieCount() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(counter.getTheElfWithTheHighestCalorieCount(), 4);
    }

    @Test
    void testGetCalorieCountForTop3Elves() throws FileNotFoundException {
        String filepath = getClass().getResource("CalorieCounterSampleFile.input").getFile();
        CalorieCounter counter = new CalorieCounter(filepath);

        Assert.assertEquals(counter.getTotalCalorieCountForTheTopNElves(3), 45000);
    }
}