package Classes;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CGameTest {

    @Test
    public void newGame() {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking the NewGame method generated correct number of figurines.
        int numberOfSettlerFigurines = game.getM_settlerFigurines().size();
        int numberOfIndianFigurines = game.getM_indianFigurines().size();
        assertEquals(numberOfSettlerFigurines, 3);
        assertEquals(numberOfIndianFigurines, 20);

        //checking the NewGame method placed all the figurines on correct starting locations.

    }

    @Test
    public void endTurn() {
    }
}