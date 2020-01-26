import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;

public class CSettlerFigurine extends CFigurine {

    public CSettlerFigurine (CField field) {
        m_field = field;
    }


    private boolean lookForKill(CField field) throws Exception{
        //DONE

        int x = Math.abs(field.getM_x() - this.m_field.getM_x());
        int y = Math.abs(field.getM_y() - this.m_field.getM_y());
        if ((x!=0 && x!=2) || (y!=0 && y!=2)) {
            return false;
        }
        x = this.m_field.getM_x() + ((field.getM_x() - this.m_field.getM_x())/2);
        y = this.m_field.getM_y() + ((field.getM_y() - this.m_field.getM_y())/2);
        try {
            if (CGame.GameLayout.GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine()==null)
                return false;
        } catch (Exception e) {
            return false;
        }
        KillIndian(new TPoint(x,y));
        return true;
    }

    public void KillIndian(TPoint coords) throws Exception{
        //DONE
        CGame.IndianFigurines.remove(CGame.GameLayout.GetAt(coords).getM_figurine().getIndianFigurine());
        CGame.instance.removeObject(CGame.GameLayout.GetAt(coords).getM_figurine());
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
    public void move (CField field) throws Exception {
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

        //Move the figurine
        TPoint oldFieldCoords = new TPoint(this.m_field.getM_x(), this.m_field.getM_y());
        field.setM_figurine(this);
        CGame.GameLayout.GetAt(oldFieldCoords).setM_figurine(null);
        this.m_field = field;

        CGame.PlayerState = TState.Moved;
        //Change game state
        if (killed) {
            CGame.PlayerState = TState.KilledSomeone;
        }
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
        if (    (field.getM_x() < 2 && field.getM_y() < 2) ||
                (field.getM_x() < 2 && field.getM_y() > 4) ||
                (field.getM_x() > 4 && field.getM_y() < 2) ||
                (field.getM_x() > 4 && field.getM_y() > 4))
            return false;
        //Check if moving too far away
        if (Math.abs(field.getM_x() - this.m_field.getM_x()) > 1 || Math.abs(field.getM_y() - this.m_field.getM_y()) > 1) {
            //Moving too far away may indicate killing enemy figure
            //Check if moving for killing
            int x = Math.abs(field.getM_x() - this.m_field.getM_x());
            int y = Math.abs(field.getM_y() - this.m_field.getM_y());
            if ((x!=0 && x!=2) || (y!=0 && y!=2)) {
                return false;
            }

            x = this.m_field.getM_x() + ((field.getM_x() - this.m_field.getM_x())/2);
            y = this.m_field.getM_y() + ((field.getM_y() - this.m_field.getM_y())/2);
            try {
                if (CGame.GameLayout.GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine()==null)
                    return false;
            } catch (Exception e) {
                return false;
            }
        } else {
            if (CGame.PlayerState == TState.KilledSomeone) {
                return false;
            }
        }
        //Check if diagonal move is possible
        if ( (this.m_field.getM_x() % 2) != (this.m_field.getM_y() % 2) ) {
            //Can not move diagonally
            //Check if moving diagonally
            if (field.getM_x() != this.m_field.getM_x() && field.getM_y() != this.m_field.getM_y()) {
                return false;
            }
        }
        //Check if target field is occupied
        return field.getM_figurine() == null;

    }

}
