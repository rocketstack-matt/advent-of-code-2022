package co.rocketstack.aoc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTest {
    @Test
    void testRockScore() {
        Assert.assertEquals(1, RockPaperScissors.ROCK.score());
    }

    @Test
    void testPaperScore() {
        Assert.assertEquals(2, RockPaperScissors.PAPER.score());
    }

    @Test
    void testScissorsScore() {
        Assert.assertEquals(3, RockPaperScissors.SCISSORS.score());
    }

    @Test
    void testRockBeatsScissors() {
        Assert.assertEquals(7, RockPaperScissors.ROCK.play(RockPaperScissors.SCISSORS));
    }

    @Test
    void testRockLosesToPaper() {
        Assert.assertEquals(1, RockPaperScissors.ROCK.play(RockPaperScissors.PAPER));
    }

    @Test
    void testRockDrawsWithRock() {
        Assert.assertEquals(4, RockPaperScissors.ROCK.play(RockPaperScissors.ROCK));
    }

    @Test
    void testPaperBeatsRock() {
        Assert.assertEquals(8, RockPaperScissors.PAPER.play(RockPaperScissors.ROCK));
    }

    @Test
    void testPaperLosesToScissors() {
        Assert.assertEquals(2, RockPaperScissors.PAPER.play(RockPaperScissors.SCISSORS));
    }

    @Test
    void testPaperDrawsWithPaper() {
        Assert.assertEquals(5, RockPaperScissors.PAPER.play(RockPaperScissors.PAPER));
    }

    @Test
    void tetScissorsBeatsPaper() {
        Assert.assertEquals(9, RockPaperScissors.SCISSORS.play(RockPaperScissors.PAPER));
    }

    @Test
    void testScissorsLosesToRock() {
        Assert.assertEquals(3, RockPaperScissors.SCISSORS.play(RockPaperScissors.ROCK));
    }

    @Test
    void testScissorsDrawsWithScissors() {
        Assert.assertEquals(6, RockPaperScissors.SCISSORS.play(RockPaperScissors.SCISSORS));
    }

    @Test
    void testAandXEqualsRock() {
        Assert.assertEquals(RockPaperScissors.ROCK, RockPaperScissors.getHand("A"));
        Assert.assertEquals(RockPaperScissors.ROCK, RockPaperScissors.getHand("X"));
    }

    @Test
    void testBandYEqualsPaper() {
        Assert.assertEquals(RockPaperScissors.PAPER, RockPaperScissors.getHand("B"));
        Assert.assertEquals(RockPaperScissors.PAPER, RockPaperScissors.getHand("Y"));
    }

    @Test
    void testCandZEqualsScissors() {
        Assert.assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.getHand("C"));
        Assert.assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.getHand("Z"));
    }

    /**
     * In the first round, your opponent will choose Rock (A), and you should choose Paper (Y).
     * This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
     */
    @Test
    void testGivenHandAYYouScore8() {
        Assert.assertEquals(8, RockPaperScissors.playHand(RockPaperScissors.getHand("A"), RockPaperScissors.getHand("Y")));
    }

    /**
     * In the second round, your opponent will choose Paper (B), and you should choose Rock (X).
     * This ends in a loss for you with a score of 1 (1 + 0).
     */
    @Test
    void testGivenHandBXYouScore1() {
        Assert.assertEquals(1, RockPaperScissors.playHand(RockPaperScissors.getHand("B"), RockPaperScissors.getHand("X")));
    }

    /**
     * The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
     */
    @Test
    void testGivenHandCZYouScore6() {
        Assert.assertEquals(6, RockPaperScissors.playHand(RockPaperScissors.getHand("C"), RockPaperScissors.getHand("Z")));
    }

    /**
     * In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
     */
    @Test
    void testTotalScoreFromSampleHandsEquals15() {
        Assert.assertEquals(15,
                RockPaperScissors.playHand(RockPaperScissors.getHand("A"), RockPaperScissors.getHand("Y")) +
                        RockPaperScissors.playHand(RockPaperScissors.getHand("B"), RockPaperScissors.getHand("X")) +
                        RockPaperScissors.playHand(RockPaperScissors.getHand("C"), RockPaperScissors.getHand("Z")));
    }
}