package Classes;

import DataTypes.TPoint;

import java.util.List;

public class CGameLayout {
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine;

    public CGameLayout() {
        //TODO
    }

    private void insertField(CField field, TPoint coordinates){
        //TODO
    }

    public void DeleteFieldContent(TPoint target) {
        //TODO
    }

    public void DeleteFieldContent(CField field) {
        //TODO
    }

    public CField GetAt(TPoint coordinates) {
        return null;
    }
    //TODO
    /**
     * move
     * Moves the figurine on source coordinates to target coordinates
     *
     * @param source			coordinates where the figure is currently located
     * @param target			coordinates where the figure is supposed to move
     */
    public void Move(TPoint source, TPoint target) {
        //TODO
    }

    public boolean IsFarm(TPoint coordinates){
        //TODO
        return true;
    }

    public boolean IsFarm(CField field){
        //TODO
        return true;
    }

    public CFigurine getM_currentlySelectedFigurine() {
        //Getter - DONE
        return m_currentlySelectedFigurine;
    }

    public void setM_currentlySelectedFigurine(CFigurine m_currentlySelectedFigurine) {
        //Setter - DONE
        this.m_currentlySelectedFigurine = m_currentlySelectedFigurine;
    }
}
