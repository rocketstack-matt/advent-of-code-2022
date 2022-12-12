package co.rocketstack.aoc.day9;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9Test {
    @Test
    void findNumberOfPositions() throws FileNotFoundException {
        String filepath = getClass().getResource("Day9.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        RopeTracker ropeTracker = new RopeTracker();
        while (scanner.hasNextLine()) {
            String[] commands = scanner.nextLine().split(" ");
            ropeTracker.move(commands[0], commands[1]);
        }
        System.out.println(ropeTracker.getPositionCount());
    }
}
