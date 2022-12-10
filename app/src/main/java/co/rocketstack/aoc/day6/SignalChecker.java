package co.rocketstack.aoc.day6;

import com.google.common.collect.EvictingQueue;

import java.util.function.Function;
import java.util.stream.Collectors;

public class SignalChecker {
    private EvictingQueue<String> signalBuffer;
    private String dataStream;
    private EvictingQueue<String> messageBuffer;

    public SignalChecker(String dataStream) {
        signalBuffer = EvictingQueue.create(4);
        this.dataStream = dataStream;
        messageBuffer = EvictingQueue.create(14);
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

    public String findMessageMarker() {
        for (char c : dataStream.toCharArray()) {
            messageBuffer.add(String.valueOf(c));
            if (messageBuffer.stream().collect(Collectors.groupingBy(Function.identity(),
                    Collectors.counting())).size() == 14)
                break;
        }
        return messageBuffer.stream().collect(Collectors.joining());
    }

    public int findIndexOfMessageMarker() {
        return dataStream.indexOf(findMessageMarker()) + findMessageMarker().length();
    }
}
