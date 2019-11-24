package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TFigurineType;
import DataTypes.TPoint;

public abstract class CFigurine {
    private TFigurineType m_type;
    protected CField m_field;

    public CIndianFigurine getIndianFigurine() {
        //DONE via Override
        return null;
    };

    public CSettlerFigurine getSettlerFigurine() {
        //DONE via Override
        return null;
    };

    /**
     * isLegalMove
     * Checks if figurine move is valid.
     *
     * @param field   field where the figure is supposed to move
     * @return            	true if the move can be done
     */
    public abstract boolean isLegalMove (CField field);

    public abstract void move (CField field);

    public TFigurineType getM_type () {
        //Getter - DONE
        return this.m_type;
    }

    public void setM_type (TFigurineType m_type) {
        //Setter - DONE
        this.m_type = m_type;
    }
}
