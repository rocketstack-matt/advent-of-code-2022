package co.rocketstack.aoc;

import lombok.Getter;

@Getter
public class Elf {
    int calories;

    public void addItem(int calories) {
        this.calories+=calories;
    }
}
