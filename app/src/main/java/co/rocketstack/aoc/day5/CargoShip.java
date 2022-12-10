package co.rocketstack.aoc.day5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class CargoShip {
    private List<Stack<String>> stacks;

    public CargoShip(List<String> contents) {
        stacks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<>());
        }
        for (int lineNum = 1; lineNum < contents.size(); lineNum++) {
            String line = contents.get(lineNum);
            for (int count = 1; count < 10; count++) {
                if (getStackPosition(count) <= line.length() - 1) {
                    if (line.charAt(getStackPosition(count)) != ' ')
                        stacks.get(count - 1).push(String.valueOf(line.charAt(getStackPosition(count))));
                }
            }
        }
    }

    static int getStackPosition(int stack) {
        if (stack == 1)
            return 1;
        return ((stack - 1) * 4) + 1;
    }

    public void move(int numberOfCrates, int fromStack, int toStack) {
        for (int i = 0; i < numberOfCrates; i++) {
            stacks.get(toStack - 1).push(stacks.get(fromStack - 1).pop());
        }
    }

    public void move9001(int numberOfCrates, int fromStack, int toStack) {
        Stack<String> tempStack = new Stack<>();
        for (int i = 0; i < numberOfCrates; i++) {
            tempStack.push(stacks.get(fromStack - 1).pop());
        }
        int count = tempStack.size();
        for (int i = 0; i < count; i++) {
            stacks.get(toStack - 1).push(tempStack.pop());
        }
    }

    public void move(String command) {
        String[] commands = command.split(" ");
        this.move(Integer.valueOf(commands[1]), Integer.valueOf(commands[3]), Integer.valueOf(commands[5]));
    }

    public void move9001(String command) {
        String[] commands = command.split(" ");
        this.move9001(Integer.valueOf(commands[1]), Integer.valueOf(commands[3]), Integer.valueOf(commands[5]));
    }

    public String peekAtCrateFromStack(int stack) {
        try {
            return stacks.get(stack - 1).peek();
        } catch (EmptyStackException e) {
            return "";
        }
    }

    public String peekAtCrateFromAllStacks() {
        String topCrates = "";
        for (int i = 1; i <= stacks.size(); i++) {
            topCrates += this.peekAtCrateFromStack(i);
        }
        return topCrates;
    }
}
