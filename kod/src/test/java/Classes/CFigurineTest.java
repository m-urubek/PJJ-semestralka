package Classes;

import DataTypes.TPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class CFigurineTest {

    @Test
    public void isLegalMoveIndian() {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint(3,3);

        CFigurine indianFigure = CGame.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 4;
        targetCoords.y = 3;
        assertTrue(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal vertical move to occupied field
        targetCoords.x = 3;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move to its own field
        targetCoords.x = 3;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Legal vertical move
        targetCoords.x = 3;
        targetCoords.y = 4;
        CGame.getM_gameLayout().GetAt(targetCoords).setM_figurine(null);
        targetCoords.x = 3;
        targetCoords.y = 4;
        assertTrue(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal horizontal move
        targetCoords.x = 2;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move too far away
        targetCoords.x = 2;
        targetCoords.y = 7;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = -1;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 2;
        targetCoords.y = 9;
        assertFalse(indianFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));
    }

    @Test
    public void isLegalMoveSettler() {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint(6,3);
        CFigurine settlerFigure = CGame.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal diagonal move
        targetCoords.x = 6;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 6;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 6;
        targetCoords.y = 4;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        targetCoords.x = 6;
        targetCoords.y = 2;
        settlerFigure = CGame.getM_gameLayout().GetAt(targetCoords).getM_figurine();

        //Ilegal move to the same position
        targetCoords.x = 6;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move to occupied field
        targetCoords.x = 6;
        targetCoords.y = 3;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 5;
        targetCoords.y = 2;
        assertTrue(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Legal diagonal move
        targetCoords.x = 5;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 8;
        targetCoords.y = 3;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 6;
        targetCoords.y = -1;
        assertFalse(settlerFigure.isLegalMove(CGame.getM_gameLayout().GetAt(targetCoords)));
    }

    @Test
    public void isLegalMoveKicking() {
        CGame game = new CGame();

        CGame.getM_gameLayout().GetAt(new TPoint(0,4)).setM_figurine(null);
        CGame.getM_gameLayout().GetAt(new TPoint(2,2)).setM_figurine(null);
        CGame.getM_gameLayout().GetAt(new TPoint(5,3)).setM_figurine(new CIndianFigurine());

        CFigurine settler = CGame.getM_gameLayout().GetAt(new TPoint(6,2)).getM_figurine();


        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(4,4))));
        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(2,2))));
        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(0,4))));


        settler = CGame.getM_gameLayout().GetAt(new TPoint(6,4)).getM_figurine();

        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(4,2))));
        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(2,4))));
        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(0,2))));

        CGame.getM_gameLayout().GetAt(new TPoint(5,4)).setM_figurine(new CSettlerFigurine());
        CGame.getM_gameLayout().GetAt(new TPoint(4,3)).setM_figurine(new CIndianFigurine());
        CGame.getM_gameLayout().GetAt(new TPoint(3,2)).setM_figurine(null);

        settler = CGame.getM_gameLayout().GetAt(new TPoint(5,4)).getM_figurine();

        assertTrue(settler.isLegalMove(CGame.getM_gameLayout().GetAt(new TPoint(3,2))));

    }


}