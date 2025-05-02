package task.scoreboard;

import java.time.Instant;

import static task.scoreboard.ErrorMessage.*;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private final Instant startTime;

    public Match(String homeTeam, String awayTeam) {
        this(homeTeam, awayTeam, Instant.now());
    }

    public Match(String homeTeam, String awayTeam, Instant startTime) {
        if (homeTeam == null || homeTeam.isBlank() || awayTeam == null || awayTeam.isBlank()) {
            throw new IllegalArgumentException(INVALID_TEAM_NAME);
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException(SAME_TEAM_MATCH);
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = startTime;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException(INVALID_SCORE);
        }
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam;
    }
}
