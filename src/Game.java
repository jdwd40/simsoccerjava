import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Random random;
    private StringBuilder commentary;
    private enum State { ATTACKING, DEFENDING, NEUTRAL }

    private State homeTeamState;
    private State awayTeamState;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;
    private Map<String, Integer> goalScorers = new HashMap<>();

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.random = new Random();
        this.commentary = new StringBuilder();
        this.homeTeamState = State.NEUTRAL;
        this.awayTeamState = State.NEUTRAL;
    }

    public void playGame() {
        appendScoreUpdate("--- Kick off", 0, 0); // Score at the start
        for (int minute = 0; minute < 90; minute++) {
            simulateMinute(minute);
            if (minute == 45) {
                appendScoreUpdate("---  Half time", homeTeamScore, awayTeamScore); // Score at half time
            }

        }
        appendScoreUpdate("--- Full time", homeTeamScore, awayTeamScore); // Score at full time
        // System.out.println(commentary.toString());
    }

    private void simulateMinute(int minute) {
        // Check and update team states
        updateTeamStates(minute);

        // Depending on the state, simulate different events
        if (homeTeamState == State.ATTACKING) {
            handleAttack(minute, homeTeam, awayTeam);

        } else if (awayTeamState == State.ATTACKING) {
            handleAttack(minute, awayTeam, homeTeam);

        }
        // Other game logic...
    }

    private void updateTeamStates(int minute) {
        // Example logic for state transition
        if (homeTeamState == State.NEUTRAL && random.nextDouble() < 0.3) { // 30% chance to start attacking
            homeTeamState = State.ATTACKING;
            awayTeamState = State.DEFENDING;
            commentary.append(minute).append(" - ").append(homeTeam.getName()).append(" presses forward.\n");
        } else if (homeTeamState == State.ATTACKING && random.nextDouble() < 0.2) { // 20% chance to be pushed back
            homeTeamState = State.NEUTRAL;
            awayTeamState = State.NEUTRAL;
            commentary.append(minute).append(" - ").append(awayTeam.getName()).append(" shuts them down.\n");
        }
        // Away team logic...
        if (awayTeamState == State.NEUTRAL && random.nextDouble() < 0.3) { // 30% chance to start attacking
            awayTeamState = State.ATTACKING;
            homeTeamState = State.DEFENDING;
            commentary.append(minute).append(" - ").append(awayTeam.getName()).append(" presses forward.\n");
        } else if (awayTeamState == State.ATTACKING && random.nextDouble() < 0.2) { // 20% chance to be pushed back
            awayTeamState = State.NEUTRAL;
            homeTeamState = State.NEUTRAL;
            commentary.append(minute).append(" - ").append(homeTeam.getName()).append(" shuts them down.\n");
        }
    }

    private void handleAttack(int minute, Team attackingTeam, Team defendingTeam) {
        // Logic to handle attack, including goal attempts, shooting, blocking, etc.
        if (random.nextDouble() < 0.1) { // Example: 10% chance for a shot attempt
            boolean isGoal = attemptGoal(minute, attackingTeam, defendingTeam);

            if (isGoal) {
                commentary.append(minute).append(" - ").append("GOAL!\n").append(attackingTeam.getName()).append(" scores, in the ").append(minute).append("th minute!\n");
                // Update scores
            } else {
                commentary.append("    ").append("The shot is Saved! ").append(defendingTeam.getName()).append(" blocks the shot!\n");
            }
        }
    }

    private boolean attemptGoal(int minute, Team attackingTeam, Team defendingTeam) {
        Player shooter = chooseShooter(attackingTeam); // Choose the player attempting the goal
        Player goalkeeper = chooseGoalkeeper(defendingTeam);

        double shotChance = calculateShotChance(shooter, goalkeeper);
        boolean isGoal = random.nextDouble() < shotChance;

        commentary.append(attackingTeam.getName()).append(" shoots! ");

        if (isGoal) {
            // Goal is scored
            commentary.append("    !!!!!!!GOAL!!!!!!!!! ").append(attackingTeam.getName()).append(" scores!\n");
            // goalScorers.put(shooter.getName(), goalScorers.getOrDefault(shooter.getName(), 0) + 1);
            commentary.append(minute).append("' - Goal by ").append(shooter.getName()).append("! ");
            commentary.append(attackingTeam.getName()).append(" scores!\n");
            updateScore(attackingTeam);

        } else {
            // Shot missed or saved
            commentary.append("    The shot is saved!\n");
            commentary.append(minute).append("' - ").append(shooter.getName()).append(" attempted the shot, saved by ")
                    .append(goalkeeper.getName()).append(".\n");
        }
        appendScoreUpdate("Latest Score", homeTeamScore, awayTeamScore);
        return isGoal;
    }

    private double calculateShotChance(Player shooter, Player goalkeeper) {
        // Simplified logic to calculate the chance of a shot being a goal
        // In a real game, this should be based on player stats
        double shotChance = 0.5;
        if (shooter.getPosition().equals("Attacker")) {
            shotChance += 0.2;
        } else if (shooter.getPosition().equals("Defender")) {
            shotChance -= 0.2;
        }
        if (goalkeeper.getPosition().equals("Goalkeeper")) {
            shotChance -= 0.2;
        }
        return shotChance;
    }

    private void updateScore(Team team) {
        if (team == homeTeam) {
            homeTeamScore++;
        } else {
            awayTeamScore++;
        }
    }

    private Player chooseShooter(Team team) {
        // Simplified logic to choose a random player from the team
        // In a real game, this should be based on player positions and stats
        List<Player> players = team.getPlayers();
        return players.get(random.nextInt(players.size()));
    }

    private Player chooseGoalkeeper(Team team) {
        // Simplified logic to choose a random player from the team
        // In a real game, this should be based on player positions and stats
        List<Player> players = team.getPlayers();
        return players.get(random.nextInt(players.size()));
    }

    private void handleGoal(int minute, Team scoringTeam, Team concedingTeam) {
        // Logic to handle goal, including goal scorer, etc.
        Player scorer = chooseScorer(scoringTeam);
        commentary.append(minute).append("' - Goal by ").append(scorer.getName()).append("! ");
        commentary.append(scoringTeam.getName()).append(" scores!\n");
        updateScore(scoringTeam);
        goalScorers.put(scorer.getName(), goalScorers.getOrDefault(scorer.getName(), 0) + 1);
    }

    private Player chooseScorer(Team team) {
        // Simplified logic to choose a random player from the team
        // In a real game, this should be based on player positions and stats
        List<Player> players = team.getPlayers();
        return players.get(random.nextInt(players.size()));
    }

    private void appendScoreUpdate(String message, int homeTeamScore, int awayTeamScore) {
        commentary.append("    ").append(message).append(" - ").append(homeTeam.getName()).append(" ").append(homeTeamScore).append(" - ")
                .append(awayTeamScore).append(" ").append(awayTeam.getName()).append("\n");
    }

    public MatchResult getMatchResult() {
        String winner;
        if (homeTeamScore > awayTeamScore) {
            winner = homeTeam.getName();
        } else if (awayTeamScore > homeTeamScore) {
            winner = awayTeam.getName();
        } else {
            winner = "Draw";
        }

        return new MatchResult(commentary.toString(), homeTeamScore, awayTeamScore, winner, goalScorers);
    }

    // Other methods...
}
