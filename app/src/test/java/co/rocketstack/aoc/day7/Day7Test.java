package co.rocketstack.aoc.day7;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class Day7Test {
    /**
     * Find all of the directories with a total size of at most 100000. What is the sum of the total sizes of those
     * directories?
     */
    @Test
    void calculateTotalSize() throws FileNotFoundException {
        String filepath = getClass().getResource("Day7.input").getFile();
        DirectoryExplorer explorer = new DirectoryExplorer(filepath);
        System.out.println(explorer.getTotalOfDirsWithMaxSize(100000));
    }
}
