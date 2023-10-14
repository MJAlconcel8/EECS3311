package assignment1.testing;
import java.util.List;
import org.junit.*;
import assignment1.*;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }

    // Tests for getting cells from the board
    @Test
    public void testGetCell() {
        Cell cell = board.getCell(new Coordinate(1, 4));
        Assert.assertNotNull(cell.getPiece());
    }

    // Tests for piece counts in various board states
    @Test
    public void testPieceCounts() {
        Assert.assertEquals(3, board.getMusketeerCells().size());
        Assert.assertEquals(22, board.getGuardCells().size());
    }

    @Test
    public void testPieceCountGameOver() {
        this.board = new Board("Boards/GameOver.txt");
        Assert.assertEquals(3, board.getMusketeerCells().size());
        Assert.assertEquals(4, board.getGuardCells().size());
    }

    @Test
    public void testPieceCountNearEnd() {
        this.board = new Board("Boards/NearEnd.txt");
        Assert.assertEquals(3, board.getMusketeerCells().size());
        Assert.assertEquals(5, board.getGuardCells().size());
    }

    // Tests for moving pieces
    @Test
    public void testMovePiece() {
        Cell cell = board.getCell(new Coordinate(1, 4));
        Assert.assertNotNull(cell.getPiece());

        Coordinate from = new Coordinate(1, 4);
        Coordinate to = new Coordinate(2, 4);

        Cell fromCell = board.getCell(from);
        Cell toCell = board.getCell(to);

        Move move = new Move(fromCell, toCell);
        board.move(move);

        Assert.assertNotNull(cell.getPiece());
        Assert.assertNotNull(board.getCell(new Coordinate(2, 4)).getPiece());
    }

    @Test(expected = Exception.class)
    public void testMovePieceToOwnCell() {
        this.board = new Board();
        Coordinate from = new Coordinate(1, 1);
        Coordinate to = new Coordinate(1, 5);
        Move move = new Move(board.getCell(from), board.getCell(to));
        board.move(move);
    }

    @Test
    public void testPossibleMoves() {
        this.board = new Board();
        List<Move> moves = board.getPossibleMoves();
        Assert.assertFalse(moves.isEmpty());
    }
}