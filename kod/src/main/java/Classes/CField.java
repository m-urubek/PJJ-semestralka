package Classes;

import DataTypes.TPoint;

public class CField {
    private int m_x;
    private int m_y;
    private CFigurine m_figurine;

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
