package co.rocketstack.aoc.day3;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BadgeChecker {
    Rucksack rs1;
    Rucksack rs2;
    Rucksack rs3;

    public String findBadge() {
        for (char item : rs1.getContents().toCharArray()) {
            if (rs2.getContents().contains(String.valueOf(item))) {
                if (rs3.getContents().contains(String.valueOf(item)))  return String.valueOf(item);
            }
        }
        return null;
    }

    public int getBadgePriority() {
        char badge = findBadge().charAt(0);
        if(Character.isUpperCase(badge))
            return badge - 38;
        else
            return badge - 96;
    }
}
