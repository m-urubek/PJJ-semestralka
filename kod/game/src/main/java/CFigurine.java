import DataTypes.TFigurineType;
import DataTypes.TPoint;
import greenfoot.*;

public abstract class CFigurine extends Actor {
    private TFigurineType m_type;
    protected CField m_field;

    public abstract CIndianFigurine getIndianFigurine();

    public abstract CSettlerFigurine getSettlerFigurine();

    @Override
    public void act () {
        if (Greenfoot.mouseClicked(this)) {
            this.m_field.onClick();
        }
    }
    public void setGamePos (TPoint coords) {
        this.setLocation(coords.x, coords.y);
    }

    /**
     * isLegalMove
     * Checks if figurine move is valid.
     *
     * @param field   field where the figure is supposed to move
     * @return            	true if the move can be done
     */
    public abstract boolean isLegalMove (CField field)throws Exception;

    public abstract void move (CField field)throws Exception;

    public TFigurineType getM_type () {
        //Getter - DONE
        return this.m_type;
    }

    public void setM_type (TFigurineType m_type) {
        //Setter - DONE
        this.m_type = m_type;
    }
}
