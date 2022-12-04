package co.rocketstack.aoc.day4;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RangeFinderTest {
    /**
     * Sample Range Pairs
     * <p>
     * 2-4,6-8
     * 2-3,4-5
     * 5-7,7-9
     * 2-8,3-7
     * 6-6,4-6
     * 2-6,4-8
     * <p>
     * Find where one range fully contains the other in the pair
     */
    @Test
    void testRangeFinderCountFullyOverLappingElements() {
        RangeFinder rangeFinder = new RangeFinder();

        Range<Integer> r1 = Range.between(2, 4);
        Range<Integer> r2 = Range.between(6, 8);
        rangeFinder.addPair(r1, r2);
        Assert.assertEquals(0, rangeFinder.getNumberOfEntirelyOverlappingSections());

        Range<Integer> r3 = Range.between(2, 3);
        Range<Integer> r4 = Range.between(4, 5);
        rangeFinder.addPair(r3, r4);
        Assert.assertEquals(0, rangeFinder.getNumberOfEntirelyOverlappingSections());

        Range<Integer> r5 = Range.between(2, 8);
        Range<Integer> r6 = Range.between(3, 7);
        rangeFinder.addPair(r5, r6);
        Assert.assertEquals(1, rangeFinder.getNumberOfEntirelyOverlappingSections());

        Range<Integer> r7 = Range.between(6, 6);
        Range<Integer> r8 = Range.between(4, 6);
        rangeFinder.addPair(r7, r8);
        Assert.assertEquals(2, rangeFinder.getNumberOfEntirelyOverlappingSections());
    }

    @Test
    void testRangeFinderCountPartialOverlappingElements() {
        RangeFinder rangeFinder = new RangeFinder();

        Range<Integer> r1 = Range.between(5, 7);
        Range<Integer> r2 = Range.between(7, 9);
        rangeFinder.addPair(r1, r2);
        Assert.assertEquals(1, rangeFinder.getNumberOfPartiallyOverlappingSections());

        Range<Integer> r3 = Range.between(2, 3);
        Range<Integer> r4 = Range.between(4, 5);
        rangeFinder.addPair(r3, r4);
        Assert.assertEquals(1, rangeFinder.getNumberOfPartiallyOverlappingSections());
    }
}
