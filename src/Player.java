public class Player {
    private String name;
    private int defense;
    private int attack;
    private int goalkeeping;
    private String position; // e.g., "Attacker", "Defender", "Goalkeeper"
    private int maintenancePoints;

    // Constructor
    public Player(String name, int defense, int attack, int goalkeeping, String position, int maintenancePoints){
        this.name = name;
        this.defense = defense;
        this.attack = attack;
        this.goalkeeping = goalkeeping;
        this.position = position;
        this.maintenancePoints = maintenancePoints;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getGoalkeeping() {
        return goalkeeping;
    }

    public String getPosition() {
        return position;
    }

    public int getMaintenancePoints() {
        return maintenancePoints;
    }

    // Setters
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setGoalkeeping(int goalkeeping) {
        this.goalkeeping = goalkeeping;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMaintenancePoints(int maintenancePoints) {
        this.maintenancePoints = maintenancePoints;
    }

    // Method to reduce maintenance points
    public void reduceMaintenancePoints(int amount) {
        this.maintenancePoints = Math.max(this.maintenancePoints - amount, 0);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", defense=" + defense +
                ", attack=" + attack +
                ", goalkeeping=" + goalkeeping +
                ", position='" + position + '\'' +
                ", maintenancePoints=" + maintenancePoints +
                '}';
    }
}
