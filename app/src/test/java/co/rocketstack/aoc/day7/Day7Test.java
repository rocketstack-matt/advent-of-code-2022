package co.rocketstack.aoc.day7;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * Find the smallest directory that, if deleted, would free up enough space on the filesystem to run the update.
     * What is the total size of that directory?
     */
    @Test
    void getSmallestRequiredDir() throws FileNotFoundException {
        String filepath = getClass().getResource("Day7.input").getFile();
        DirectoryExplorer explorer = new DirectoryExplorer(filepath);

        Map<String, AOCFile> directories = new HashMap<>();

        for (AOCFile dir : explorer.getDirsWithMaxSize(Integer.MAX_VALUE)) {
            directories.put(dir.getName(), dir);
        }

        int unusedSpace = 70000000 - directories.get("/").getDirectorySize();
        int requiredSpace = 30000000 - unusedSpace;

        System.out.println(explorer.getSmallestFileBiggerThan(requiredSpace).getDirectorySize());
    }
}
