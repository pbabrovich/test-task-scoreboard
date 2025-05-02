package task.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static task.scoreboard.ErrorMessage.INVALID_TEAM_NAME;
import static task.scoreboard.ErrorMessage.SAME_TEAM_MATCH;

class MatchKeyTest {
    private static final String MEXICO = "Mexico";
    private static final String CANADA = "Canada";

    @Test
    void shouldCreateMatchKeyWithValidTeams() {
        assertDoesNotThrow(() -> new MatchKey(MEXICO, CANADA));
    }

    @Test
    void shouldThrowWhenHomeTeamIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(null, CANADA));
        assertEquals(INVALID_TEAM_NAME, exception.getMessage());
    }

    @Test
    void shouldThrowWhenAwayTeamIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, null));
        assertEquals(INVALID_TEAM_NAME, exception.getMessage());
    }

    @Test
    void shouldThrowWhenHomeTeamIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey("   ", CANADA));
        assertEquals(INVALID_TEAM_NAME, exception.getMessage());
    }

    @Test
    void shouldThrowWhenAwayTeamIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, " "));
        assertEquals(INVALID_TEAM_NAME, exception.getMessage());
    }

    @Test
    void shouldThrowWhenTeamsAreTheSame() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, MEXICO));
        assertEquals(SAME_TEAM_MATCH, exception.getMessage());
    }
}
