package Classes;

import DataTypes.TPoint;

public class CField {
    private int m_x;
    private int m_y;
    private CFigurine m_figurine;

    public CField(TPoint coordinates) {
        //Constructor - DONE
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
