package co.rocketstack.aoc.day4;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Range;

@AllArgsConstructor
public class Section {
    int lower;
    int upper;

    public Range<Integer> getRange() {
        return Range.between(lower, upper);
    }
}
