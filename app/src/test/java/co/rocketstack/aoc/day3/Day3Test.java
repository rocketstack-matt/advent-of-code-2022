package co.rocketstack.aoc.day3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3Test {
    /**
     * Find the item type that appears in both compartments of each rucksack.
     * What is the sum of the priorities of those item types?
     */
    @Test
    void getPriorityTotal() throws FileNotFoundException {
        String filepath = getClass().getResource("Day3.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        int count = 0;
        while (scanner.hasNextLine()) {
            count += new Rucksack(scanner.nextLine()).getCommonItemPriority();
        }
        System.out.println(count);
    }
}
