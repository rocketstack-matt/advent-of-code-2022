package co.rocketstack.aoc.day8;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GridTest {
    private Grid grid;

    @BeforeEach
    public void setupGrid() {
        String row1 = "30373";
        String row2 = "25512";
        String row3 = "65332";
        String row4 = "33549";
        String row5 = "35390";

        grid = new Grid();
        grid.addRowOfTrees(row1.toCharArray());
        grid.addRowOfTrees(row2.toCharArray());
        grid.addRowOfTrees(row3.toCharArray());
        grid.addRowOfTrees(row4.toCharArray());
        grid.addRowOfTrees(row5.toCharArray());
    }

    @Test
    void testGridLayout() {
        Assert.assertEquals(3, grid.get(0, 0));
        Assert.assertEquals(3, grid.get(4, 0));
        Assert.assertEquals(3, grid.get(0, 4));
        Assert.assertEquals(0, grid.get(4, 4));
    }

    @Test
    void testGetHighest() {
        List<Integer> trees = List.of(1, 3, 5, 2, 8);
        Assert.assertEquals(8, grid.getHighestTree(trees));
    }

    @Test
    void treeIsVisibleFromEdge() {
        Assert.assertTrue(grid.treeIsVisible(0, 1));
        Assert.assertTrue(grid.treeIsVisible(1, 0));
        Assert.assertTrue(grid.treeIsVisible(4, 1));
        Assert.assertTrue(grid.treeIsVisible(1, 4));
    }

    @Test
    void testIsVisibleFromLeft() {
        Assert.assertTrue(grid.treeIsVisibleFromLeft(1, 1));
        Assert.assertFalse(grid.treeIsVisibleFromLeft(2, 1));
        Assert.assertFalse(grid.treeIsVisibleFromLeft(2, 2));
        Assert.assertFalse(grid.treeIsVisibleFromLeft(3, 2));
        Assert.assertFalse(grid.treeIsVisibleFromLeft(4, 2));
    }

    @Test
    void treeIsVisibleFromRight() {
        Assert.assertTrue(grid.treeIsVisibleFromRight(3, 2));
        Assert.assertFalse(grid.treeIsVisibleFromRight(2, 2));
        Assert.assertTrue(grid.treeIsVisibleFromRight(1, 2));
        Assert.assertTrue(grid.treeIsVisibleFromRight(0, 2));
    }

    @Test
    void treeIsVisibleFromAbove() {
        Assert.assertFalse(grid.treeIsVisibleFromAbove(3, 1));
        Assert.assertFalse(grid.treeIsVisibleFromAbove(3, 2));
        Assert.assertFalse(grid.treeIsVisibleFromAbove(3, 3));
        Assert.assertTrue(grid.treeIsVisibleFromAbove(3, 4));
    }

    @Test
    void treeIsVisibleFromBelow() {
        Assert.assertTrue(grid.treeIsVisibleFromBelow(4, 4));
        Assert.assertTrue(grid.treeIsVisibleFromBelow(4, 3));
        Assert.assertFalse(grid.treeIsVisibleFromBelow(4, 2));
        Assert.assertFalse(grid.treeIsVisibleFromBelow(4, 1));
        Assert.assertFalse(grid.treeIsVisibleFromBelow(4, 0));
    }

    @Test
    void testTreeIsVisible() {
        // Tree cannot be seen from the left (there is a tree with a lower x which is taller for the same y)
        Assert.assertFalse(grid.treeIsVisible(3, 3));

        // Tree can be seen from the right (tree at x,y is taller than any other tree with a higher x value for same y)
        Assert.assertTrue(grid.treeIsVisible(3, 2));
    }

    @Test
    void testVisibleTrees() {
        Assert.assertEquals(21, grid.getVisibleTrees());
    }

    @Test
    void testCheckVisibleTreeCountLeft() {
        Assert.assertEquals(3, grid.checkVisibleTreeCountLeft(3, 0));
        Assert.assertEquals(1, grid.checkVisibleTreeCountLeft(2, 1));
        Assert.assertEquals(0, grid.checkVisibleTreeCountLeft(0, 2));
        Assert.assertEquals(4, grid.checkVisibleTreeCountLeft(4, 3));
    }

    @Test
    void testCheckVisibleTreeCountRight() {
        Assert.assertEquals(2, grid.checkVisibleTreeCountRight(0, 0));
        Assert.assertEquals(2, grid.checkVisibleTreeCountRight(2, 1));
        Assert.assertEquals(0, grid.checkVisibleTreeCountRight(4, 1));
        Assert.assertEquals(4, grid.checkVisibleTreeCountRight(0, 2));
    }

    @Test
    void testCheckVisibleTreeCountAbove() {
        Assert.assertEquals(1, grid.checkVisibleTreeCountAbove(4, 4));
        Assert.assertEquals(3, grid.checkVisibleTreeCountAbove(4, 3));
        Assert.assertEquals(0, grid.checkVisibleTreeCountAbove(4, 0));
        Assert.assertEquals(2, grid.checkVisibleTreeCountAbove(1, 4));
    }

    @Test
    void testCheckVisibleTreeCountBelow() {
        Assert.assertEquals(3, grid.checkVisibleTreeCountBelow(4, 0));
        Assert.assertEquals(0, grid.checkVisibleTreeCountBelow(0, 4));
        Assert.assertEquals(2, grid.checkVisibleTreeCountBelow(2, 1));
        Assert.assertEquals(4, grid.checkVisibleTreeCountBelow(3, 0));
    }

    @Test
    void testCheckMaxScenicScore() {
        Assert.assertEquals(8, grid.calculateMaxScenicScore());
    }
}
