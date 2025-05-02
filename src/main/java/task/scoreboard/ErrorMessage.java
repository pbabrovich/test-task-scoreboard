package task.scoreboard;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static final String TEAM_ALREADY_PLAYING = "One of the teams provided or both teams are already playing";
    public static final String INVALID_TEAM_NAME = "Team names must not be null or blank";
    public static final String SAME_TEAM_MATCH = "A team cannot play against itself";
}
