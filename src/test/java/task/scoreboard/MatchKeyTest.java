package task.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("Team names cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowWhenAwayTeamIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, null));
        assertEquals("Team names cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowWhenHomeTeamIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey("   ", CANADA));
        assertEquals("Team names cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowWhenAwayTeamIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, " "));
        assertEquals("Team names cannot be null or blank", exception.getMessage());
    }

    @Test
    void shouldThrowWhenTeamsAreTheSame() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new MatchKey(MEXICO, MEXICO));
        assertEquals("Teams must be different", exception.getMessage());
    }
}
