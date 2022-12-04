package co.rocketstack.aoc.day4;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Test {
    @Test
    void findNumberOfEntirelyOverlappingRanges() throws FileNotFoundException {
        String filepath = getClass().getResource("Day4.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        RangeFinder rangeFinder = new RangeFinder();
        while (scanner.hasNextLine()) {
            String[] ranges = scanner.nextLine().split(",");
            Range<Integer> r1 = Range.between(Integer.valueOf(ranges[0].split("-")[0]),
                    Integer.valueOf(ranges[0].split("-")[1]));
            Range<Integer> r2 = Range.between(Integer.valueOf(ranges[1].split("-")[0]),
                    Integer.valueOf(ranges[1].split("-")[1]));
            rangeFinder.addPair(r1, r2);
        }
        System.out.println(rangeFinder.getNumberOfEntirelyOverlappingSections());
    }

    @Test
    void findNumberOfPartiallyOverlappingRanges() throws FileNotFoundException {
        String filepath = getClass().getResource("Day4.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        RangeFinder rangeFinder = new RangeFinder();
        while (scanner.hasNextLine()) {
            String[] ranges = scanner.nextLine().split(",");
            Range<Integer> r1 = Range.between(Integer.valueOf(ranges[0].split("-")[0]),
                    Integer.valueOf(ranges[0].split("-")[1]));
            Range<Integer> r2 = Range.between(Integer.valueOf(ranges[1].split("-")[0]),
                    Integer.valueOf(ranges[1].split("-")[1]));
            rangeFinder.addPair(r1, r2);
        }
        System.out.println(rangeFinder.getNumberOfPartiallyOverlappingSections());
    }
}
