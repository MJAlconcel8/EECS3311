package assignment1.testing;

import assignment1.Board;
import assignment1.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EndGameBoardTest {
    private Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }

    @Test
    public void testGetPossibleCells() {
        List<Cell> listOfCells = board.getPossibleCells();
        int numberOfCells = listOfCells.size();
        int expectedGuards = 3;
        assertEquals(expectedGuards, numberOfCells);
    }
}
