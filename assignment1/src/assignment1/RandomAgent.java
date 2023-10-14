package assignment1;

import java.util.List;
import java.util.Random;

public class RandomAgent extends Agent {

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove() {
        List<Move> possibleMoves = this.board.getPossibleMoves(); // get access to the possible moves using the getPossibleMoves method and assign it to possibleMoves
        Random random = new Random(); // declare a Random Variable using the builtin method called random and assign it a variable called random
        while (!possibleMoves.isEmpty()) { // while there are still possible moves
            int randomIndex = random.nextInt(possibleMoves.size()); // get a random coordinate for valid cells, using random.nextInt and passing possibleMoves.size() and assign it to a variable called randomIndex
            Move randomMove = possibleMoves.get(randomIndex); // declare a Move called randomMove, by doing possibleMoves.get() and passing in randOmIndex
            if (this.board.isValidMove(randomMove)) { // Check if the randomly selected move is valid
                return randomMove; // if it is return the randomMove
            }
            else {
                possibleMoves.remove(randomMove); // Remove the invalid move from the list of possible moves and try again
            }
        }
        return null; // If no valid move is found, return null
    }

}

