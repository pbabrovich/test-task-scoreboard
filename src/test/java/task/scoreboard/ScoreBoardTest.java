package task.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {
    private static final String MEXICO = "Mexico";
    private static final String CANADA = "Canada";

    @Test
    void shouldStartMatchSuccessfully() {
        ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.startMatch(MEXICO, CANADA);

        assertEquals(1, scoreboard.getSummary().size());
        assertEquals(MEXICO, scoreboard.getSummary().get(0).getHomeTeam());
        assertEquals(CANADA, scoreboard.getSummary().get(0).getAwayTeam());
    }
}

