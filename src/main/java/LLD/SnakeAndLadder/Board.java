package LLD.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Board {
    private final int SIZE = 100;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int move(int position, int diceValue) {
        int newPosition = position + diceValue;

        // If the move exceeds 100, remain at the same position
        if (newPosition > SIZE) {
            return position;
        }

        // Check for snakes or ladders
        while (snakes.containsKey(newPosition) || ladders.containsKey(newPosition)) {
            if (snakes.containsKey(newPosition)) {
                newPosition = snakes.get(newPosition); // Move down
            } else if (ladders.containsKey(newPosition)) {
                newPosition = ladders.get(newPosition); // Move up
            }
        }
        return newPosition;
    }

    public boolean hasWon(int position) {
        return position == SIZE;
    }
}
