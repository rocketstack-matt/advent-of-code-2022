package co.rocketstack.aoc.day3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BadgeCheckerTest {
    @Test
    void testFindMatchingItem() {
        Rucksack rs1 = new Rucksack("ABC");
        Rucksack rs2 = new Rucksack("ADE");
        Rucksack rs3 = new Rucksack("AFG");
        Assert.assertEquals("A", new BadgeChecker(rs1, rs2, rs3).findBadge());
    }

    /**
     * Every set of three lines in your list corresponds to a single group, but each group can have a
     * different badge item type. So, in the above example, the first group's rucksacks are the first three lines:
     *
     * vJrwpWtwJgWrhcsFMMfFFhFp
     * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
     * PmmdzqPrVvPwwTWBwg
     *
     * And the second group's rucksacks are the next three lines:
     *
     * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
     * ttgJtRGJQctTZtZT
     * CrZsJsPPZsGzwwsLwLmpwMDw
     *
     * In the first group, the only item type that appears in all three rucksacks is lowercase r;
     * this must be their badges. In the second group, their badge item type must be Z.
     *
     * Priorities for these items must still be found to organize the sticker attachment efforts: here, they
     * are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.
     */
    @Test
    void testSample() {
        Rucksack rs1 = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        Rucksack rs2 = new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        Rucksack rs3 = new Rucksack("PmmdzqPrVvPwwTWBwg");
        BadgeChecker bc1 = new BadgeChecker(rs1, rs2, rs3);
        Assert.assertEquals("r", bc1.findBadge());
        int badge1Priority = bc1.getBadgePriority();

        Rucksack rs4 = new Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Rucksack rs5 = new Rucksack("ttgJtRGJQctTZtZT");
        Rucksack rs6 = new Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw");
        BadgeChecker bc2 = new BadgeChecker(rs4, rs5, rs6);
        Assert.assertEquals("Z", bc2.findBadge());
        int badge2Priority = bc2.getBadgePriority();

        Assert.assertEquals(70, badge1Priority + badge2Priority);
    }
}
