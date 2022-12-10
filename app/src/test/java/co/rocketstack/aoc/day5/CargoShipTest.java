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

    /**
     * As you watch the crane operator expertly rearrange the crates, you notice the process isn't following
     * your prediction.
     * <p>
     * Some mud was covering the writing on the side of the crane, and you quickly wipe it away. The crane isn't a
     * CrateMover 9000 - it's a CrateMover 9001.
     * <p>
     * The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra
     * cup holder, and the ability to pick up and move multiple crates at once.
     * <p>
     * Again considering the example above, the crates begin in the same configuration:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * Moving a single crate from stack 2 to stack 1 behaves the same as before:
     * <p>
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     * 1   2   3
     * However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay
     * in the same order, resulting in this new configuration:
     * <p>
     * [D]
     * [N]
     * [C] [Z]
     * [M] [P]
     * 1   2   3
     * Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
     * <p>
     * [D]
     * [N]
     * [C]     [Z]
     * [M]     [P]
     * 1   2   3
     * Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
     * <p>
     * [D]
     * [N]
     * [Z]
     * [M] [C] [P]
     * 1   2   3
     * In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.
     */
    @Test
    void testMoveNumberOfCratesFromTo9001() {
        ship.move9001("move 1 from 2 to 1");
        ship.move9001("move 3 from 1 to 3");
        ship.move9001("move 2 from 2 to 1");
        ship.move9001("move 1 from 1 to 2");
        Assert.assertEquals("MCD", ship.peekAtCrateFromAllStacks());
    }
}
