package Classes;

import DataTypes.TPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class CFigurineTest {

    @Test
    public void isLegalMoveIndian() {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint();
        targetCoords.x = 3;
        targetCoords.y = 3;

        CFigurine indianFigure = game.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Legal horizontal move
        targetCoords.x = 4;
        targetCoords.y = 3;
        assertTrue(indianFigure.isLegalMove(targetCoords));

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal vertical move to occupied field
        targetCoords.x = 3;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal move to its own field
        targetCoords.x = 3;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Legal vertical move
        targetCoords.x = 3;
        targetCoords.y = 4;
        game.getM_gameLayout().GetAt(targetCoords).setM_figurine(null);
        targetCoords.x = 3;
        targetCoords.y = 4;
        assertTrue(indianFigure.isLegalMove(targetCoords));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal horizontal move
        targetCoords.x = 2;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal move too far away
        targetCoords.x = 2;
        targetCoords.y = 7;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal move out of bounds
        targetCoords.x = -1;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(targetCoords));

        //Ilegal move out of bounds
        targetCoords.x = 2;
        targetCoords.y = 9;
        assertFalse(indianFigure.isLegalMove(targetCoords));
    }

    @Test
    public void isLegalMoveSettler() {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint();
        targetCoords.x = 6;
        targetCoords.y = 3;
        CFigurine settlerFigure = game.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal diagonal move
        targetCoords.x = 6;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(targetCoords));

        //Legal horizontal move
        targetCoords.x = 6;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(targetCoords));

        //Ilegal diagonal move
        targetCoords.x = 6;
        targetCoords.y = 4;
        assertFalse(settlerFigure.isLegalMove(targetCoords));

        targetCoords.x = 6;
        targetCoords.y = 2;
        settlerFigure = game.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal move to the same position
        targetCoords.x = 6;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(targetCoords));

        //Ilegal move to occupied field
        targetCoords.x = 6;
        targetCoords.y = 3;
        assertFalse(settlerFigure.isLegalMove(targetCoords));

        //Legal horizontal move
        targetCoords.x = 5;
        targetCoords.y = 2;
        assertTrue(settlerFigure.isLegalMove(targetCoords));

        //Legal diagonal move
        targetCoords.x = 5;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(targetCoords));

        //Ilegal move out of bounds
        targetCoords.x = 8;
        targetCoords.y = 3;
        assertFalse(settlerFigure.isLegalMove(targetCoords));

        //Ilegal move out of bounds
        targetCoords.x = 6;
        targetCoords.y = -1;
        assertFalse(settlerFigure.isLegalMove(targetCoords));
    }
}