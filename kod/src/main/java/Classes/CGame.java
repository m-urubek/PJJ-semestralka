package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TState;

import java.util.List;

public class CGame {
    public static CGameLayout m_gameLayout;
    public static TCurrentPlayerTurn m_currentPlayerTurn;
    public static List<CIndianFigurine> m_indianFigurines;
    public static List<CSettlerFigurine> m_settlerFigurines;
    public static TState m_playerState;

    public static void NewGame() {
        if (m_gameLayout != null){
            EndGame();
        }
        m_gameLayout = new CGameLayout();
    }

    public static void EndGame() {
        //TODO
    }

    public static void EndTurn() {
        //TODO
    }
}
