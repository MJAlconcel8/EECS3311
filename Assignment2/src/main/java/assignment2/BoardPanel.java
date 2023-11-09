package assignment2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.List;

public class BoardPanel extends GridPane implements EventHandler<ActionEvent> {

    private final View view;
    private final Board board;
    private Cell toCell = null;
    private boolean isCurrentlyPicking = true;


    /**
     * Constructs a new GridPane that contains a Cell for each position in the board
     *
     * Contains default alignment and styles which can be modified
     * @param view
     * @param board
     */
    public BoardPanel(View view, Board board) {
        this.view = view;
        this.board = board;

        // Can modify styling
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #181a1b;");
        int size = 550;
        this.setPrefSize(size, size);
        this.setMinSize(size, size);
        this.setMaxSize(size, size);

        setupBoard();
        updateCells();
    }


    /**
     * Setup the BoardPanel with Cells
     */
    private void setupBoard(){ // TODO
        for (int i = 0; i < board.size; i++) { // for loop to traverse the first row of the board
            for (int j = 0; j < board.size; j++) { // for loop to traverse the columns of the board, not all boards are traversable
                Cell cell = board.getCell(new Coordinate(i, j)); // declare a variable called cell, which gets the Cell, given the coordinates, i and J
                cell.setOnAction(this); // use setOnAction(this), so if the cell is clicked, it will be responsive, allowing to move pieces on the board
                if (cell.getPiece()!=null) { // if the cell is not null, it contains a piece
                    this.add(cell, i, j); // add the cell to the board and it's coordinates
                }
            }
        }
    }

    /**
     * Updates the BoardPanel to represent the board with the latest information
     *
     * If it's a computer move: disable all cells and disable all game controls in view
     *
     * If it's a human player turn and they are picking a piece to move:
     *      - disable all cells
     *      - enable cells containing valid pieces that the player can move
     * If it's a human player turn and they have picked a piece to move:
     *      - disable all cells
     *      - enable cells containing other valid pieces the player can move
     *      - enable cells containing the possible destinations for the currently selected piece
     *
     * If the game is over:
     *      - update view.messageLabel with the winner ('MUSKETEER' or 'GUARD')
     *      - disable all cells
     */
    protected void updateCells() { // TODO
        List<Cell> listOfAllCells = board.getAllCells(); // declare a variable called listOfAllCells to get access to the all the cells on the board by taking advantage to getAllCells method in the board class
        if(view.model.isHumanTurn()==false){ // use the model in the view class to check if the turn is a not a human turn, i.e is a computer enter, enter the if block
            for(int i=0; i<listOfAllCells.size(); i++){ //  for loop that starts indexing at 0 and iterates through the entire listOfAllCells, increments by 1 so all cells are considered
                Cell currentCell = listOfAllCells.get(i); // get the currentCell at the current index and assign it to currentCell
                currentCell.setDisable(true); // disable the current cell at given index
            }
            if(view.undoButton!=null){ // if the undo button in the view class is not null
                view.undoButton.setDisable(true); // disable the undo Button
            }
            if(view.restartButton!=null){ // if the restart button in the view class is not null
                view.restartButton.setDisable(true); // disable the restart button
            }
            if(view.saveButton!=null){ // if the save button in the view class is not null
                view.saveButton.setDisable(true); // disable the save button
            }
            if(this.board.isGameOver()==false){ // if the isGameOver in the board class is false
                view.runMove(); // call runMove in the view class
            }
        }
        if(view.model.isHumanTurn()==true && isCurrentlyPicking==true){ // use the model in the view class to check if it is a human turn, and check if it is a users turn to move. If yes to both enter the if block
            for(int i=0; i<listOfAllCells.size(); i++){ //for loop that starts indexing at 0 and iterates through the entire listOfAllCells, increments by 1 so all cells are considered
                Cell currentCell = listOfAllCells.get(i); // get the current cell at the current index and assign it to currentCell
                currentCell.setDisable(true); // disable the current cell at given index
            }
            List<Cell> listOfPossibleFromCells = board.getPossibleCells(); // declare a variable called listOfPossibleFromCells to get access to all possible cells on the board where pieces can be moved by taking advantage of board.getPossiblrCells
            for(int i=0; i<listOfPossibleFromCells.size(); i++){ // for loop that starts indexing at 0 until the the length of the listOfPossibleFromCells, incrementing by 1 so all cells are considered
                Cell currentPossbileFromCell = listOfPossibleFromCells.get(i); // get the currentPossibleFrom cell at the current index and assign it to currentPossibleFromCell
                if(listOfPossibleFromCells.contains(currentPossbileFromCell)){ // check if the currentPossibleFromCell is in the listOfPossibleFromCells and if it is, enter the if block
                    currentPossbileFromCell.setDisable(false); // disable the currentPossibleFromCell, allowing the user to pick that piece
                }
            }
            if(view.undoButton!=null){ // if the undo button in the view class is not null
                view.undoButton.setDisable(false); // disable the undo Button
            }
            if(view.restartButton!=null){ // if the restart button in the view class is not null
                view.restartButton.setDisable(false);  // call runMove in the view class
            }
            if(view.saveButton!=null){ // if the save button in the view class is not null
                view.saveButton.setDisable(false); // // disable the save button
            }
        }
        if(view.model.isHumanTurn() && isCurrentlyPicking==false){ // use the model in the view class to check if it is a humans turn and if they are currently picking. If yes to both, enter the if block
            for(int i=0; i<listOfAllCells.size(); i++){ //for loop that starts indexing at 0 and iterates through the entire listOfAllCells, increments by 1 so all cells are considered
                Cell cell = listOfAllCells.get(i); // get the current cell at the current index and assign it to cell
                cell.setDisable(true); // disable the current cell at given index
            }
            List<Cell> listOfPossibleFromCells = board.getPossibleCells(); // declare a variable called listOfPossibleFromCells to get access to all possible cells on the board where pieces can be moved by taking advantage of board.getPossiblrCells
            for(int i = 0; i< listOfPossibleFromCells.size(); i++){ // for loop that starts indexing at 0 until the the length of the listOfPossibleFromCells, incrementing by 1 so all cells are considered
                Cell currentPossbileFromCell = listOfPossibleFromCells.get(i); // get the currentPossibleFrom cell at the current index and assign it to currentPossibleFromCell
                if(listOfPossibleFromCells.contains(currentPossbileFromCell)){ // check if the currentPossibleFromCell is in the listOfPossibleFromCells and if it is, enter the if block
                    currentPossbileFromCell.setDisable(false);// disable the currentPossibleFromCell, allowing the user to pick that piece
                }
            }
            List<Cell> listOfPossibleToCells = board.getPossibleDestinations(this.toCell); // declare a variable called listOfPossibleCells which holds all possibleDestinations, taking advantage of listOfPossibleCells and passing in this.toCell as the argument
            for(int i=0; i<listOfPossibleToCells.size(); i++){ // for loop that starts indexing at 0 until the length of possibleToCells, incrementing by 1, so all cells are considered
                Cell currentPossibleToCell = listOfPossibleToCells.get(i); // declare a variable called currentPossibleToCell the holds the current possible to Cell at the given index
                if(listOfPossibleToCells.contains(currentPossibleToCell)){ // check if the listOfPossibleToCells, is holding the currentPossibleToCell, if it does, enter the if block
                    currentPossibleToCell.setDisable(false); // disable the currentPossibleToCell, allowing the user move on to a valid empty cell
                }
            }
            if(view.undoButton!=null){ // if the undo button in the view class is not null
                view.undoButton.setDisable(false); // disable the undo Button
            }
            if(view.restartButton!=null){ // if the restart button in the view class is not null
                view.restartButton.setDisable(false); // call runMove in the view class
            }
            if(view.saveButton!=null){  // if the save button in the view class is not null
                view.saveButton.setDisable(false); //disable the save button
            }
        }
        if(board.isGameOver()==true){
            view.messageLabel.setText(String.format("%s has won", board.getWinner().getType()));
            for(int i=0; i<listOfAllCells.size(); i++){ //  for loop that starts indexing at 0 and iterates through the entire listOfAllCells, increments by 1 so all cells are considered
                Cell currentCell = listOfAllCells.get(i); // get the currentCell at the current index and assign it to currentCell
                currentCell.setDisable(true); // disable the current cell at given index
            }
            if(view.undoButton!=null){ // if the undo button in the view class is not null
                view.undoButton.setDisable(false); // disable the undo Button
            }
            if(view.restartButton!=null){ // if the restart button in the view class is not null
                view.restartButton.setDisable(false);  // call runMove in the view class
            }
            if(view.saveButton!=null){ // if the save button in the view class is not null
                view.saveButton.setDisable(false); //disable the save button
            }
        }
    }

    /**
     * Handles Cell clicks and updates the board accordingly
     * When a Cell gets clicked the following must be handled:
     *  - If it's a valid piece that the player can move, select the piece and update the board
     *  - If it's a destination for a selected piece to move, perform the move and update the board
     * @param actionEvent
     */
    public void handle(ActionEvent actionEvent){ // TODO
        Cell chosenCell = (Cell) actionEvent.getSource(); // declare a variable called chosenCell, so if the a cell on the board is clicked, it is saved in memory
        List<Cell> listOfPossibleCells = board.getPossibleCells(); // declare a variable called listOfPossibleCells which holds a list of pieces that can be moved
        if (isCurrentlyPicking==true){ // if the user is currently picking enter the if block, which handles moving to another cell enter the if block
            if (listOfPossibleCells.contains(chosenCell)) { // if the listOfPossibleCells is holding the chosenCell enter the if block
                this.isCurrentlyPicking = false; // set isCurrentlyPicking to false
                this.toCell = chosenCell; // set the toCell Variable to the chosenCell
                updateCells(); // update the Cell states using updateCells
            }
        }
        if(isCurrentlyPicking==false){ // if the user is currently not picking, which represents the system telling the player to move, enter the if block
            List<Cell> listOfDestinationCells = board.getPossibleDestinations(toCell); // declare a variable called listOfDestinationCells which hold the list of Possible destinations that the pieces can go onto
            if (listOfDestinationCells.contains(chosenCell)) { // if the listOfDestinationCells is holding the chosenCell enter the if block
                view.model.move(new Move(toCell, chosenCell)); // perform a move by calling model in the view call's move method and passing in move with toCell and chosen Cell as argument
                view.setMessageLabel(String.format("%s's to turn to select a piece", board.getTurn().getType())); // updates the message label
                this.toCell = null; // set the toCell to null
                this.isCurrentlyPicking = true; // set isCurrentlyPicking to true
                updateCells(); // update the cell states using updateCells method
            }
        }
    }
}