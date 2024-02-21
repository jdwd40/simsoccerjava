import java.util.Map;

public class MatchResult {
    private final String commentary;
    private final int homeTeamScore;
    private final int awayTeamScore;
    private final String winner;
    private final Map<String, Integer> goalScorers;

    public MatchResult(String commentary, int homeTeamScore, int awayTeamScore, String winner, Map<String, Integer> goalScorers) {
        this.commentary = commentary;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.winner = winner;
        this.goalScorers = goalScorers;
    }

    // Getters for each field...

    @Override
    public String toString() {
        // Implement a string representation of the match result
        StringBuilder result = new StringBuilder();
        result.append("Final Score: ").append(homeTeamScore).append(" - ").append(awayTeamScore).append("\n");
        result.append("Winner: ").append(winner).append("\n");
        result.append("Goal Scorers: ").append(goalScorers.toString()).append("\n");
        result.append("Commentary:\n").append(commentary);
        return result.toString();
    }
}

