package Classes;

import DataTypes.TFigurineType;
import DataTypes.TPoint;

public abstract class CFigurine {
    private TFigurineType m_type;
    private TPoint m_position;

    public CFigurine () {
        //TODO
    }

    public CIndianFigurine getIndianFigurine() {
        //TODO
        return null;
    }

    public CSettlerFigurine getSettlerFigurine() {
        //TODO
        return null;
    }

    public CField getAsField() {
        //TODO


        return null;
    }

    /**
     * isLegalMove
     * Checks if figurine move is valid.
     *
     * @param coordinates   coordinates where the figure is supposed to move
     * @return            	true if the move can be done
     */
    public boolean isLegalMove (TPoint coordinates) {
        //TODO

        return false;
    }

    public void move (TPoint coordinates) {
        //TODO
    }

    public TFigurineType getM_type () {
        //Getter - DONE
        return this.m_type;
    }

    public void setM_type (TFigurineType m_type) {
        //Setter - DONE
        this.m_type = m_type;
    }

    public TPoint getM_position() {
        //Getter - DONE
        return this.m_position;
    }

    public void setM_position (TPoint position) {
        //Setter - DONE
        this.m_position.x = position.x;
        this.m_position.y = position.y;
    }

    public void setM_position (int x, int y) {
        //Setter - DONE
        this.m_position.x = x;
        this.m_position.y = y;
    }



}
