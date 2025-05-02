package task.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {

    @Test
    void shouldStartMatchSuccessfully() {
        ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.startMatch("Mexico", "Canada");

        assertEquals(1, scoreboard.getSummary().size());
        assertEquals("Mexico", scoreboard.getSummary().get(0).getHomeTeam());
        assertEquals("Canada", scoreboard.getSummary().get(0).getAwayTeam());
    }
}

