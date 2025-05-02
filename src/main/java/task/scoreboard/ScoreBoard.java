package task.scoreboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    Map<MatchKey, Match> matches = new HashMap<>();

    public List<Match> getSummary() {
        return matches.values().stream().toList();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.put(new MatchKey(homeTeam, awayTeam), match);
    }
}
