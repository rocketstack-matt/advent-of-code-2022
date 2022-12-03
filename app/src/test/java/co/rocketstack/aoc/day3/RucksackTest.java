package co.rocketstack.aoc.day3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * For example, suppose you have the following list of contents from six rucksacks:
 * <p>
 * vJrwpWtwJgWrhcsFMMfFFhFp
 * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
 * PmmdzqPrVvPwwTWBwg
 * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
 * ttgJtRGJQctTZtZT
 * CrZsJsPPZsGzwwsLwLmpwMDw
 */
public class RucksackTest {

    @Test
    void testRucksackPacking() {
        Rucksack rucksack = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment1()), "vJrwpWtwJgWr");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment2()), "hcsFMMfFFhFp");
    }

    @Test
    void testGetCommonItem() {
        Rucksack rucksack = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        Assert.assertEquals("p", rucksack.getCommonItem());
    }

    /**
     * The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains
     * the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp.
     * The only item type that appears in both compartments is lowercase p.
     */
    @Test
    void testRucksack1() {
        Rucksack rucksack = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment1()), "vJrwpWtwJgWr");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment2()), "hcsFMMfFFhFp");
        Assert.assertEquals("p", rucksack.getCommonItem());
    }

    /**
     * The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL.
     * The only item type that appears in both compartments is uppercase L.
     */
    @Test
    void testRucksack2() {
        Rucksack rucksack = new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment1()), "jqHRNqRjqzjGDLGL");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment2()), "rsFMfFZSrLrFZsSL");
        Assert.assertEquals("L", rucksack.getCommonItem());
    }

    /**
     * The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
     */
    @Test
    void testRucksack3() {
        Rucksack rucksack = new Rucksack("PmmdzqPrVvPwwTWBwg");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment1()), "PmmdzqPrV");
        Assert.assertEquals(String.valueOf(rucksack.getCompartment2()), "vPwwTWBwg");
        Assert.assertEquals("P", rucksack.getCommonItem());
    }

    /**
     * The fourth rucksack's compartments only share item type v.
     */
    @Test
    void testRucksack4() {
        Rucksack rucksack = new Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Assert.assertEquals("v", rucksack.getCommonItem());
    }

    /**
     * The fifth rucksack's compartments only share item type t.
     */
    @Test
    void testRucksack5() {
        Rucksack rucksack = new Rucksack("ttgJtRGJQctTZtZT");
        Assert.assertEquals("t", rucksack.getCommonItem());
    }

    /**
     * The sixth rucksack's compartments only share item type s.
     */
    @Test
    void testRucksack6() {
        Rucksack rucksack = new Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw");
        Assert.assertEquals("s", rucksack.getCommonItem());
    }

    /**
     * To help prioritize item rearrangement, every item type can be converted to a priority:
     * <p>
     * Lowercase item types a through z have priorities 1 through 26.
     * Uppercase item types A through Z have priorities 27 through 52.
     * In the above example, the priority of the item type that appears in both compartments of each rucksack
     * is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
     */
    @Test
    void testPriorytValues() {
        Rucksack rucksack = new Rucksack("aa");
        Assert.assertEquals(1, rucksack.getCommonItemPriority());
        rucksack = new Rucksack("zz");
        Assert.assertEquals(26, rucksack.getCommonItemPriority());
        rucksack = new Rucksack("AA");
        Assert.assertEquals(27, rucksack.getCommonItemPriority());
        rucksack = new Rucksack("ZZ");
        Assert.assertEquals(52, rucksack.getCommonItemPriority());

        Rucksack rs1 = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        Rucksack rs2 = new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        Rucksack rs3 = new Rucksack("PmmdzqPrVvPwwTWBwg");
        Rucksack rs4 = new Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Rucksack rs5 = new Rucksack("ttgJtRGJQctTZtZT");
        Rucksack rs6 = new Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw");
        Assert.assertEquals(157, rs1.getCommonItemPriority() +
                rs2.getCommonItemPriority() +
                rs3.getCommonItemPriority() +
                rs4.getCommonItemPriority() +
                rs5.getCommonItemPriority() +
                rs6.getCommonItemPriority());
    }
}
