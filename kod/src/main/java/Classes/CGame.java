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

    public CGame() {
        //TODO
    }

    public void NewGame() {
        //TODO
    }

    public void EndGame() {
        //TODO
    }

    public void EndTurn() {
        //TODO
    }

    public TCurrentPlayerTurn getM_currentPlayerTurn() {
        //Getter - DONE
        return m_currentPlayerTurn;
    }

    public TState getM_playerState() {
        //Getter - DONE
        return m_playerState;
    }

    public CGameLayout getM_gameLayout() {
        //Getter - DONE
        return m_gameLayout;
    }

    public List<CIndianFigurine> getM_indianFigurines() {
        //Getter - DONE
        return m_indianFigurines;
    }

    public List<CSettlerFigurine> getM_settlerFigurines() {
        //Getter - DONE
        return m_settlerFigurines;
    }
}
