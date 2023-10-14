package assignment1.testing;

import assignment1.*;
import assignment1.Exceptions.InvalidMoveException;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StarterBoardTest {

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
    public void testGetGuardCells3() {
        List<Cell> guards = board.getGuardCells();
        int numGuards = guards.size();
        int expectedGuards = 22;
        assertEquals(expectedGuards, numGuards);
    }

    //Check there are 3 Musketeers to start with
    @Test
    public void testGetMusketeerCells() {
        List<Cell> guards = board.getMusketeerCells();
        int numMuske = guards.size();
        int expectedMuske = 3;
        assertEquals(expectedMuske, numMuske);
    }
    @Test
    public void testGetDestinations() {
        String tryCorString = "C3";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 4;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations2() {
        String tryCorString = "A5";
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
    public void testGetDestinations3() {
        String tryCorString = "E1";
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
    public void testGetDestinations5() {
        Board board = new Board();
        String tryCorString = "A1";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 0;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations6() {
        String tryCorString = "B2";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 0;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations7() {
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
        int Expectednum = 0;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations8() {
        Board board = new Board();
        String tryCorString = "D5";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 0;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetDestinations9() {
        String tryCorString = "C5";
        Cell fromCell = null;
        try {
            fromCell = board.getCell(Utils.parseUserMove(tryCorString.toUpperCase()));
        } catch (InvalidMoveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int numDestinations = board.getPossibleDestinations(fromCell).size();
        int Expectednum = 0;
        assertEquals(Expectednum, numDestinations);
    }
    @Test
    public void testGetPossibleCells() {
        List<Cell> listOfCells = board.getPossibleCells();
        int numberOfCells = listOfCells.size();
        int expectedMuske = 3;
        assertEquals(expectedMuske, numberOfCells);
    }

    @Test
    public void testPossibleMoves() {
        List<Move> listOfCells = board.getPossibleMoves();
        int numberOfCells = listOfCells.size();
        int expectedMoves = 8;
        assertEquals(expectedMoves, numberOfCells);
    }

    @Test
    public void testGetCellAtStarter() {
        for (int i = 0 ; i < 5 ; i++){
            for ( int j = 0; j < 5 ; j ++){
                Cell cell = board.getCell(new Coordinate(i, j));
                Assert.assertNotNull(cell);
                if (i + j == 4 && i % 2 == 0){
                    assertEquals(Piece.Type.MUSKETEER, cell.getPiece().getType());
                }
                else{
                    assertEquals(Piece.Type.GUARD, cell.getPiece().getType());
                }
            }
        }
    }

    @Test
    public void testGetMusketeerCellsAtStarter() {
        // Test if getMusketeerCells returns all musketeer cells on the board
        List<Cell> cells = (board.getMusketeerCells());
        assertEquals(3,cells.size());
        for (Cell cell : cells) {
            assertEquals(Piece.Type.MUSKETEER, cell.getPiece().getType());
        }
    }

    @Test
    public void testGetGuardCells() {
        // Test if getGuardCells returns all guard cells on the board
        List<Cell> cells = (board.getGuardCells());
        assertEquals(22,cells.size());
        for (Cell cell : cells) {
            assertEquals(Piece.Type.GUARD, cell.getPiece().getType());
        }
    }
    @Test
    public void testMoveValidMusketeerMove() {
        // Test if a valid musketeer move is executed correctly
        Cell fromCoordinate = board.getCell(new Coordinate(0, 4)); // Example starting coordinate
        Cell toCoordinate = board.getCell(new Coordinate(1, 4));  // Example destination coordinate
        Move move = new Move(fromCoordinate, toCoordinate);
        board.move(move);
        assertNull(board.getCell(new Coordinate(0, 4)).getPiece()); // Check that the fromCell is now empty
        assertEquals(Piece.Type.MUSKETEER, board.getCell(new Coordinate(1, 4)).getPiece().getType()); // Check that the toCell has a musketeer
        assertEquals(21, board.getGuardCells().size());
        assertEquals(3, board.getMusketeerCells().size());
    }

    @Test
    public void testMoveValidGuardMove() {
        // Test if a valid guard move is executed correctly
        Cell fromCoordinate = board.getCell(new Coordinate(0, 4)); // Example starting coordinate
        Cell toCoordinate = board.getCell(new Coordinate(1, 4));  // Example destination coordinate
        Move move = new Move(fromCoordinate, toCoordinate);
        board.move(move);
        assertNull(board.getCell(new Coordinate(0, 4)).getPiece()); // Check that the fromCell is now empty
        fromCoordinate = board.getCell(new Coordinate(0, 3)); // Example starting coordinate
        toCoordinate = board.getCell(new Coordinate(0, 4));  // Example destination coordinate
        move = new Move(fromCoordinate, toCoordinate);
        board.move(move);
        assertNull(board.getCell(new Coordinate(0, 3)).getPiece()); // Check that the fromCell is now empty
        assertEquals(Piece.Type.MUSKETEER, board.getCell(new Coordinate(1, 4)).getPiece().getType()); // Check that the toCell has a musketeer
        assertEquals(Piece.Type.GUARD, board.getCell(new Coordinate(0, 4)).getPiece().getType());
        assertEquals(21, board.getGuardCells().size());
        assertEquals(3, board.getMusketeerCells().size());
    }

    @Test
    public void testGetPossibleCellsAtStart() {

        List<Cell> possibleCells = board.getPossibleCells();
        assertEquals(3, possibleCells.size());
        assertTrue(possibleCells.containsAll(board.getMusketeerCells()));
    }


}
