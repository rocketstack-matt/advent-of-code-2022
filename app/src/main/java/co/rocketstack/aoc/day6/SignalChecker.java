package co.rocketstack.aoc.day6;

import com.google.common.collect.EvictingQueue;

import java.util.function.Function;
import java.util.stream.Collectors;

public class SignalChecker {
    private EvictingQueue<String> signalBuffer;
    private String dataStream;

    public SignalChecker(String dataStream) {
        signalBuffer = EvictingQueue.create(4);
        this.dataStream = dataStream;
    }

    public String findPacketMarker() {
        for (char c : dataStream.toCharArray()) {
            signalBuffer.add(String.valueOf(c));
            if (signalBuffer.stream().collect(Collectors.groupingBy(Function.identity(),
                    Collectors.counting())).size() == 4)
                break;
        }
        return signalBuffer.stream().collect(Collectors.joining());
    }

    public int findIndexOfPacketMarker() {
        return dataStream.indexOf(findPacketMarker()) + findPacketMarker().length();
    }

}
