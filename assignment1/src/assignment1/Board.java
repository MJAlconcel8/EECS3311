package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;

public class Board {
    public int size = 5;

    // 2D Array of Cells for representation of the game board
    public final Cell[][] board = new Cell[size][size];

    private Piece.Type turn;
    private Piece.Type winner;
    private Piece currentlyPointingFromCell; // declare an instance variable called currentlyPointingPiece, which will be used in case we have to restore the board to it's original state in undo method
    /**
     * Create a Board with the current player turn set.
     */
    public Board() {
        this.loadBoard("Boards/Starter.txt");
    }

    /**
     * Create a Board with the current player turn set and a specified board.
     * @param boardFilePath The path to the board file to import (e.g. "Boards/Starter.txt")
     */
    public Board(String boardFilePath) {
        this.loadBoard(boardFilePath);
    }

    /**
     * Creates a Board copy of the given board.
     * @param board Board to copy
     */
    public Board(Board board) {
        this.size = board.size;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.board[row][col] = new Cell(board.board[row][col]);
            }
        }
        this.turn = board.turn;
        this.winner = board.winner;
    }

    /**
     * @return the Piece.Type (Muskeeteer or Guard) of the current turn
     */
    public Piece.Type getTurn() {
        return turn;
    }

    /**
     * Get the cell located on the board at the given coordinate.
     * @param coordinate Coordinate to find the cell
     * @return Cell that is located at the given coordinate
     */
    public Cell getCell(Coordinate coordinate) { // TODO
        return this.board[coordinate.row][coordinate.col]; // this return statement returns the coordinates of the row and col
    }

    /**
     * @return the game winner Piece.Type (Muskeeteer or Guard) if there is one otherwise null
     */
    public Piece.Type getWinner() {
        return winner;
    }

    /**
     * Gets all the Musketeer cells on the board.
     * @return List of cells
     */
    public List<Cell> getMusketeerCells() { // TODO
        List<Cell> listOfMusketeerCells = new ArrayList<>(); // declare a new arraylist called listOfGuardCells, that holds the list of cells containing guards
        for (Cell[] row : this.board) { // allow for iterations throughout the row cells gives access to the first row on the board;
            for (Cell cell : row) {  // allows for iterations throughout the col cells, allowing for entire traversal of the board
                if (cell.toString().equals("X")) { // checks if the agent is an X, that indicates it is an agent
                    listOfMusketeerCells.add(cell); // add the agents cell to the list if it is a Musketeer
                }
            }
        }
        return listOfMusketeerCells; // return the list of cells that contained Musketeers
    }

    /**
     * Gets all the Guard cells on the board.
     * @return List of cells
     */
    public List<Cell> getGuardCells() { // TODO
        List<Cell> listOfGuardCells = new ArrayList<>(); // declare a new arraylist called listOfGuardCells, that holds the list of cells containing guards
        for (Cell[] row : this.board) { // allow for iterations throughout the row cells gives access to the first row on the board;
            for (Cell cell : row) { // allows for iterations throughout the col cells, allowing for entire traversal of the board
                if (cell.toString().equals("O")) { // checks if the agent is an O, that indicates it is an agent
                    listOfGuardCells.add(cell); // add the agents cell to the list if it is a guard
                }
            }
        }
        return listOfGuardCells; // return the list of cells that contained guards
    }

    /**
     * Executes the given move on the board and changes turns at the end of the method.
     * @param move a valid move
     */
    public void move(Move move) { // TODO
        if(isValidMove(move)==false){ // checks if the move is valid using the is Valid method
            return; // if it is not valid, simply return
        }
        Cell toCell = getCell(move.toCell.getCoordinate()); // assigns a Cell variable called toCell, to hold the coordinates the cell the piece would like to go on
        Cell fromCell = getCell(move.fromCell.getCoordinate()); // assigns a Cell variable called fromCell, to hold the coordinates of the cell piece is currently on
        currentlyPointingFromCell = toCell.getPiece(); // saves the object that was previously on the cell, whether it was null, musketeer, or guard
        toCell.setPiece(fromCell.getPiece()); // assign the piece on the toCell to be the piece on the from cell amd move it to the newCell
        fromCell.removePiece(); // dereference the piece that was on the from cell, as it has moved to the current cell
        if(this.turn== Piece.Type.MUSKETEER){ // checks if the turn was a musketeer turn
            this.turn = Piece.Type.GUARD; // if it was switch the turn to guard
        }
        else if(this.turn==Piece.Type.GUARD){ // checks if the turn was a guard
            this.turn = Piece.Type.MUSKETEER; // if it was switch the turn to musketeer
        }
    }

    /**
     * Undo the move given.
     * @param move Copy of a move that was done and needs to be undone. The move copy has the correct piece info in the
     *             from and to cell fields. Changes turns at the end of the method.
     */
    public void undoMove(Move move) { // TODO
        Coordinate fromCoordinates = move.fromCell.getCoordinate(); // declare a Coordinate called fromCoordinate to hold the coordinates of the cell that has the piece that was just moved
        Coordinate toCoordinates = move.toCell.getCoordinate(); // declare a Coordinate called toCoordinate to hold the coordinate of the cell that the piece was moved is currently on
        Cell toCell = getCell(toCoordinates); // create a Cell called toCell, which will locate the Cell given the coordinates of the toCoordinates variable that are passed in
        Cell fromCell = getCell(fromCoordinates); // create a Cell called fromCell, which will locate the Cell given the coordinates of the fromCoordinates variable that are passed in
        Piece originallyFrom = toCell.getPiece(); // create a reference to a Piece called orginallyFrom that will gain access to the piece that was moved and have access to its data in memory
        fromCell.setPiece(originallyFrom); // move the piece back to it's original cell using fromCell.setPiece
        toCell.setPiece(currentlyPointingFromCell); //recover the data that was deleted by accessing the currentlyPointFromCell instance variable cell and place it back in the cell, and thus recover the state of the board befrore the move
        if(this.turn== Piece.Type.MUSKETEER){ // checks if the turn was a musketeer turn
            this.turn = Piece.Type.GUARD; // if it was switch the turn to guard
        }
        else if(this.turn==Piece.Type.GUARD){ // checks if the turn was a guard
            this.turn = Piece.Type.MUSKETEER; // if it was switch the turn to musketeer
        }
    }

    /**
     * Checks if the given move is valid. Things to check:
     * (1) the toCell is next to the fromCell
     * (2) the fromCell piece can move onto the toCell piece.
     * @param move a move
     * @return     True, if the move is valid, false otherwise
     */
    public Boolean isValidMove(Move move) { // TODO
        Cell fromCell = move.fromCell; // get a reference to the cell you want to move from and name it fromCell
        Cell toCell = move.toCell;  // get a reference to the cell you want to go to and name it toCell
        int distanceOnRowCells = Math.abs(fromCell.getCoordinate().row - toCell.getCoordinate().row); // get the distance between cells in a row by getting the absolute distance of  the coordinates in the fromCell and the toCell
        int distanceOnColumnCells = Math.abs(fromCell.getCoordinate().col - toCell.getCoordinate().col); // get the distance between cells in a row by getting the absolute distance of  the coordinates in the toCell and the fromCell
        if ((distanceOnRowCells == 1 && distanceOnColumnCells == 0) || (distanceOnRowCells == 0 && distanceOnColumnCells == 1)) { // check if the distance between the row cells and column cells are adjacent, i.e if the distance between either the cols = 0 and row = 1 or cols = 1 or rows = 0
            if (fromCell.hasPiece()) {
                // check if the cell has a piece
                if (fromCell.getPiece().getType().toString().equals("MUSKETEER") && toCell.hasPiece() && toCell.getPiece().getType().toString().equals("GUARD")) {
                    return true;
                    // if the fromCell has a piece and it is a musketeer and the cell beside it has a piece and it is a guard, the move is valid, return true
                }

                // Check if the piece in fromCell is a GUARD and the toCell is empty
                else if (fromCell.getPiece().getType().toString().equals("GUARD") && !toCell.hasPiece()) {
                    return true;
                    // if the fromCell has a piece and it is a musketeer and the cell beside it has no piece, the move is valid, return true
                }
            }
        }
        return false; // if none of the above conditions are met, the move is invalid, return false;
    }

    /**
     * Get all the possible cells that have pieces that can be moved this turn.
     * @return      Cells that can be moved from the given cells
     */
    public List<Cell> getPossibleCells() { // TODO
        List<Cell> listOfPossibleCells = new ArrayList<>(); // declare a new arraylist that stores the cells in which potential pieces can be moved
        int[][] lookUps = {{-1, 0}, // Up, decrement row by 1
                {1, 0},  // Down, increment row by 1
                {0, -1}, // Left, decrement column by 1
                {0, 1}   // Right, increment column by 1
        };  // define a lookup coordinate mapping for traversing either up, down, left, or right for the piece
        for(int i=0; i<this.board.length; i++){ // to allow traversal of the first row of the board
            for(int j=0; j<this.board[i].length; j++){ // to allow traversal throughout all columns of the board, esentially having every component of the board traversable
                if(this.getTurn().equals(Piece.Type.MUSKETEER) && board[i][j].toString().equals("X")){ // conditions checks if the current turn is Musketeer, and the cell has an "X". If yes to both, enter the if block
                    for(int[] traversal:lookUps){ // get access to the lookup coordinates
                        int newRow = i + traversal[0]; // able to traverse left and right courtesy of the lookup coordinate
                        int newCol = j + traversal[1]; // able to traverse up and down courtesy of the lookup coordinate
                        if(newRow>=0 && newRow<this.board.length && newCol>=0 && newCol<this.board[0].length && this.board[newRow][newCol].hasPiece() && this.board[newRow][newCol].getPiece().getType().toString().equals("GUARD")){
                            listOfPossibleCells.add(getCell(new Coordinate(i,j)));
                            break;
                            // then break when all done to prevent duplicates
                            // checks if the new row and new column are within the boundaries of the board and the adjacent cells do not contain an "X" if yes to all enter if block
                        }
                    }
                }
                else if(this.getTurn().equals(Piece.Type.GUARD) && board[i][j].toString().equals("O")){ // conditions checks if the current turn is Musketeer, and the cell has an "O". If yes to both, enter the if block
                    for(int[] traversal: lookUps){
                        int newRow = i + traversal[0];  // able to traverse left and right courtesy of the lookup coordinate
                        int newCol = j+traversal[1]; // able to traverse up and down courtesy of the lookup coordinate
                        if(newRow>=0 && newRow<this.board.length && newCol>=0 && newCol<this.board[0].length && !this.board[newRow][newCol].hasPiece()){
                            listOfPossibleCells.add(getCell(new Coordinate(i,j)));
                            break;
                            // checks if the new row and new column are within the boundaries of the board and the adjacent cells do not contain a piece if yes to all enter if block
                            // add the cell as coordinates and then break when all done to prevent duplicates
                        }
                    }
                }
            }
        }
        return listOfPossibleCells; // return the listOfPossibleCells
    }

    /**
     * Get all the possible cell destinations that is possible to move to from the fromCell.
     * @param fromCell The cell that has the piece that is going to be moved
     * @return List of cells that are possible to get to
     */
    public List<Cell> getPossibleDestinations(Cell fromCell) { // TODO
        List<Cell> listOfpossibleDestinations = new ArrayList<>(); //declare a new arraylist to store the possible destinations that can be traversed to
        Coordinate startingCoordinate = fromCell.getCoordinate(); // get the starting coordinate from the cell currently at
        int startingRow = startingCoordinate.row; // get the starting row coordinate, to prevent having to traverse the entire board with a for loop to find a starting point
        int startingColumn = startingCoordinate.col; // get the starting column coordinate, to prevent having to traverse the entire board with a for loop to find a starting point
        int[][] lookUps = {{-1, 0}, // Up, decrement row by 1
                {1, 0},  // Down, increment row by 1
                {0, -1}, // Left, decrement column by 1
                {0, 1}   // Right, increment column by 1
        }; // define a lookup coordinate mapping for traversing either up, down, left, or right for the piece
        for (int[] traversal : lookUps) { // getAccess to the lookup coordinates
            int newRow = startingRow + traversal[0]; // able to traverse the board left and right courtesy of the lookup
            int newCol = startingColumn + traversal[1]; // able to traverse the board up and down courtesy of the lookup

            // Check if the new row and new column are within the board boundaries
            if (newRow >= 0 && newRow < this.board.length && newCol >= 0 && newCol < this.board[newRow].length) {
                Cell toCell = this.board[newRow][newCol]; // haveAccess to an adjacent cells in the rows, either left, right, above, or below it
                if (fromCell.getPiece().getType().getType().toString().equals("MUSKETEER") && toCell.hasPiece() && !toCell.getPiece().getType().toString().equals("MUSKETEER")){
                    listOfpossibleDestinations.add(toCell);
                    // if the current cell has a Musketeer and there is a guard in the adjacent cell, add the adjacent cell as a possible destination
                }
                else if (fromCell.getPiece().getType().getType().toString().equals("GUARD") && !toCell.hasPiece()) {
                    listOfpossibleDestinations.add(toCell);
                    // if the current cell has a Musketeer and there is no piece in the adjacent cell, add the adjacent cell it as a possible destination
                }
            }
        }
        return listOfpossibleDestinations; //return the list with the possible list of destinations
    }

    /**
     * Get all the possible moves that can be made this turn.
     * @return List of moves that can be made this turn
     */
    public List<Move> getPossibleMoves() { // TODO
        List<Move> listOfPossibleMoves = new ArrayList<>(); // delcare an arraylist by create a list to store all possible moves
        List<Cell> listOfPossibleCells = getPossibleCells(); // create a list with the possible cells with pieces that can be moved using the getPossibleCells method
        for (Cell fromCell : listOfPossibleCells) { // iterate through the possible cells list
            List<Cell> listOfPossibleDestinations = getPossibleDestinations(fromCell); // create a list with the possible destinations with pieces that can be moved using the getPossibleDestinations method
            for (Cell toCell : listOfPossibleDestinations) { // iterate through the possible destinations list
                listOfPossibleMoves.add(new Move(fromCell, toCell)); // add all possible moves to the possible moves list
            }
        }

        return listOfPossibleMoves; // return the listOfPossibleMoves
    }

    /**
     * Checks if the game is over and sets the winner if there is one.
     * @return True, if the game is over, false otherwise.
     */
    public boolean isGameOver() { // TODO
        boolean gameOver = false;  // declare a boolean flag to check whether to call the game off, declare the flag as gameOver
        List<Cell> listOfMusketeersWhoCantMove = new ArrayList<>(); //declare an arraylist to hold all musketeers who are unable to move
        Set<Integer> listOfMusketeerRowMovements = new HashSet<>(); // declare a hashset to hold all unique row coordinates for the musketeer
        Set<Integer> listOfMusketeerColumnMovements = new HashSet<>(); // declare a hashset to hold all unique column coordinates for the musketeer
        for (Cell aMusketeerWhoCantMove : getMusketeerCells()) { // use a Cell variable called aMusketeerWhoCantMove, traverse the getMusketeerCells list method, to see all musketeers on the board
            if (getPossibleDestinations(aMusketeerWhoCantMove).isEmpty()) { // if there are no possible destinations where a musketeer can move
                listOfMusketeersWhoCantMove.add(aMusketeerWhoCantMove); // then add that musketeer to the listOfMusketeersWhoCantmove
            }
        }
        for(Cell musketeerMovements: getMusketeerCells()){
            listOfMusketeerRowMovements.add(musketeerMovements.getCoordinate().row);
            listOfMusketeerColumnMovements.add(musketeerMovements.getCoordinate().col);
        }
        if (listOfMusketeersWhoCantMove.size()==3) {  // if all three Musketeers are unable to move
            gameOver = true; // set the boolean flag gameOver equal to true
            this.winner = Piece.Type.MUSKETEER; // set the winner to be equal to musketeer
        }
        else if (getGuardCells().size()==0) {  // check if getGuardCells().size()==0, meaning their are no guards left
            gameOver = true; // set the boolean flag gameOver equal to true
            this.winner = Piece.Type.MUSKETEER; // set the winner to be equal to musketeer
        }
        else if (getGuardCells().size()>0 &&listOfMusketeerRowMovements.size()==1) { // if there are still guards on the board and all musketeers are on the same row
            gameOver = true; // set the boolean flag gameOver equal to true
            this.winner = Piece.Type.GUARD; // set the winner to be equal to guard
        }
        else if (getGuardCells().size()>0 && listOfMusketeerColumnMovements.size()==1) { // if there are still guards on the board and all musketeers are on the same column
            gameOver = true; // set the boolean flag gameOver equal to true
            this.winner = Piece.Type.GUARD; // set the winner to be equal to guard
        }
        return gameOver;
    }

    /**
     * Saves the current board state to the boards directory
     */
    public void saveBoard() {
        String filePath = String.format("boards/%s.txt",
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        File file = new File(filePath);

        try {
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(turn.getType() + "\n");
            for (Cell[] row: board) {
                StringBuilder line = new StringBuilder();
                for (Cell cell: row) {
                    if (cell.getPiece() != null) {
                        line.append(cell.getPiece().getSymbol());
                    } else {
                        line.append("_");
                    }
                    line.append(" ");
                }
                writer.write(line.toString().strip() + "\n");
            }
            writer.close();
            System.out.printf("Saved board to %s.\n", filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Failed to save board to %s.\n", filePath);
        }
    }

    @Override
    public String toString() {
        StringBuilder boardStr = new StringBuilder("  | A B C D E\n");
        boardStr.append("--+----------\n");
        for (int i = 0; i < size; i++) {
            boardStr.append(i + 1).append(" | ");
            for (int j = 0; j < size; j++) {
                Cell cell = board[i][j];
                boardStr.append(cell).append(" ");
            }
            boardStr.append("\n");
        }
        return boardStr.toString();
    }

    /**
     * Loads a board file from a file path.
     * @param filePath The path to the board file to load (e.g. "Boards/Starter.txt")
     */
    private void loadBoard(String filePath) {
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.printf("File at %s not found.", filePath);
            System.exit(1);
        }

        turn = Piece.Type.valueOf(scanner.nextLine().toUpperCase());

        int row = 0, col = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] pieces = line.trim().split(" ");
            for (String piece: pieces) {
                Cell cell = new Cell(new Coordinate(row, col));
                switch (piece) {
                    case "O" -> cell.setPiece(new Guard());
                    case "X" -> cell.setPiece(new Musketeer());
                    default -> cell.setPiece(null);
                }
                this.board[row][col] = cell;
                col += 1;
            }
            col = 0;
            row += 1;
        }
        scanner.close();
        System.out.printf("Loaded board from %s.\n", filePath);
    }
}