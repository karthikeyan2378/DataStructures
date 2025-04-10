package LLD.SnakeAndLadder;

import java.util.*;

class Game {
    private final Board board;
    private final List<Player> players;
    private final Random dice;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.dice = new Random();
    }

    public void startGame() {
        boolean gameWon = false;
        int turn = 0;

        while (!gameWon) {
            Player currentPlayer = players.get(turn % players.size());
            int diceValue = rollDice();
            int initialPosition = currentPlayer.getPosition();
            int newPosition = board.move(initialPosition, diceValue);

            System.out.println(currentPlayer.getName() + " rolled a " + diceValue +
                    " and moved from " + initialPosition + " to " + newPosition);

            currentPlayer.setPosition(newPosition);

            if (board.hasWon(newPosition)) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                gameWon = true;
            }

            turn++;
        }
    }

    private int rollDice() {
        return dice.nextInt(6) + 1; // Random number between 1 and 6
    }
}
