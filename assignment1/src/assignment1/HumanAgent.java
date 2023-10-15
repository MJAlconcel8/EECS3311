package assignment1;

import assignment1.Exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanAgent extends Agent {

    public HumanAgent(Board board) {
        super(board);
    }

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() { // TODO
        Scanner scanner = new Scanner(System.in); // declare a new scanner called scanner and pass in System.in
        Cell fromCell = null; // declare a Cell variable called fromCell and temporarily set it to null, this is where the piece you want to move is currently at
        Cell toCell = null; // declare a Cell variable called toCell and temporarily set it to null, this is where the destination cells is located
        boolean validFromInput = false; // declare a variable called validFromInput, this checks whether user input is valid
        boolean validToInput = false;  // declare a variable called validToInput, this checks whether user input is valid
        while (validFromInput==false) { // while the input is not valid
            List<String> fromCoordinates = new ArrayList<>(); // declare an arraylist called fromCoordinates, this hold cell coordinates that have pieces that can be moved, in string format
            for (Cell cell : this.board.getPossibleCells()) { // in the for each look loop over the getPossibleCells as, it is of type list, to find all cells with pieces that can be moved
                fromCoordinates.add(cell.getCoordinate().toString()); // add to the fromCoordinates list the coordinates of the cell, and convert it to type string using the toString()
            }
            String coordinatesToStringFrom = String.join(", ", fromCoordinates); // combine the strings in the fromCoordinates arraylist into one string and store it in the coordinatesToStringFrom
            System.out.printf("It is player %s turn to Move, please choose a cell and move a piece. Valid cells are: %s ", board.getTurn().getType(), coordinatesToStringFrom); // print statement telling user to input a valid coordinate to specify the cell the piece they want to move is located
            String fromInput = scanner.next().toUpperCase(); // take in user input using scanner.next().toUpperCase() and assign it to a String variable called fromInput and make all letters capitalized

            if (fromInput.length() == 2) { // check if the string input is equal to 2
                char column = fromInput.charAt(0); // get the first letter of the output and assign it to a char variable called column
                char row = fromInput.charAt(1);  // get the second letter of the output and assign it to a char variable called row

                if ((column >= 'A' && column <= 'E' || column >= 'a' && column <= 'e') && (row >= '1' && row <= '5') && coordinatesToStringFrom.contains(fromInput)) {
                    //check if the column is either letters from capital or lowercase letters from A to E inclusive and the row is between 1 or 5 inclusive if it is then enter the try block
                    try {
                        fromCell = this.board.getCell(Utils.parseUserMove(fromInput)); // assign the previous null fromCell to this.board.getCell(Utils.parseUserMove(fromInput))
                        validFromInput = true; // reassign validFromInput to true
                    }
                    catch (InvalidMoveException e) { // catch any InvalidMoveException
                        throw new RuntimeException(e); // throw a new RuntimeException by passing in parameter e
                    }
                }
            }
            if (validFromInput==false) { // check if validFromInput is still false
                System.out.print(fromInput + "This cell is not valid, please please choose a cell and move a piece. Valid cells are: %s\n"); // print statement to tell the user the move is still invalid
            }
        }
        while (validToInput==false) {// while the validToInput is false
            List<String> toCoordinates = new ArrayList<>();
            for (Cell cell : this.board.getPossibleDestinations(fromCell)) { // declare an arraylist called toCoordinates, this hold cell coordinates that can be moved on to, in string format
                toCoordinates.add(cell.getCoordinate().toString()); // add to the toCoordinates list the coordinates of the cell, and convert it to type string using the toString()
            }
            String coordinatesToStringTo = String.join(", ", toCoordinates);  // combine the strings in the toCoordinates arraylist into one string and store it in the coordinatesToStringFrom, combine anything separated by ,
            System.out.printf("Player %s, please choose a cell to move your piece to. Valid cells are: %s ", board.getTurn().getType(), coordinatesToStringTo); // print statement telling user to input a valid coordinate to specify the cell they want their piece to move on to
            String toInput = scanner.next().toUpperCase(); // take in user input using scanner.next().toUpperCase() and assign it to a String variable called toInput and make all letters capitalized
            if (toInput.length() == 2) {  // check if the string input is equal to 2
                char column = toInput.charAt(0); // get the first letter of the output and assign it to a char variable called column
                char row = toInput.charAt(1); // get the second letter of the output and assign it to a char variable called row

                if ((column >= 'A' && column <= 'E' || column >= 'a' && column <= 'e') && (row >= '1' && row <= '5') && coordinatesToStringTo.contains(toInput)) {
                    //check if the column is either letters from capital or lowercase letters from A to E inclusive and the row is between 1 or 5 inclusive if it is then enter the try block
                    try {
                        toCell = this.board.getCell(Utils.parseUserMove(toInput)); // assign the previous null toCell to this.board.getCell(Utils.parseUserMove(toInput)), which converts
                        validToInput = true;  // reassign validFromInput to true
                    }
                    catch (InvalidMoveException e) { // catch any InvalidMoveException
                        throw new RuntimeException(e); // throw a new RuntimeException by passing in parameter e
                    }
                }
            }
            if (!validToInput) { // check if validToInput is still false
                System.out.print(toInput + " That cell is not valid, please choose a cell to move your piece to. Valid cells are: %s\n");  // print statement to tell the user the move is still invalid
            }
        }
        return new Move(fromCell, toCell); // return a new Move and pass in the fromCell and toCell
    }
}
