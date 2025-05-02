package task.scoreboard;

import static task.scoreboard.ErrorMessage.INVALID_TEAM_NAME;
import static task.scoreboard.ErrorMessage.SAME_TEAM_MATCH;

public record MatchKey(String homeTeam, String awayTeam) {
    public MatchKey {
        if (homeTeam == null || homeTeam.isBlank() ||
                awayTeam == null || awayTeam.isBlank()) {
            throw new IllegalArgumentException(INVALID_TEAM_NAME);
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException(SAME_TEAM_MATCH);
        }
    }

    @Override
    public String toString() {
        return homeTeam + " vs " + awayTeam;
    }
}
