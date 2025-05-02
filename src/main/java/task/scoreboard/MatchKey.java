package task.scoreboard;

public record MatchKey(String homeTeam, String awayTeam) {

    @Override
    public String toString() {
        return homeTeam + " vs " + awayTeam;
    }
}
