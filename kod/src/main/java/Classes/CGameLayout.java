package Classes;

import DataTypes.TPoint;
import DataTypes.TState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CGameLayout {
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine;

    private void addIndianFigurine(int x, int y) throws Exception {
        TPoint coords = new TPoint(x, y);
        CField field = new CField(coords);
        field.setM_figurine(new CIndianFigurine(field));
        this.m_board.add(CGeneralHelper.coordsToIndex(coords), field);
    }

    private void addSettlerFigurine(int x, int y) throws Exception {
        TPoint coords = new TPoint(x, y);
        CField field = new CField(coords);
        field.setM_figurine(new CSettlerFigurine(field));
        this.m_board.add(CGeneralHelper.coordsToIndex(coords), field);
    }

    private void addEmptyField(int x, int y) throws Exception {
        TPoint coords = new TPoint(x, y);
        CField field = new CField(coords);
        field.setM_figurine(null);
        this.m_board.add(CGeneralHelper.coordsToIndex(coords), field);
    }

    public CGameLayout() throws Exception {
        //TODO - Creates empty game field - TODO Review!!!
        m_board = new ArrayList<CField>(Collections.nCopies(33, null)); //add 33 nulls into the array

        addIndianFigurine(2, 0);
        addIndianFigurine(3, 0);

        addIndianFigurine(2, 1);
        addIndianFigurine(3, 1);

        addIndianFigurine(0, 2);
        addIndianFigurine(1, 2);
        addIndianFigurine(2, 2);
        addIndianFigurine(3, 2);

        addIndianFigurine(0, 3);
        addIndianFigurine(1, 3);
        addIndianFigurine(2, 3);
        addIndianFigurine(3, 3);

        addIndianFigurine(0, 4);
        addIndianFigurine(1, 4);
        addIndianFigurine(2, 4);
        addIndianFigurine(3, 4);

        addIndianFigurine(2, 5);
        addIndianFigurine(3, 5);

        addIndianFigurine(2, 6);
        addIndianFigurine(3, 6);

        addSettlerFigurine(6, 2);
        addSettlerFigurine(6, 3);
        addSettlerFigurine(6, 4);

        addEmptyField(4, 0);
        addEmptyField(4, 1);
        addEmptyField(4, 2);
        addEmptyField(4, 3);
        addEmptyField(4, 4);
        addEmptyField(4, 5);
        addEmptyField(4, 6);

        addEmptyField(5, 2);
        addEmptyField(5, 3);
        addEmptyField(5, 4);
    }

    public void DeleteFieldContent(TPoint target) throws Exception {
        m_board.get(CGeneralHelper.coordsToIndex(target)).setM_figurine(null);
    }

    public void DeleteFieldContent(CField field) {
        field.setM_figurine(null);
    }

    public CField GetAt(TPoint coordinates) throws Exception {
        //TODO
        return m_board.get(CGeneralHelper.coordsToIndex(coordinates));
    }

    /**
     * move
     * Moves the figurine on source coordinates to target coordinates
     *
     * @param source Field where the figure is currently located
     * @param target Field where the figure is supposed to move
     */
    public void Move(CField source, CField target) throws Exception {
        //In Progress - TODO

        //Check if player already played
        if (CGame.PlayerState == TState.Moved)
            return;
        source.getM_figurine().move(target);
    }

    public boolean IsFarm(TPoint coordinates) throws Exception {
        //DONE
        return IsFarm(GetAt(coordinates));
    }

    public boolean IsFarm(CField field) {
        //DONE
        int x = field.getM_x();
        int y = field.getM_y();

        if ((x == 4 && y == 2)
                || (x == 5 && y == 2)
                || (x == 6 && y == 2)
                || (x == 4 && y == 3)
                || (x == 5 && y == 3)
                || (x == 6 && y == 3)
                || (x == 4 && y == 4)
                || (x == 5 && y == 4)
                || (x == 6 && y == 4))
            return true;

        return false;
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
