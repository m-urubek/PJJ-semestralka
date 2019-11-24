package Classes;

import DataTypes.TPoint;

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
