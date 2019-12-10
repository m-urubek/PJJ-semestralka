package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;

import java.util.List;

public class CGame {
    public static CGameLayout GameLayout;
    public static TCurrentPlayerTurn CurrentPlayerTurn;
    public static List<CIndianFigurine> IndianFigurines;
    public static List<CSettlerFigurine> SettlerFigurines;
    public static TState PlayerState;

    public CGame() throws Exception {
        if (GameLayout == null) {
            NewGame();
        }
    }

    public static void NewGame() throws Exception {
        if (GameLayout != null) {
            EndGame();
        }
        GameLayout = new CGameLayout();
    }

    public static void EndGame() {
        //TODO
    }

    private static void testremainingKillAndRemove(CSettlerFigurine currentFigurine, int x, int y) throws Exception{
        TPoint point = new TPoint(x, y);
        CField field = null;
        try {
            field = CGame.GameLayout.GetAt(point);
        } catch (Exception ex) {
            return;
        }
        if (currentFigurine.isLegalMove(field)) {
            CGame.SettlerFigurines.remove(currentFigurine);
            GameLayout.DeleteFieldContent(currentFigurine.m_field);
        }
    }

    public static void EndTurn() throws Exception{
        //DONE
        for (CSettlerFigurine currentFigurine : CGame.SettlerFigurines) {
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y());
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y());
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() + 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() + 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() + 2);
        }
        if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian) {
            CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Settler;
        } else {
            CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Indian;
        }
    }
}
