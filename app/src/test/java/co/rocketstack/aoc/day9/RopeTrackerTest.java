package co.rocketstack.aoc.day9;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RopeTrackerTest {
    @Test
    void testIsTouching() {
        RopeTracker.Coodinate tail = new RopeTracker.Coodinate(2, 2);
        // On top
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(2, 2)));
        // To the left
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(1, 2)));
        // To the right
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(3, 2)));
        // Above
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(2, 1)));
        // Below
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(2, 3)));
        // Above Left
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(1, 1)));
        // Above Right
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(3, 1)));
        // Below Left
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(1, 1)));
        // Below Right
        Assert.assertTrue(tail.isTouching(new RopeTracker.Coodinate(1, 3)));

        // Not touching
        Assert.assertFalse(tail.isTouching(new RopeTracker.Coodinate(0, 0)));
        Assert.assertFalse(tail.isTouching(new RopeTracker.Coodinate(-1, 5)));
    }

    @Test
    void testMove() {
        RopeTracker ropeTracker = new RopeTracker();
        Assert.assertEquals(1, ropeTracker.getPositionCount());

        ropeTracker.move("R", "4");
        Assert.assertEquals(4, ropeTracker.getPositionCount());

        ropeTracker.move("U", "4");
        Assert.assertEquals(7, ropeTracker.getPositionCount());

        ropeTracker.move("L", "3");
        Assert.assertEquals(9, ropeTracker.getPositionCount());

        ropeTracker.move("D", "1");
        Assert.assertEquals(9, ropeTracker.getPositionCount());

        ropeTracker.move("R", "4");
        Assert.assertEquals(10, ropeTracker.getPositionCount());

        ropeTracker.move("D", "1");
        Assert.assertEquals(10, ropeTracker.getPositionCount());

        ropeTracker.move("L", "5");
        Assert.assertEquals(13, ropeTracker.getPositionCount());

        ropeTracker.move("R", "2");
        Assert.assertEquals(13, ropeTracker.getPositionCount());
    }
}
