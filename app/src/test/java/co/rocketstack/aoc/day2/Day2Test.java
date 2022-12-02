package co.rocketstack.aoc.day2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day2Test {
    @Test
    void getTotalScore() throws FileNotFoundException {
        String filepath = getClass().getResource("Day2.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        int score = 0;
        while (scanner.hasNextLine()) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            String opponentsHand = tokenizer.nextToken();
            String yourHand = tokenizer.nextToken();
            score += RockPaperScissors.playHand(RockPaperScissors.getHand(opponentsHand), RockPaperScissors.getHand(yourHand));
        }
        System.out.println(score);
    }

    @Test
    void getTotalScorePlayingForResult() throws FileNotFoundException {
        String filepath = getClass().getResource("Day2.input").getFile();
        Scanner scanner = new Scanner(new File(filepath));

        int score = 0;
        while (scanner.hasNextLine()) {
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
            String opponentsHand = tokenizer.nextToken();
            String desiredResult = tokenizer.nextToken();
            score += RockPaperScissors.playHandForResult(RockPaperScissors.getHand(opponentsHand), desiredResult);
        }
        System.out.println(score);
    }
}
