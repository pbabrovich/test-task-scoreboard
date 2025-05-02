package task.scoreboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static task.scoreboard.ErrorMessage.MATCH_NOT_FOUND;
import static task.scoreboard.ErrorMessage.TEAM_ALREADY_PLAYING;

public class ScoreBoard {
    Map<MatchKey, Match> matches = new HashMap<>();

    public List<Match> getSummary() {
        return matches.values().stream().toList();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        validateTeamsAreAvailable(homeTeam, awayTeam);
        Match match = new Match(homeTeam, awayTeam);
        matches.put(new MatchKey(homeTeam, awayTeam), match);
    }

    public void updateScore(String homTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
        Match match = matches.get(new MatchKey(homTeam, awayTeam));
        requireMatchExistsOrThrow(match);
        match.setScore(homeTeamScore, awayTeamScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        MatchKey key = new MatchKey(homeTeam, awayTeam);
        Match removed = matches.remove(key);
        requireMatchExistsOrThrow(removed);
    }

    private void requireMatchExistsOrThrow(Object matchOrRemoved) {
        if (matchOrRemoved == null) {
            throw new IllegalArgumentException(MATCH_NOT_FOUND);
        }
    }

    private void validateTeamsAreAvailable(String homeTeam, String awayTeam) {
        if (isTeamInUse(homeTeam) || isTeamInUse(awayTeam)) {
            throw new IllegalArgumentException(TEAM_ALREADY_PLAYING);
        }
    }

    private boolean isTeamInUse(String team) {
        return matches.keySet().stream().anyMatch(key -> key.homeTeam().equals(team) ||
                key.awayTeam().equals(team));
    }
}
