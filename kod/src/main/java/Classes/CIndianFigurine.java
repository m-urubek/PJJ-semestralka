package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;

public class CIndianFigurine extends CFigurine {

    public CIndianFigurine (CField field) {
        //TODO
    }

    @Override
    public CIndianFigurine getIndianFigurine() {
        //DONE
        return this;
    };

    @Override
    public CSettlerFigurine getSettlerFigurine() {
        //DONE
        return null;
    }

    @Override
    public void move (CField field) {
        //Check side of player
        if (CGame.m_currentPlayerTurn != TCurrentPlayerTurn.Indian)
            return;
        //Indian's move

        //Checks if figurine is indian
        if (this.getIndianFigurine() == null)
            return;
        //Checks if move is legal
        if (!isLegalMove(field))
            return;

        //Moves the figurine
        TPoint oldField = new TPoint(this.m_field.getM_x(), this.m_field.getM_y());
        field.setM_figurine(this);
        CGame.m_gameLayout.GetAt(oldField).setM_figurine(null);

        //Changes game state
        CGame.m_playerState = TState.Moved;
    }

    @Override
    public boolean isLegalMove (CField field) {
        //DONE - TODO Review!
        //Check if out of bounds
        if (    field.getM_x() < 0 ||
                field.getM_x() >= CGeneralHelper.BOARD_WIDTH ||
                field.getM_y() < 0 ||
                field.getM_y() >=CGeneralHelper.BOARD_WIDTH)
            return false;
        //Check if out of bounds
        //TODO - Those numbers (2 and 4) should be CONSTANTS but I don't care right now
        if (    (field.getM_x() < 2 && field.getM_y() < 2) ||
                (field.getM_x() < 2 && field.getM_y() > 4) ||
                (field.getM_x() > 4 && field.getM_y() < 2) ||
                (field.getM_x() > 4 && field.getM_y() > 4))
            return false;
        //Check if move too far away
        if (Math.abs(field.getM_x() - this.m_field.getM_x()) > 1 || Math.abs(field.getM_y() - this.m_field.getM_y()) > 1 )
            return false;
        //Check if move backwards
        if (field.getM_x() < this.m_field.getM_x())
            return false;
        //Check if move diagonally
        if (field.getM_x() != this.m_field.getM_x() && field.getM_y() != this.m_field.getM_y())
            return false;
        //Check if target coordination is occupied
        return field.getM_figurine() == null;
    }
}
