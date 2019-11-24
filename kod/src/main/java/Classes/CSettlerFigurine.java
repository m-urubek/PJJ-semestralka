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
    public CIndianFigurine getIndianFigurine() {
        //DONE
        return null;
    };

    @Override
    public CSettlerFigurine getSettlerFigurine() {
        //DONE
        return this;
    }

    @Override
    public boolean isLegalMove (CField field) {
        //In Progress - polymorphism
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
        if ( (this.getM_position().x % 2) == (this.getM_position().y % 2) ) {
            //Can move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.getM_position().x) > 1 || Math.abs(field.getM_y() - this.getM_position().y) > 1) {
                //Moving too far away may indicate killing enemy figure

                //Checking if moving right
                if (field.getM_x() > this.getM_position().x)
                    return false;
                //Check if not moving 2 horizontal and 2 vertical
                if (Math.abs(field.getM_x() - this.getM_position().x) != 2 || Math.abs(field.getM_y() - this.getM_position().y) != 2)
                    return false;
                //Check if the field in between the positions contains indian figure
            }
            //Check if target field is occupied
            return field.getM_figurine() == null;
        } else {
            //Can not move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.getM_position().x) > 1 || Math.abs(field.getM_y() - this.getM_position().y) > 1)
                return false;
            //Check if moving diagonally
            if (field.getM_x() != this.getM_position().x && field.getM_y() != this.getM_position().y)
                return false;
            //Check if target field is occupied
            return field.getM_figurine() == null;
        }

    }

}
