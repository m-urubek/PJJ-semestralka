package Classes;

import DataTypes.TPoint;

import java.util.List;

public class CGameLayout {
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine;

    public CGameLayout() {
    }

    public void DeleteFieldContent(TPoint target) {

    }

    public void DeleteFieldContent(CField field) {

    }

    public CField GetAt(TPoint coordinates) {
        return null;
    }

    public void Move(TPoint source, TPoint target) {

    }

    public boolean IsFarm(TPoint coordinates){
        return true;// todo
    }

    public boolean IsFarm(CField field){
        return true;// todo
    }

    public CFigurine getM_currentlySelectedFigurine() {
        return m_currentlySelectedFigurine;
    }

    public void setM_currentlySelectedFigurine(CFigurine m_currentlySelectedFigurine) {
        this.m_currentlySelectedFigurine = m_currentlySelectedFigurine;
    }
}
