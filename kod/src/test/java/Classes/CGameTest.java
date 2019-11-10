package Classes;

import DataTypes.TFigurineType;
import DataTypes.TPoint;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CGameTest {

    @Test
    public void newGame() {
        CGame game = new CGame();  //constructor should call NewGame() method and initialize all game objects

        //checking if the NewGame() method generated correct number of figurines.
        int numberOfSettlerFigurines = game.getM_settlerFigurines().size();
        int numberOfIndianFigurines = game.getM_indianFigurines().size();
        assertEquals(numberOfSettlerFigurines, 3);
        assertEquals(numberOfIndianFigurines, 20);

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
    public void endTurn() {
    }
}