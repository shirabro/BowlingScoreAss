
public class Game {

    private static final int MAX_PINS = 10;
    private static final int MAX_FRAMES = 10;
    private static final int MAX_ROLES = 21;
    private int rolls[];
    private int currentRoll;

    public Game(){
        rolls = new int[MAX_ROLES];
        currentRoll = 0;
    }

    public void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    public int score() {
        int score = 0, roll = 0;
        for (int i = 0; i < MAX_FRAMES; i++) {
            if (isStrike(roll)) {
                score += MAX_PINS + rolls[roll+1] + rolls[roll+2];
                roll++;
            } else if (isSpare(roll)) {
                score += MAX_PINS + rolls[roll+2];
                roll += 2;
            } else {
                score += rolls[roll] + rolls[roll+1];
                roll += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int roll) {return rolls[roll] == MAX_PINS;}

    private boolean isSpare(int roll) {
        return rolls[roll]+rolls[roll+1] == MAX_PINS;
    }
}