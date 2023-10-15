package assignment1;

public class Guard extends Piece {

    public Guard() {
        super("O", Type.GUARD);
    }

    /**
     * Returns true if the Guard can move onto the given cell.
     * @param cell Cell to check if the Guard can move onto
     * @return True, if Guard can move onto given cell, false otherwise
     */
    @Override
    public boolean canMoveOnto(Cell cell) { // TODO
        if(!cell.hasPiece()){ //check if there is not a piece on the cell the guard wants to go to
            return true; // if it doesn't return true
        }
        else{
            return false; // if none of the conditions are met return false
        }
    }
}
