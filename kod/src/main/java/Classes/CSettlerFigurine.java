package Classes;
import DataTypes.TPoint;

public class CSettlerFigurine extends CFigurine {
    public CSettlerFigurine() {
        super();
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
        //DONE - TODO Review!
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
        if ( (this.getM_field().getM_x() % 2) == (this.getM_field().getM_y() % 2) ) {
            //Can move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.getM_field().getM_x()) > 1 || Math.abs(field.getM_y() - this.getM_field().getM_y()) > 1) {
                //Moving too far away may indicate killing enemy figure

                //Checking if moving right
                if (field.getM_x() > this.getM_field().getM_x())
                    return false;
                //Check if not moving 2 horizontal and 2 vertical
                if (Math.abs(field.getM_x() - this.getM_field().getM_x()) != 2 || Math.abs(field.getM_y() - this.getM_field().getM_y()) != 2)
                    return false;
                //Check if the field between the positions contains indian figure
                int x = this.getM_field().getM_x() - 1;
                int y = this.getM_field().getM_y();
                if (field.getM_y() > y) {
                    y++;
                } else {
                    y--;
                }
                if (CGame.getM_gameLayout().GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine()==null)
                    return false;
            }
            //Check if target field is occupied
            return field.getM_figurine() == null;
        } else {
            //Can not move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.getM_field().getM_x()) > 1 || Math.abs(field.getM_y() - this.getM_field().getM_y()) > 1)
                return false;
            //Check if moving diagonally
            if (field.getM_x() != this.getM_field().getM_x() && field.getM_y() != this.getM_field().getM_y())
                return false;
            //Check if target field is occupied
            return field.getM_figurine() == null;
        }

    }

}
