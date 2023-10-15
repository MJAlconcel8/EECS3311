package assignment1;

import java.util.List;

public class BoardEvaluatorImpl implements BoardEvaluator {

    /**
     * Calculates a score for the given Board
     * A higher score means the Musketeer is winning
     * A lower score means the Guard is winning
     * Add heuristics to generate a score given a Board
     * @param board Board to calculate the score of
     * @return int Score of the given Board
     */
    @Override
    public int evaluateBoard(Board board) { // TODO
        int musketeerScore = 0; // initalize the score for the musketeer to be 0
        List<Cell> musketeerCells = board.getMusketeerCells(); // get access to the list of musketeer cells using the method getMusketeerCells() and store it in a variable called musketeercells
        List<Cell> guardCells = board.getGuardCells(); // get access to the list of guard cells using the getGuardCellMethod, and store in a variable called guardCells
        for (int i = 0; i < musketeerCells.size(); i++) { // iterate threw the list musketeer at index 0
            for (int j = i + 1; j < musketeerCells.size(); j++) { // iterate starting from musketeer at index 1, that ensure that all musketeers paired up with each other at least once
                Coordinate coordinate1 = musketeerCells.get(i).getCoordinate(); // get the coordinate of one of the musketeer
                Coordinate coordinate2 = musketeerCells.get(j).getCoordinate(); // get the coordinate of the other musketeer
                int distance = Math.abs(coordinate1.row - coordinate2.row) + Math.abs(coordinate1.col - coordinate2.col); // calculate the overall distance between each pair of musketeer
                musketeerScore += distance; // update the musketeer score by the total distance between a pair of two out of the three musketeers
            }
        }
        int guardScore = guardCells.size(); // initalize a variable called guardScore and assign it to the size of the guardCells
        return musketeerScore - guardScore; // lastly return the difference between musketeerScore and guardScore
    }
}
