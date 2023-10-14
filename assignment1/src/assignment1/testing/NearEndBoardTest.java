package assignment1.testing;


import assignment1.*;
import assignment1.Exceptions.InvalidMoveException;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class NearEndBoardTest {
    private Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }

    @Test
    public void testGetCell() {
        Cell cell = board.getCell(new Coordinate(4,1 ));
        Assert.assertNotNull(cell.getPiece());
    }
    @Test
    public void testGetGuardCells() {
        Board board = new Board();
        List<Cell> guards = board.getGuardCells();
        int numGuards = guards.size();
        int expectedGuards = 5;
        assertEquals(expectedGuards, numGuards);
    }

    //Check there are 3 Musketeers to start with
    @Test
    public void testGetMusketeerCells() {
        Board board = new Board();
        List<Cell> guards = board.getMusketeerCells();
        int numMuske = guards.size();
        int expectedMuske = 3;
        assertEquals(expectedMuske, numMuske);
    }
    @Test
    public void testGetDestinations() {
        Board board = new Board();
        String tryCorString = "C4";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 2;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations2() {
        Board board = new Board();
        String tryCorString = "A4";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 2;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations3(){
        Board board = new Board();
        String tryCorString = "C5";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 2;
        assertEquals(Expectednum, numDestinations);
    }

    @Test
    public void testIsValidMove_ValidMove() throws InvalidMoveException {
        // Create a valid move scenario
        String fromCoordinate = "C3";
        String toCoordinate = "C4";

        // Parse the coordinates and create a move
        Move move = new Move(board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())),
                board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())));

        // Assuming that A1 and A2 are valid positions for this test
        // Set up the pieces accordingly for this test case

        // Now, check if the move is valid
        assertFalse(board.isValidMove(move));
    }
    @Test
    public void testIsValidMove_ValidMove2() throws InvalidMoveException {
        // Create a valid move scenario
        String fromCoordinate = "C3";
        String toCoordinate = "C4";

        // Parse the coordinates and create a move
        Move move = new Move(board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())),
                board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())));

        // Assuming that A1 and A2 are valid positions for this test
        // Set up the pieces accordingly for this test case

        // Now, check if the move is valid
        assertFalse(board.isValidMove(move));
    }
    @Test
    public void testMove_PieceEndsUpOnC3_AndSwitchesTurn1() throws InvalidMoveException {
        // Assuming that A1 and A2 are valid positions for this test
        // Set up the initial game state on the board
        // For example:
        // Place a Musketeer at C4 and a Guard at C3
        // Set the current turn to Musketeer

        // Create a valid move scenario
        String fromCoordinate = "C4";
        String toCoordinate = "C3";

        // Parse the coordinates and create a move
        Move move = new Move(board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())),
                board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())));

        // Now, check if the move is valid
        assertTrue(board.isValidMove(move));

        // Get the initial turn before the move
        Piece.Type initialTurn = board.getTurn();

        // Perform the move
        board.move(move);

        // Get the turn after the move
        Piece.Type newTurn = board.getTurn();

        // Assert that the turn has switched correctly
        assertNotEquals(initialTurn, newTurn);

        // Assert the final state of the board to ensure it matches expectations
        // Check that the piece is now at C3, and C4 is empty
        // You should have a method to retrieve the piece on a specific cell
        // and verify its type and position.
    }
    @Test
    public void testUndoMove_PieceIsMovedBackAndTurnIsReversed() throws InvalidMoveException {
        // ... (Setup initial game state)

        // Create a valid move scenario
        String fromCoordinate = "C4";
        String toCoordinate = "C3";

        // Parse the coordinates and create a move
        Move move = new Move(board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())),
                board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())));

        // Now, check if the move is valid
        assertTrue(board.isValidMove(move));

        // Get the initial state before the move
        Piece.Type initialTurn = board.getTurn();
        Piece initialPieceAtC3 = board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())).getPiece();
        Piece initialPieceAtD3 = board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())).getPiece();

        // Perform the move
        board.move(move);

        // Get the turn after the move
        Piece.Type newTurn = board.getTurn();

        // Assert that the turn has switched correctly
        assertNotEquals(initialTurn, newTurn);

        // Undo the move
        board.undoMove(move);

        // Verify that the pieces are in their original positions after undoing the move
        Piece pieceAfterUndoAtC3 = board.getCell(Utils.parseUserMove(fromCoordinate.toUpperCase())).getPiece();
        Piece pieceAfterUndoAtD3 = board.getCell(Utils.parseUserMove(toCoordinate.toUpperCase())).getPiece();

        assertEquals(initialTurn, board.getTurn()); // Turn should be back to the initial state
        assertEquals(initialPieceAtC3, pieceAfterUndoAtC3); // Piece at C3 should be the same
        assertEquals(initialPieceAtD3, pieceAfterUndoAtD3); // Piece at D3 should be the same
    }

    @Test
    public void testGetPossibleCells() {
        List<Cell> listOfCells = board.getPossibleCells();
        int numberOfCells = listOfCells.size();
        int expectedGuards = 3;
        assertEquals(expectedGuards, numberOfCells);
    }
    @Test
    public void testPossibleMoves() {
        List<Move> listOfCells = board.getPossibleMoves();
        int numberOfCells = listOfCells.size();
        int expectedMoves = 6;
        assertEquals(expectedMoves, numberOfCells);
    }

}

