package assignment1.testing;

import assignment1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EndTest {
    private Board board;

    @Before
    public void setup() {
        this.board = new Board();
    }

    @Test
    public void testingGreedyAgent(){
        GreedyAgent muske = new GreedyAgent(board);
        Move move = muske.getMove();
        board.move(move);
        assertEquals(true, board.isGameOver());
        assertEquals(board.getWinner(), Piece.Type.MUSKETEER);
    }

}

