package co.rocketstack.aoc.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalorieCounter {
    List<Elf> elves = new ArrayList<>();

    public CalorieCounter(String filepath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filepath));

        Elf elf = new Elf();
        elves.add(elf);
        while (scanner.hasNextLine()) {
            String item = scanner.nextLine();
            if (item.trim().isEmpty()) {
                elf = new Elf();
                elves.add(elf);
            } else {
                elf.addItem(Integer.valueOf(item));
            }
        }
    }

    public int getCalorieCountForElf(int index) {
        return elves.get(index).getCalories();
    }

    public int getHighestCalorieCount() {
        return elves.get(getTheElfWithTheHighestCalorieCount() - 1).getCalories();
    }

    public int getTheElfWithTheHighestCalorieCount() {
        return getTheElfWithTheHighestCalorieCount(this.elves);
    }

    public int getTheElfWithTheHighestCalorieCount(List<Elf> elves) {
        Elf currentElf = elves.get(0);
        for (Elf elf : elves) {
            if (elf.getCalories() > currentElf.getCalories()) currentElf = elf;
        }
        return elves.indexOf(currentElf) + 1;
    }

    public  int getTotalCalorieCountForTheTopNElves(int n) {
        List<Elf> elves = this.elves;
        List<Elf> elvesToCount = new ArrayList<>();

        for(int i=0;i<n;i++) {
            elvesToCount.add(elves.remove(getTheElfWithTheHighestCalorieCount(elves)-1));
        }

        return elvesToCount.stream().map(elf -> elf.getCalories()).collect(Collectors.summingInt(Integer::intValue));
    }
}
