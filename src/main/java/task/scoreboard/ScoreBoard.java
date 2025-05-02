package task.scoreboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
