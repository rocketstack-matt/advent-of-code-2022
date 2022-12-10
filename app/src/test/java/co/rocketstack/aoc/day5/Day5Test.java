package co.rocketstack.aoc.day5;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5Test {
    @Test
    void loadDay5Ship() throws FileNotFoundException {
        String filepath = getClass().getResource("Day5.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        List<String> shipContents = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                break;
            shipContents.add(line);
        }
        Collections.reverse(shipContents);
        CargoShip ship = new CargoShip(shipContents);

        while (scanner.hasNextLine()) {
            ship.move(scanner.nextLine());
        }

        System.out.println(ship.peekAtCrateFromAllStacks());
    }
}
