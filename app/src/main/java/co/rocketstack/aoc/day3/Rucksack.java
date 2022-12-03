package co.rocketstack.aoc.day3;

import lombok.Getter;

@Getter
public class Rucksack {
    private String compartment1;
    private String compartment2;

    public Rucksack(String contents) {
        compartment1 = contents.substring(0, contents.length() / 2);
        compartment2 = contents.substring(contents.length() / 2);
    }

    public String getCommonItem() {
        for (char item : compartment1.toCharArray()) {
            if (compartment2.contains(String.valueOf(item))) return String.valueOf(item);
        }
        return null;
    }

    public int getCommonItemPriority() {
        if(Character.isUpperCase(getCommonItem().charAt(0)))
            return getCommonItem().toCharArray()[0] - 38;
        else
            return getCommonItem().toCharArray()[0] - 96;
    }

    public String getContents() {
        return compartment1.concat(compartment2);
    }

    @Override
    public String toString() {
        return getContents();
    }
}
