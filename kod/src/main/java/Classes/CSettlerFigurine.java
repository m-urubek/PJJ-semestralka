package Classes;
import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;

public class CSettlerFigurine extends CFigurine {

    public CSettlerFigurine (CField field) {
        m_field = field;
    }


    private boolean lookForKill(CField field) throws Exception{
        //DONE
        if ((this.m_field.getM_x() - field.getM_x() == 2) && (this.m_field.getM_y() - field.getM_y() == 2)) {
            int x = this.m_field.getM_x();
            int y = this.m_field.getM_y();
            if (field.getM_x() > x) {
                x++;
            } else {
                x--;
            }
            if (field.getM_y() > y) {
                y++;
            } else {
                y--;
            }
            KillIndian(new TPoint(x,y));
            return true;
        }
        return false;
    }

    public void KillIndian(TPoint coords) throws Exception{
        //DONE
        CGame.GameLayout.GetAt(coords).setM_figurine(null);
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
    public void move (CField field) throws Exception{
        //Check side of player
        if (CGame.CurrentPlayerTurn != TCurrentPlayerTurn.Settler)
            return;
        //Settler's move

        //Checks if figurine is settler
        if (this.getSettlerFigurine() == null)
            return;
        //Checks if move is legal
        if (!isLegalMove(field))
            return;

        //Check if indian should be killed and kill him
        boolean killed = lookForKill(field);

        //Get coords of next possible kill
        int x = this.m_field.getM_x();
        int y = this.m_field.getM_y();
        if (field.getM_x() > x) {
            x+=4;
        } else {
            x-=4;
        }

        //Move the figurine
        TPoint oldField = new TPoint(this.m_field.getM_x(), this.m_field.getM_y());
        field.setM_figurine(this);
        CGame.GameLayout.GetAt(oldField).setM_figurine(null);
        //Change game state
        if (killed) {
            if (isLegalMove(CGame.GameLayout.GetAt(new TPoint(x,y)))) {
                CGame.PlayerState = TState.CanOnlyKill;
            } else {
                CGame.PlayerState = TState.Moved;
            }
        } else {
            CGame.PlayerState = TState.Moved;
        }
    }

    @Override
    public boolean isLegalMove (CField field) throws Exception{
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

        //Check if diagonal move is possible
        if ( (this.m_field.getM_x() % 2) == (this.m_field.getM_y() % 2) ) {
            //Can move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.m_field.getM_x()) > 1 || Math.abs(field.getM_y() - this.m_field.getM_y()) > 1) {
                //Moving too far away may indicate killing enemy figure

                //Check if not moving 2 horizontal and 2 vertical
                if (Math.abs(field.getM_x() - this.m_field.getM_x()) != 2 || Math.abs(field.getM_y() - this.m_field.getM_y()) != 2)
                    return false;
                //Check if the field between the positions contains indian figure
                int x = this.m_field.getM_x();
                int y = this.m_field.getM_y();
                if (field.getM_x() > x) {
                    x++;
                } else {
                    x--;
                }
                if (field.getM_y() > y) {
                    y++;
                } else {
                    y--;
                }
                if (CGame.GameLayout.GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine()==null)
                    return false;
            }
            //Check if target field is occupied
            return field.getM_figurine() == null;
        } else {
            //Can not move diagonally

            //Check if moving too far away
            if (Math.abs(field.getM_x() - this.m_field.getM_x()) > 1 || Math.abs(field.getM_y() - this.m_field.getM_y()) > 1)
                return false;
            //Check if moving diagonally
            if (field.getM_x() != this.m_field.getM_x() && field.getM_y() != this.m_field.getM_y())
                return false;
            //Check if target field is occupied
            return field.getM_figurine() == null;
        }

    }

}
