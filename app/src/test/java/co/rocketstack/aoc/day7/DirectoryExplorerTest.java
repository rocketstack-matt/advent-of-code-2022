package co.rocketstack.aoc.day7;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class DirectoryExplorerTest {
    private DirectoryExplorer explorer;

    @BeforeEach
    void loadDirectoryExplorer() throws FileNotFoundException {
        String filepath = getClass().getResource("Sample.input").getFile();
        explorer = new DirectoryExplorer(filepath);
    }

    @Test
    void testDirsToReturn() {
        Map<String, AOCFile> directories = new HashMap<>();

        for (AOCFile dir : explorer.getDirsWithMaxSize(Integer.MAX_VALUE)) {
            directories.put(dir.getName(), dir);
        }

        Assert.assertEquals(584, directories.get("e").getDirectorySize());
        Assert.assertEquals(94853, directories.get("a").getDirectorySize());
        Assert.assertEquals(24933642, directories.get("d").getDirectorySize());
        Assert.assertEquals(48381165, directories.get("/").getDirectorySize());
    }

    @Test
    void testGetDirTotal() {
        Assert.assertEquals(95437, explorer.getTotalOfDirsWithMaxSize(100000));
    }
}
