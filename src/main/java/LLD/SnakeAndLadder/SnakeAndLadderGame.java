package LLD.SnakeAndLadder;

import java.util.*;

public class SnakeAndLadderGame {
    public static void main(String[] args) {

        // Read number of snakes
        System.out.print("Number of snakes: ");
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(99, 10);
        snakes.put(95, 20);
        snakes.put(75, 32);

        // Read number of ladders
        System.out.print("Number of ladders: ");
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(5, 50);
        ladders.put(25, 80);
        ladders.put(40, 70);

        // Read number of players
        System.out.print("Number of players: ");
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        // Initialize Board and Game
        Board board = new Board(snakes, ladders);
        Game game = new Game(board, players);

        // Start the game
        game.startGame();
    }
}
