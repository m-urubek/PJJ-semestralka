import DataTypes.TDialogType;
import greenfoot.*;

import DataTypes.TPoint;
import DataTypes.TState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static greenfoot.ActorVisitor.getWorld;

public class CGameLayout {
    private List<CField> m_board;
    private CFigurine m_currentlySelectedFigurine= null;
    public FigurineSelector selectedFigurine = null;

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

    private void addIndianToField(int x, int y) throws Exception {
        CField field = m_board.get(CGeneralHelper.coordsToIndex(new TPoint(x,y)));
        CIndianFigurine figurine = new CIndianFigurine(field);
        field.setM_figurine((CFigurine)figurine);
        CGame.IndianFigurines.add(figurine);
        CGame.instance.addObject((CFigurine)figurine, field.getX(), field.getY());
    }
    private void addSettlerToField(int x, int y) throws Exception {
        CField field = m_board.get(CGeneralHelper.coordsToIndex(new TPoint(x,y)));
        CSettlerFigurine figurine = new CSettlerFigurine(field);
        field.setM_figurine((CFigurine) figurine);
        CGame.SettlerFigurines.add(figurine);
        CGame.instance.addObject((CFigurine)figurine, field.getX(), field.getY());
    }

    private CField addEmptyField(TPoint coords) throws Exception {

        CField field = new CField(coords);
        TPoint gameCoords = CGeneralHelper.indexToGameCoords(CGeneralHelper.coordsToIndex(coords));
        CGame.instance.addObject(field, gameCoords.x, gameCoords.y);
        field.setM_figurine(null);
        return field;
    }

    public CGameLayout() throws Exception {
        //TODO - Creates empty game field - TODO Review!!!
        m_board = new ArrayList<CField>(Collections.nCopies(33, null)); //add 33 nulls into the array

        for (int i = 0; i < 33; i++) {
            TPoint coords = CGeneralHelper.indexToCoords(i);
            m_board.add(i, addEmptyField(coords));
        }
        addIndianToField(2, 0);
        addIndianToField(3, 0);

        addIndianToField(2, 1);
        addIndianToField(3, 1);

        addIndianToField(0, 2);
        addIndianToField(1, 2);
        addIndianToField(2, 2);
        addIndianToField(3, 2);

        addIndianToField(0, 3);
        addIndianToField(1, 3);
        addIndianToField(2, 3);
        addIndianToField(3, 3);

        addIndianToField(0, 4);
        addIndianToField(1, 4);
        addIndianToField(2, 4);
        addIndianToField(3, 4);

        addIndianToField(2, 5);
        addIndianToField(3, 5);

        addIndianToField(2, 6);
        addIndianToField(3, 6);

        addSettlerToField(6, 2);
        addSettlerToField(6, 3);
        addSettlerToField(6, 4);
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
        if (CGame.PlayerState == TState.Moved) {
            CGeneralHelper.ShowDialog(DataTypes.TDialogType.Warning, "Již není možné táhnout.");
            return;
        }
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

    public String SaveGame() {
        String string = "";
        for (int i=0; i<33; i++) {
            if (this.m_board.get(i).getM_figurine() == null) {
                string += ("e");
            } else if (this.m_board.get(i).getM_figurine().getSettlerFigurine() != null) {
                string +=("s");
            } else {
                string +=("i");
            }
        }
        return string;
    }

    public void updateGameField() {
        for (int i = 0; i<33; i++) {
            try {
                if (m_board.get(i).getM_figurine() != null) {
                    m_board.get(i).getM_figurine().setGamePos(CGeneralHelper.indexToGameCoords(i));
                }
            } catch (Exception e) {
                if (e == null || e.getMessage() == null) {
                    CGeneralHelper.ShowDialog(DataTypes.TDialogType.Error, "Neočekávaná vyjímka");
                } else {
                    CGeneralHelper.ShowDialog(DataTypes.TDialogType.Error, e.getMessage());
                }
            }
        }
    }
}
