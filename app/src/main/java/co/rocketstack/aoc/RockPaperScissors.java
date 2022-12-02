package co.rocketstack.aoc;

public enum RockPaperScissors {
    ROCK(1) {
        @Override
        int play(RockPaperScissors hand) {
            switch (hand) {
                case PAPER:
                    return ROCK.score;
                case ROCK:
                    return ROCK.score + 3;
                case SCISSORS:
                    return ROCK.score + 6;
            }
            return 0;
        }

        @Override
        int playFor(String result) {
            switch (result) {
                case "X":
                    return RockPaperScissors.playHand(ROCK, SCISSORS);
                case "Y":
                    return RockPaperScissors.playHand(ROCK, ROCK);
                case "Z":
                    return RockPaperScissors.playHand(ROCK, PAPER);
            }
            return 0;
        }
    },
    PAPER(2) {
        @Override
        int play(RockPaperScissors hand) {
            switch (hand) {
                case PAPER:
                    return PAPER.score + 3;
                case ROCK:
                    return PAPER.score + 6;
                case SCISSORS:
                    return PAPER.score;
            }
            return 0;
        }

        @Override
        int playFor(String result) {
            switch (result) {
                case "X":
                    return RockPaperScissors.playHand(PAPER, ROCK);
                case "Y":
                    return RockPaperScissors.playHand(PAPER, PAPER);
                case "Z":
                    return RockPaperScissors.playHand(PAPER, SCISSORS);
            }
            return 0;
        }
    },
    SCISSORS(3) {
        @Override
        int play(RockPaperScissors hand) {
            switch (hand) {
                case PAPER:
                    return SCISSORS.score + 6;
                case ROCK:
                    return SCISSORS.score;
                case SCISSORS:
                    return SCISSORS.score + 3;
            }
            return 0;
        }

        @Override
        int playFor(String result) {
            switch (result) {
                case "X":
                    return RockPaperScissors.playHand(SCISSORS, PAPER);
                case "Y":
                    return RockPaperScissors.playHand(SCISSORS, SCISSORS);
                case "Z":
                    return RockPaperScissors.playHand(SCISSORS, ROCK);
            }
            return 0;
        }
    };

    private int score;

    RockPaperScissors(int score) {
        this.score = score;
    }

    abstract int play(RockPaperScissors hand);

    abstract int playFor(String result);

    public static int playHand(RockPaperScissors opponentsHand, RockPaperScissors yourHand) {
        return yourHand.play(opponentsHand);
    }

    public static int playHandForResult(RockPaperScissors opponentsHand, String result) {
        return opponentsHand.playFor(result);
    }

    public static RockPaperScissors getHand(String hand) {
        switch (hand) {
            case "A", "X":
                return ROCK;
            case "B", "Y":
                return PAPER;
            case "C", "Z":
                return SCISSORS;
        }
        return null;
    }

    public int score() {
        return this.score;
    }
}
