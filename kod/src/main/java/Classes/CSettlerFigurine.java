package Classes;
import DataTypes.TPoint;

public class CSettlerFigurine extends CFigurine {
    public CSettlerFigurine() {
        //TODO
    }

    public void KillIndian(TPoint coordinates) {
        //TODO
    }

    public void KillIndian(CIndianFigurine indian) {
        //TODO
    }

    public void KillIndian(CField indian) {
        //TODO
    }

    @Override
    public boolean isLegalMove (CField field) {
        //TODO - polymorphism
        //Check if out of bounds
        if (    field.getM_x() < 0 ||
                field.getM_x() >= CGame.BOARD_WIDTH ||
                field.getM_y() < 0 ||
                field.getM_y() >=CGame.BOARD_WIDTH)
            return false;
        //Check if out of bounds
        //TODO - Those numbers (2 and 4) should be CONSTANTS but I don't care right now
        if (    (field.getM_x() < 2 && field.getM_y() < 2) ||
                (field.getM_x() < 2 && field.getM_y() > 4) ||
                (field.getM_x() > 4 && field.getM_y() < 2) ||
                (field.getM_x() > 4 && field.getM_y() > 4))
            return false;

        //Check if diagonal move is possible
        boolean canMoveDiagonally = (this.getM_position().x % 2) == (this.getM_position().y % 2);

        //Check if moving too far away
        if (canMoveDiagonally) {

        } else {
            if (Math.abs(field.getM_x() - this.getM_position().x) > 1 || Math.abs(field.getM_y() - this.getM_position().y) > 1)
                return false;
        }


        return true;
    }

}
