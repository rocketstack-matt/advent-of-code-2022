package co.rocketstack.aoc.day5;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CargoShipTest {

    private CargoShip ship;

    @BeforeEach
    public void loadShip() throws FileNotFoundException {
        String filepath = getClass().getResource("Sample.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        List<String> shipContents = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                break;
            shipContents.add(line);
        }
        Collections.reverse(shipContents);
        ship = new CargoShip(shipContents);
    }

    @Test
    void testGetStackPosition() {
        Assert.assertEquals(1, CargoShip.getStackPosition(1));
        Assert.assertEquals(5, CargoShip.getStackPosition(2));
        Assert.assertEquals(9, CargoShip.getStackPosition(3));
        Assert.assertEquals(13, CargoShip.getStackPosition(4));
        Assert.assertEquals(17, CargoShip.getStackPosition(5));
        Assert.assertEquals(21, CargoShip.getStackPosition(6));
        Assert.assertEquals(25, CargoShip.getStackPosition(7));
        Assert.assertEquals(29, CargoShip.getStackPosition(8));
        Assert.assertEquals(33, CargoShip.getStackPosition(9));
    }

    @Test
    void testLoadShip() {
        Assert.assertEquals("N", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("D", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("P", ship.peekAtCrateFromStack(3));
    }

    /**
     * In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1,
     * resulting in this configuration:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * <p>
     * In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time,
     * so the first crate to be moved (D) ends up below the second and third crates:
     * <p>
     * [Z]
     * [N]
     * [C] [D]
     * [M] [P]
     * 1   2   3
     * <p>
     * Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time,
     * crate C ends up below crate M:
     * <p>
     * [Z]
     * [N]
     * [M]     [D]
     * [C]     [P]
     * 1   2   3
     * <p>
     * Finally, one crate is moved from stack 1 to stack 2:
     * <p>
     * [Z]
     * [N]
     * [D]
     * [C] [M] [P]
     * 1   2   3
     */
    @Test
    void testMoveNumberOfCratesFromTo() {
        ship.move(1, 2, 1);
        Assert.assertEquals("D", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("C", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("P", ship.peekAtCrateFromStack(3));

        ship.move(3, 1, 3);
        Assert.assertEquals("", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("C", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));

        ship.move(2, 2, 1);
        Assert.assertEquals("M", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));

        ship.move(1, 1, 2);
        Assert.assertEquals("C", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("M", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));
    }

    @Test
    void testMoveFromCommand() {
        ship.move("move 1 from 2 to 1");
        Assert.assertEquals("D", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("C", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("P", ship.peekAtCrateFromStack(3));

        ship.move("move 3 from 1 to 3");
        Assert.assertEquals("", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("C", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));

        ship.move("move 2 from 2 to 1");
        Assert.assertEquals("M", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));

        ship.move("move 1 from 1 to 2");
        Assert.assertEquals("C", ship.peekAtCrateFromStack(1));
        Assert.assertEquals("M", ship.peekAtCrateFromStack(2));
        Assert.assertEquals("Z", ship.peekAtCrateFromStack(3));
    }

    @Test
    void peekAtAllCrates() {
        ship.move("move 1 from 2 to 1");
        Assert.assertEquals("DCP", ship.peekAtCrateFromAllStacks());

        ship.move("move 3 from 1 to 3");
        Assert.assertEquals("CZ", ship.peekAtCrateFromAllStacks());

        ship.move("move 2 from 2 to 1");
        Assert.assertEquals("MZ", ship.peekAtCrateFromAllStacks());

        ship.move("move 1 from 1 to 2");
        Assert.assertEquals("CMZ", ship.peekAtCrateFromAllStacks());
    }
}
