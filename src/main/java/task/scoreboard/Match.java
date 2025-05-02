package task.scoreboard;

import static task.scoreboard.ErrorMessage.INVALID_TEAM_NAME;
import static task.scoreboard.ErrorMessage.SAME_TEAM_MATCH;

public class Match {
    private final String homeTeam;
    private final String awayTeam;

    public Match(String homeTeam, String awayTeam) {
        if (homeTeam == null || homeTeam.isBlank() || awayTeam == null || awayTeam.isBlank()) {
            throw new IllegalArgumentException(INVALID_TEAM_NAME);
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException(SAME_TEAM_MATCH);
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }
}
