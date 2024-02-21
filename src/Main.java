import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Metro City Team
        List<Player> metroCityPlayers = Arrays.asList(
                new Player("Harry Wilson", 8, 7, 1, "Attacker", 10), // Attacker
                new Player("Oliver Bennett", 7, 8, 1, "Attacker", 10), // Attacker
                new Player("Jack Patterson", 6, 6, 1, "Defender", 10), // Defender
                new Player("Charlie Thompson", 7, 5, 1, "Defender", 10), // Defender
                new Player("Leo Carter", 2, 3, 9, "Goalkeeper", 10) // Goalkeeper
        );


        // Airway City Team
        List<Player> airwayCityPlayers = Arrays.asList(
                new Player("Daniel White", 9, 6, 1, "Attacker", 10), // Attacker
                new Player("Ethan Lewis", 8, 7, 1, "Attacker", 10), // Attacker
                new Player("Oscar Roberts", 8, 5, 1, "Defender", 10), // Defender
                new Player("Max King", 7, 6, 1, "Defender", 10), // Defender
                new Player("Joshua Taylor", 3, 2, 10, "Goalkeeper", 10) // Goalkeeper
        );


        Team metroCity = new Team("Metro City", metroCityPlayers);
        Team airwayCity = new Team("Airway City", airwayCityPlayers);

        // Assume Game class and its simulateMatch method are defined
        Game game = new Game(metroCity, airwayCity);
        game.playGame();
        MatchResult result = game.getMatchResult();
        System.out.println(result);



    }
}
