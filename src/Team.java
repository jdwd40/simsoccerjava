import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    // Constructor
    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = new ArrayList<>(players);
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Method to remove a player from the team
    public void removePlayer(Player player) {
        players.remove(player);
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players); // Return a copy to protect the internal list
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Team: " + name + "\n");
        for (Player player : players) {
            sb.append(player.toString()).append("\n");
        }
        return sb.toString();
    }
}
