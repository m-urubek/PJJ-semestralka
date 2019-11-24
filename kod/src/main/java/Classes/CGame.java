package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;

import java.util.List;

public class CGame {
    public static CGameLayout m_gameLayout;
    public static TCurrentPlayerTurn m_currentPlayerTurn;
    public static List<CIndianFigurine> m_indianFigurines;
    public static List<CSettlerFigurine> m_settlerFigurines;
    public static TState m_playerState;

    public static void NewGame() {
        if (m_gameLayout != null) {
            EndGame();
        }
        m_gameLayout = new CGameLayout();
    }

    public static void EndGame() {
        //TODO
    }

    public static void EndTurn() {
        //TODO
        for (CSettlerFigurine currentFigurine : CGame.m_settlerFigurines) {
            TPoint point = new TPoint(currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y());
            CField field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y());
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() + 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() - 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() + 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() - 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() - 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            point = new TPoint(currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() + 2);
            field = CGame.m_gameLayout.GetAt(point);
            if (currentFigurine.isLegalMove(field)) {
                CGame.m_settlerFigurines.remove(currentFigurine);
                m_gameLayout.DeleteFieldContent(currentFigurine.m_field);
            }

            if (CGame.m_currentPlayerTurn == TCurrentPlayerTurn.Indian) {
                CGame.m_currentPlayerTurn = TCurrentPlayerTurn.Settler;
            } else {
                CGame.m_currentPlayerTurn = TCurrentPlayerTurn.Indian;
            }
        }

    }
}
