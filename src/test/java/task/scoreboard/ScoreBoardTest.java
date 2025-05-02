package task.scoreboard;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static task.scoreboard.ErrorMessage.*;

class ScoreBoardTest {
    private static final String MEXICO = "Mexico";
    private static final String CANADA = "Canada";
    private static final String BRAZIL = "Brazil";
    private static final String SPAIN = "Spain";


    @Nested
    class MatchCreationTests {
        @Test
        void matchShouldBeStarted() {
            ScoreBoard scoreboard = new ScoreBoard();
            scoreboard.startMatch(MEXICO, BRAZIL);
            assertEquals(1, scoreboard.getSummary().size());
        }

        @Test
        void shouldNotAllowSameTeam() {
            ScoreBoard scoreboard = new ScoreBoard();
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> scoreboard.startMatch(MEXICO, MEXICO));
            assertEquals(SAME_TEAM_MATCH, exception.getMessage());
        }

        @Test
        void shouldNotAllowBlankTeamNames() {
            ScoreBoard scoreboard = new ScoreBoard();
            IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                    () -> scoreboard.startMatch(" ", BRAZIL));
            IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                    () -> scoreboard.startMatch(MEXICO, ""));
            assertEquals(INVALID_TEAM_NAME, exception1.getMessage());
            assertEquals(INVALID_TEAM_NAME, exception2.getMessage());
        }

        @Test
        void shouldPreventTeamFromPlayingTwice() {
            ScoreBoard scoreboard = new ScoreBoard();
            scoreboard.startMatch(MEXICO, BRAZIL);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> scoreboard.startMatch(MEXICO, CANADA));
            assertEquals(TEAM_ALREADY_PLAYING, exception.getMessage());
        }

        @Test
        void shouldThrowWhenBothTeamsAreAlreadyPlayingInOtherMatches() {
            ScoreBoard scoreboard = new ScoreBoard();
            scoreboard.startMatch(MEXICO, CANADA);
            scoreboard.startMatch(SPAIN, BRAZIL);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> scoreboard.startMatch(MEXICO, BRAZIL));
            assertEquals(TEAM_ALREADY_PLAYING, exception.getMessage());
        }
    }
}

