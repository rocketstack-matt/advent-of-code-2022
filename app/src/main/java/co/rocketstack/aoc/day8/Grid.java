package co.rocketstack.aoc.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {
    List<List<Integer>> trees;

    public Grid() {
        trees = new ArrayList<>();
    }

    public void addRowOfTrees(char[] row) {
        List<Integer> rowOfTrees = new ArrayList<>();
        for (char c : row) {
            rowOfTrees.add(Integer.valueOf(String.valueOf(c)));
        }
        trees.add(rowOfTrees);
    }

    public int get(int x, int y) {
        return trees.get(y).get(x);
    }

    public boolean treeIsVisible(int x, int y) {
        return treeIsVisibleFromLeft(x, y) ||
                treeIsVisibleFromRight(x, y) ||
                treeIsVisibleFromAbove(x, y) ||
                treeIsVisibleFromBelow(x, y);
    }

    boolean treeIsVisibleFromLeft(int x, int y) {
        // Check visible from left
        if (x == 0)
            return true;
        if (get(x, y) > getHighestTree(trees.get(y).subList(0, x)))
            return true;
        return false;
    }

    boolean treeIsVisibleFromRight(int x, int y) {
        // Check visible from right
        if (x == trees.get(y).size() - 1)
            return true;
        if (get(x, y) > getHighestTree(trees.get(y).subList(x + 1, trees.get(y).size())))
            return true;
        return false;
    }

    boolean treeIsVisibleFromAbove(int x, int y) {
        // Check visible from above
        if (y == 0)
            return true;
        if (get(x, y) > getHighestTree(getTreesAbove(x, y)))
            return true;
        return false;
    }

    boolean treeIsVisibleFromBelow(int x, int y) {
        // Check visible from below
        if (y == trees.size() - 1)
            return true;
        if (get(x, y) > getHighestTree(getTreesBelow(x, y)))
            return true;
        return false;
    }

    List<Integer> getTreesAbove(int x, int y) {
        List<Integer> treesAbove = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            treesAbove.add(get(x, i));
        }
        return treesAbove;
    }

    List<Integer> getTreesBelow(int x, int y) {
        List<Integer> treesBelow = new ArrayList<>();
        for (int i = y + 1; i < trees.size(); i++) {
            treesBelow.add(get(x, i));
        }
        return treesBelow;
    }

    int getHighestTree(List<Integer> trees) {
        List<Integer> orderedList = trees.stream().sorted().collect(Collectors.toList());
        return orderedList.get(orderedList.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Integer> row : trees) {
            for (Integer tree : row) {
                builder.append(tree);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public int getVisibleTrees() {
        int count = 0;
        for (int x = 0; x < trees.get(0).size(); x++) {
            for (int y = 0; y < trees.size(); y++) {
                if (treeIsVisible(x, y))
                    count++;
            }
        }
        return count;
    }
}
