package Classes;

import DataTypes.TPoint;

public class CField {
    private int m_x;
    private int m_y;
    private CFigurine m_figurine;

    public CField(TPoint coordinates) {
    }

    public CField(TPoint coordinates, CFigurine figurine) {
    }

    public int getM_x() {
        return m_x;
    }

    public int getM_y() {
        return m_y;
    }

    public CFigurine getM_figurine() {
        return m_figurine;
    }

    public void setM_figurine(CFigurine m_figurine) {
        this.m_figurine = m_figurine;
    }
}
