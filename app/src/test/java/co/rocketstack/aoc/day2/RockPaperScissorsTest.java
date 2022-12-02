package co.rocketstack.aoc.day2;

import co.rocketstack.aoc.day2.RockPaperScissors;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

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

    @Test
    void testGivenRockAndNeedToWinSoChoosePaperEquals8() {
        Assert.assertEquals(8, RockPaperScissors.ROCK.playFor("Z"));
    }

    @Test
    void testGivenRockAndNeedToDrawSoChooseRockEquals4() {
        Assert.assertEquals(4, RockPaperScissors.ROCK.playFor("Y"));
    }

    @Test
    void testGivenRockAndNeedToLoseSoChooseScissorsEquals3() {
        Assert.assertEquals(3, RockPaperScissors.ROCK.playFor("X"));
    }

    @Test
    void testGivenPaperAndNeedToWinSoChooseScissorsEquals9() {
        Assert.assertEquals(9, RockPaperScissors.PAPER.playFor("Z"));
    }

    @Test
    void testGivenPaperAndNeedToDrawSoChoosePaperEquals5() {
        Assert.assertEquals(5, RockPaperScissors.PAPER.playFor("Y"));
    }

    @Test
    void testGivenPaperAndNeedToLoseSoChooseRockEquals1() {
        Assert.assertEquals(1, RockPaperScissors.PAPER.playFor("X"));
    }

    @Test
    void testGivenScissorsAndNeedToWinSoChooseRockEquals7() {
        Assert.assertEquals(7, RockPaperScissors.SCISSORS.playFor("Z"));
    }

    @Test
    void testGivenScissorsAndNeedToDrawSoChooseScissorsEquals6() {
        Assert.assertEquals(6, RockPaperScissors.SCISSORS.playFor("Y"));
    }

    @Test
    void testGivenScissorsAndNeedToLoseSoChoosePaperEquals1() {
        Assert.assertEquals(2, RockPaperScissors.SCISSORS.playFor("X"));
    }

    /**
     * In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y),
     * so you also choose Rock. This gives you a score of 1 + 3 = 4.
     */
    @Test
    void testGivenOpponentChoosesRockAndYouNeedADrawEquals4() {
        Assert.assertEquals(4, RockPaperScissors.playHandForResult(RockPaperScissors.getHand("A"), "Y"));
    }

    /**
     * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X)
     * with a score of 1 + 0 = 1.
     */
    @Test
    void testGivenOpponentChoosesPaperAndYouNeedToLoseEquals1() {
        Assert.assertEquals(1, RockPaperScissors.playHandForResult(RockPaperScissors.getHand("B"), "X"));
    }

    /**
     * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
     */
    @Test
    void testGivenOpponentChoosesScissorsAndYouNeedToWinEquals7() {
        Assert.assertEquals(7, RockPaperScissors.playHandForResult(RockPaperScissors.getHand("C"), "Z"));
    }

    /**
     * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
     */
    @Test
    void testTotalScoreFromSampleHandsEquals12() {
        Assert.assertEquals(12,
                RockPaperScissors.playHandForResult(RockPaperScissors.getHand("A"), "Y") +
                        RockPaperScissors.playHandForResult(RockPaperScissors.getHand("B"), "X") +
                        RockPaperScissors.playHandForResult(RockPaperScissors.getHand("C"), "Z"));
    }
}