package co.rocketstack.aoc.day4;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class RangeFinder {
    private List<Pair<Range<Integer>, Range<Integer>>> sectionPairs;

    public RangeFinder() {
        sectionPairs = new ArrayList<>();
    }

    public void addPair(Range<Integer> first, Range<Integer> second) {
        sectionPairs.add(Pair.of(first, second));
    }

    public int getNumberOfEntirelyOverlappingSections() {
        int count = 0;
        for (Pair<Range<Integer>, Range<Integer>> pair : sectionPairs) {
            if (pair.getLeft().containsRange(pair.getRight()) ||
                    pair.getRight().containsRange(pair.getLeft())) count++;
        }
        return count;
    }
}
