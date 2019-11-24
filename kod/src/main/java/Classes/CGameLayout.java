package Classes;

import DataTypes.TPoint;

import java.util.List;

public class CGameLayout {
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine;

    public CGameLayout() {
        //TODO - Creates empty game field - TODO Review!!!
        for (int i = 0; i< CGame.BOARD_WIDTH*CGame.BOARD_WIDTH; i++) {
            this.m_board.add(new CField(indexToCoords(i)));
        }
    }

    private TPoint indexToCoords (int index) {
        //DONE - TODO Review!
        // x= index MOD 7; y= index DIV 7
        return new TPoint( index % CGame.BOARD_WIDTH, index/CGame.BOARD_WIDTH );
    }

    private int coordsToIndex (TPoint coords) {
        //DONE - TODO Review!
        // index = x + y*7
        return coords.x + coords.y*CGame.BOARD_WIDTH;
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
     * @param source			Field where the figure is currently located
     * @param target			Field where the figure is supposed to move
     */
    public void Move(CField source, CField target) {
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
