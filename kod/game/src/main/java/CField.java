import DataTypes.TCurrentPlayerTurn;
import DataTypes.TDialogType;
import DataTypes.TPoint;
import DataTypes.TState;
import greenfoot.Actor;
import greenfoot.*;

public class CField extends Actor {
    private int m_x;
    private int m_y;
    private CFigurine m_figurine;

    public void act () {
        if (Greenfoot.mouseClicked(this)) {
            this.onClick();
        }
    }

    public void onClick() {
        if(CGame.PlayerState == TState.Moved) {
            CGeneralHelper.ShowDialog(TDialogType.Warning, "Již není možné táhnout");
            return;
        }

        if (this.m_figurine == null) {
            //TODO - Player wants to move already selected figurine
            //Check if there is selected figurine
            if (CGame.GameLayout.getM_currentlySelectedFigurine() == null) {
                return;
            }

            try {
                CGame.GameLayout.getM_currentlySelectedFigurine().move(this);
                if (CGame.GameLayout.selectedFigurine != null) {
                    CGame.instance.removeObject(CGame.GameLayout.selectedFigurine);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            //TOTEST - Players wants to (re)select figurine
            //Check game state
            if (CGame.PlayerState == TState.KilledSomeone) {
                //Player can only move by currently selected figurine
                return;
            }

            //Check if player tries to select figurine of his faction
            boolean checker1 = this.m_figurine.getIndianFigurine() != null;//True==Indian; False==Settler
            boolean checker2 = CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian;//True==indian; False==Settler
            if (checker1 != checker2) {
                //Player is trying to select enemy figurine
                return;
            }

            CGame.GameLayout.setM_currentlySelectedFigurine(this.m_figurine);

            if (CGame.GameLayout.selectedFigurine != null) {
                CGame.instance.removeObject(CGame.GameLayout.selectedFigurine);
            }
            CGame.GameLayout.selectedFigurine = new FigurineSelector();

            CGame.instance.addObject(CGame.GameLayout.selectedFigurine, this.getX(), this.getY());
        }

        CGame.GameLayout.updateGameField();
    }

    private boolean IsOutOfLayout(TPoint point) {
        if (point.x > 6 || point.x < 0 || point.y > 6 || point.y < 0) {
            return true;
        }

        return (point.x == 0 && point.y == 0)
                || (point.x == 0 && point.y == 1)
                || (point.x == 1 && point.y == 0)
                || (point.x == 1 && point.y == 1)

                || (point.x == 5 && point.y == 0)
                || (point.x == 6 && point.y == 0)
                || (point.x == 5 && point.y == 1)
                || (point.x == 6 && point.y == 1)

                || (point.x == 5 && point.y == 5)
                || (point.x == 6 && point.y == 5)
                || (point.x == 5 && point.y == 6)
                || (point.x == 6 && point.y == 6)

                || (point.x == 0 && point.y == 5)
                || (point.x == 0 && point.y == 6)
                || (point.x == 1 && point.y == 5)
                || (point.x == 1 && point.y == 6);
    }

    public CField(TPoint coordinates) throws Exception {
        //Constructor - DONE
        if (IsOutOfLayout(coordinates)) {
            throw new Exception("ERROR - Trying to access coordinates that do not exist.");
        }
        this.m_x = coordinates.x;
        this.m_y = coordinates.y;
        this.m_figurine = null;
    }

    public CField(TPoint coordinates, CFigurine figurine) {
        //Constructor - DONE
        this.m_x = coordinates.x;
        this.m_y = coordinates.y;
        this.m_figurine = figurine;
    }

    public int getM_x() {
        //Getter - DONE
        return m_x;
    }

    public int getM_y() {
        //Getter - DONE
        return m_y;
    }

    public CFigurine getM_figurine() {
        //Setter - DONE
        return m_figurine;
    }

    public void setM_figurine(CFigurine m_figurine) {
        //Setter - DONE
        this.m_figurine = m_figurine;
    }
}
