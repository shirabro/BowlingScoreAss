import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class GameTest extends TestCase {
    private Game game;

    @Before
    protected void setUp() throws Exception {
        game = new Game();
    }

    protected void rollNTimesNumOfPins(int numOfTimes, int pins) {
        for (int i = 0; i < numOfTimes; i++)
            game.roll(pins);
    }

    @Test
    public void testNoHitGame() throws Exception {
        rollNTimesNumOfPins(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void testSpare() throws Exception {
        game.roll(7);
        game.roll(3);
        game.roll(3);
        rollNTimesNumOfPins(17,0);
        assertEquals(16, game.score());
    }

    @Test
    public void testStrike() throws Exception {
        game.roll(10);
        game.roll(1);
        game.roll(5);
        rollNTimesNumOfPins(16, 0);
        assertEquals(22, game.score());
    }

    @Test
    public void testStrikeAndSpare() throws Exception {
        game.roll(10);
        game.roll(6);
        game.roll(4);
        rollNTimesNumOfPins(16, 0);
        assertEquals(30, game.score());
    }

    @Test
    public void testGameWithNoSpare() {
        game.roll(0);
        game.roll(7);
        game.roll(3);
        game.roll(2);
        rollNTimesNumOfPins(16, 0);
        assertEquals(12, game.score());
    }

    @Test
    public void testFullGame() {
        game.roll(0);
        game.roll(7);
        game.roll(4);
        game.roll(2);
        rollNTimesNumOfPins(14, 2);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        assertEquals(61, game.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollNTimesNumOfPins(12,10);
        assertEquals(300, game.score());
    }
}

