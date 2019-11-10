package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TState;

import java.util.List;

public class CGame {
    private CGameLayout m_gameLayout;
    private TCurrentPlayerTurn m_currentPlayerTurn;
    private List<CIndianFigurine> m_indianFigurines;
    private List<CSettlerFigurine> m_settlerFigurines;
    private TState m_playerState;

    public CGame(CGameLayout m_gameLayout) {

    }

    public void NewGame() {

    }

    public void EndGame() {

    }

    public void EndTurn() {

    }

    public TCurrentPlayerTurn getM_currentPlayerTurn() {
        return m_currentPlayerTurn;
    }

    public TState getM_playerState() {
        return m_playerState;
    }

    public void setM_playerState(TState m_playerState) {
        this.m_playerState = m_playerState;
    }
}
