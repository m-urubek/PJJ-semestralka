package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TFigurineType;
import DataTypes.TPoint;
import DataTypes.TState;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CGameTest {

    @Test
    public void newGameTestForExistingGameLayoutInstance() {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        assertNotNull(game.getM_gameLayout());
    }

    @Test
    public void newGameTestForFigurinesLists() {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking if the NewGame() method generated correct number of figurines.
        int numberOfSettlerFigurines = game.getM_settlerFigurines().size();
        int numberOfIndianFigurines = game.getM_indianFigurines().size();
        assertEquals(numberOfSettlerFigurines, 3);
        assertEquals(numberOfIndianFigurines, 20);
    }

    @Test
    public void newGameTestForFigurinesPlacement() {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking if the NewGame() method placed all the figurines on correct starting locations.
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if ((x < 3 && y > 2) || (x > 4 && y > 2)) {  // skip corners
                    continue;
                }

                CField currentField = game.getM_gameLayout().GetAt(new TPoint(x, y));

                if (y < 4) {
                    assertNotNull(currentField.getM_figurine());
                    assertEquals(currentField.getM_figurine().getM_type(), TFigurineType.Indian);
                }
                if (y == 4 || y == 5) {
                    assertEquals(currentField.getM_figurine(), null);
                }
                if (y == 5) {
                    assertNotNull(currentField.getM_figurine());
                    assertEquals(currentField.getM_figurine().getM_type(), TFigurineType.Settler);
                }
            }
        }
    }

    @Test
    public void endTurnTestForPossibilityOfEndingTheTurn() {
        CGame game = new CGame();

        TCurrentPlayerTurn currentPlayerTurn = game.getM_currentPlayerTurn();

        game.EndTurn();//state should be NotMoved right now, so endTurn should not be possible
        assertEquals(currentPlayerTurn, game.getM_currentPlayerTurn());  // currentPlayerTurn should not be changed because the EndTurn() should not proceed
        assertEquals(game.getM_playerState(), TState.NotMoved);

        //this series of moves should get settler into state canOnlyKill
        game.getM_gameLayout().Move(new TPoint(4, 6), new TPoint(4, 5));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(3, 3), new TPoint(3, 4));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(4, 5), new TPoint(4, 6));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(3, 2), new TPoint(3, 3));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(4, 6), new TPoint(4, 5));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(3, 4), new TPoint(3, 5));
        assertEquals(game.getM_playerState(), TState.Moved);
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        game.getM_gameLayout().Move(new TPoint(3, 6), new TPoint(3, 4));
        assertEquals(game.getM_playerState(), TState.CanOnlyKill);
        currentPlayerTurn = game.getM_currentPlayerTurn();
        game.EndTurn();
        assertEquals(game.getM_playerState(), TState.NotMoved);
        assertNotEquals(currentPlayerTurn, game.getM_currentPlayerTurn());  // currentPlayerTurn should be changed because state was CanOnlyKill()
        currentPlayerTurn = game.getM_currentPlayerTurn();
        game.EndTurn();
        assertEquals(currentPlayerTurn, game.getM_currentPlayerTurn());  // currentPlayerTurn should not be changed because the EndTurn() should not proceed
    }
}