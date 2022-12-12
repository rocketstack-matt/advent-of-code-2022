package co.rocketstack.aoc.day8;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Test {
    @Test
    void findVisibleTrees() throws FileNotFoundException {
        String filepath = getClass().getResource("Day8.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        Grid grid = new Grid();
        while ((scanner.hasNextLine())) {
            grid.addRowOfTrees(scanner.nextLine().toCharArray());
        }

        System.out.println(grid.getVisibleTrees());
        System.out.println(grid.calculateMaxScenicScore());
    }
}
