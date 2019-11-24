package Classes;

import DataTypes.TPoint;

import java.util.List;

public class CGameLayout {
    private final int BOARD_WIDTH = 7; //Supposed to be CONSTANT, might change later (ʘ‿ʘ)
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine;

    public CGameLayout() {
        //TODO - Creates empty game field - TODO Review!!!
        for (int i = 0; i< BOARD_WIDTH*BOARD_WIDTH; i++) {
            this.m_board.add(new CField(listToCoords(i)));
        }
    }

    private TPoint listToCoords (int index) {
        //DONE - TODO Review!
        return new TPoint( index % BOARD_WIDTH, index/BOARD_WIDTH );
    }

    public void DeleteFieldContent(TPoint target) {
        //TODO
    }

    public void DeleteFieldContent(CField field) {
        //TODO
    }

    public CField GetAt(TPoint coordinates) {
        //TODO
        return null;
    }

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
        //DONE - Why to write one code twice when I just can call same method with edited shit?
        return IsFarm( GetAt(coordinates) );
    }

    public boolean IsFarm(CField field){
        //TODO - This needs to be done though
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
