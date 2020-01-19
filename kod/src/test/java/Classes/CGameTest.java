package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TFigurineType;
import DataTypes.TPoint;
import DataTypes.TState;
import org.junit.Test;

import static org.junit.Assert.*;

public class CGameTest {
    @Test
    public void placeholderTest3() {
        assertTrue(true);
    }

    @Test
    public void newGameTestForExistingGameLayoutInstance() throws Exception {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        assertNotNull(game.GameLayout);
    }
/* TODO - Martin
    @Test
    public void newGameTestForFigurinesLists() throws Exception {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking if the NewGame() method generated correct number of figurines.
        int numberOfSettlerFigurines = game.SettlerFigurines.size();
        int numberOfIndianFigurines = game.IndianFigurines.size();
        assertEquals(numberOfSettlerFigurines, 3);
        assertEquals(numberOfIndianFigurines, 20);
    }
*/
/*
    @Test
    public void newGameTestForFigurinesPlacement() throws Exception {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking if the NewGame() method placed all the figurines on correct starting locations.
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if ((x < 3 && y > 2) || (x > 4 && y > 2)) {  // skip corners
                    continue;
                }

                CField currentField = game.GameLayout.GetAt(new TPoint(x, y));

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
*//*
    @Test
    public void endTurnTestForPossibilityOfEndingTheTurn() throws Exception {
        CGame game = new CGame();

        TCurrentPlayerTurn currentPlayerTurn = game.CurrentPlayerTurn;

        game.EndTurn();//state should be NotMoved right now, so endTurn should not be possible
        assertEquals(currentPlayerTurn, game.CurrentPlayerTurn);  // currentPlayerTurn should not be changed because the EndTurn() should not proceed
        assertEquals(game.PlayerState, TState.NotMoved);

        //this series of moves should get settler into state canOnlyKill
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(4,6)),CGame.GameLayout.GetAt(new TPoint(4,5)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(3,3)),CGame.GameLayout.GetAt(new TPoint(3,4)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(4,5)),CGame.GameLayout.GetAt(new TPoint(4,6)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(3,2)),CGame.GameLayout.GetAt(new TPoint(3,3)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(4,6)),CGame.GameLayout.GetAt(new TPoint(4,5)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(3,4)),CGame.GameLayout.GetAt(new TPoint(3,5)));
        assertEquals(game.PlayerState, TState.Moved);
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(new TPoint(3,6)),CGame.GameLayout.GetAt(new TPoint(3,4)));
        assertEquals(game.PlayerState, TState.CanOnlyKill);
        currentPlayerTurn = game.CurrentPlayerTurn;
        game.EndTurn();
        assertEquals(game.PlayerState, TState.NotMoved);
        assertNotEquals(currentPlayerTurn, game.CurrentPlayerTurn);  // currentPlayerTurn should be changed because state was CanOnlyKill()
        assertEquals(null, CGame.GameLayout.GetAt(new TPoint(3,6)));//settler should get killed
        currentPlayerTurn = game.CurrentPlayerTurn;
        game.EndTurn();
        assertEquals(currentPlayerTurn, game.CurrentPlayerTurn);  // currentPlayerTurn should not be changed because the EndTurn() should not proceed
    }
    */
}