public class TeamRating {
    private int attackRating;
    private int midfieldRating;
    private int defenseRating;
    private int goalkeepingRating;

    public TeamRating(int attackRating, int midfieldRating, int defenseRating, int goalkeepingRating) {
        this.attackRating = attackRating;
        this.midfieldRating = midfieldRating;
        this.defenseRating = defenseRating;
        this.goalkeepingRating = goalkeepingRating;
    }

    // Getters for each rating
    public int getAttackRating() {
        return attackRating;
    }

    public int getMidfieldRating() {
        return midfieldRating;
    }

    public int getDefenseRating() {
        return defenseRating;
    }

    public int getGoalkeepingRating() {
        return goalkeepingRating;
    }
}

