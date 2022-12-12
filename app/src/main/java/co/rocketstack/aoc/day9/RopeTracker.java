package co.rocketstack.aoc.day9;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RopeTracker {
    @AllArgsConstructor
    public static class Coodinate {
        private int xOffset;
        private int yOffset;

        public boolean isTouching(Coodinate head) {
            if ((this.yOffset == head.yOffset - 1 ||
                    this.yOffset == head.yOffset ||
                    this.yOffset == head.yOffset + 1) &&
                    (this.xOffset == head.xOffset - 1 ||
                            this.xOffset == head.xOffset ||
                            this.xOffset == head.xOffset + 1)) {
                return true;
            }
            return false;
        }

        public boolean isInSameRowOrColumn(Coodinate head) {
            return this.xOffset == head.xOffset || this.yOffset == head.yOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coodinate coodinate)) return false;
            return xOffset == coodinate.xOffset && yOffset == coodinate.yOffset;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xOffset, yOffset);
        }
    }

    private Set<Coodinate> tailPositions;
    private Coodinate head;
    private Coodinate tail;

    public RopeTracker() {
        tailPositions = new HashSet<>();
        head = new Coodinate(0, 0);
        tail = new Coodinate(0, 0);
        tailPositions.add(tail);
    }

    public enum DIRECTION {
        UP("U"),
        DOWN("D"),
        LEFT("L"),
        RIGHT("R");

        private String direction;

        DIRECTION(String direction) {
            this.direction = direction;
        }

        public static DIRECTION fromString(String direction) {
            return Arrays.stream(DIRECTION.values()).filter(d -> d.direction.equalsIgnoreCase(direction))
                    .findFirst().get();
        }
    }

    public void move(String direction, String steps) {
        DIRECTION d = DIRECTION.fromString(direction);
        int s = Integer.parseInt(steps);

        for (int i = 0; i < s; i++) {
            move(d);
        }
    }

    public void move(DIRECTION direction) {
        switch (direction) {
            case UP:
                head.yOffset--;
                if (!tail.isTouching(head))
                    if (tail.isInSameRowOrColumn(head)) {
                        tail = new Coodinate(tail.xOffset, tail.yOffset - 1);
                    } else {
                        tail = new Coodinate(head.xOffset, tail.yOffset - 1);
                    }
                tailPositions.add(tail);
                break;
            case DOWN:
                head.yOffset++;
                if (!tail.isTouching(head))
                    if (tail.isInSameRowOrColumn(head)) {
                        tail = new Coodinate(tail.xOffset, tail.yOffset + 1);
                    } else {
                        tail = new Coodinate(head.xOffset, tail.yOffset + 1);
                    }
                tailPositions.add(tail);
                break;
            case LEFT:
                head.xOffset--;
                if (!tail.isTouching(head))
                    if (tail.isInSameRowOrColumn(head)) {
                        tail = new Coodinate(tail.xOffset - 1, tail.yOffset);
                    } else {
                        tail = new Coodinate(tail.xOffset - 1, head.yOffset);
                    }
                tailPositions.add(tail);
                break;
            case RIGHT:
                head.xOffset++;
                if (!tail.isTouching(head))
                    if (tail.isInSameRowOrColumn(head)) {
                        tail = new Coodinate(tail.xOffset + 1, tail.yOffset);
                    } else {
                        tail = new Coodinate(tail.xOffset + 1, head.yOffset);
                    }
                tailPositions.add(tail);
                break;
        }
    }

    public int getPositionCount() {
        return tailPositions.size();
    }

}
