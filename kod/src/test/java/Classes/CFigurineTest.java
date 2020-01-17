package Classes;

import DataTypes.TPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class CFigurineTest {

    @Test
    public void placeholderTest1() {
        assertTrue(true);
    }

    @Test
    public void isLegalMoveIndian() throws Exception {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint(3, 3);


        CFigurine indianFigure = CGame.GameLayout.GetAt(targetCoords).getM_figurine().getIndianFigurine();
        assertNotEquals(null, indianFigure);

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 4;
        targetCoords.y = 3;
        assertTrue(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 4;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal vertical move to occupied field
        targetCoords.x = 3;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move to its own field
        targetCoords.x = 3;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Legal vertical move
        targetCoords.x = 3;
        targetCoords.y = 4;
        CGame.GameLayout.GetAt(targetCoords).setM_figurine(null);
        targetCoords.x = 3;
        targetCoords.y = 4;
        assertTrue(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal horizontal move
        targetCoords.x = 2;
        targetCoords.y = 3;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 2;
        targetCoords.y = 4;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move too far away
        targetCoords.x = 2;
        targetCoords.y = 6;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = -1;
        targetCoords.y = 2;
        boolean testOK = false;
        try {
            indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

        //Ilegal move out of bounds
        targetCoords.x = 2;
        targetCoords.y = 9;
        testOK = false;
        try {
            indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);
    }


    @Test
    public void isLegalMoveSettler() throws Exception {
        CGame game = new CGame();
        TPoint targetCoords = new TPoint(6, 3);

        CFigurine settlerFigure = CGame.GameLayout.GetAt(targetCoords).getM_figurine().getSettlerFigurine();
        assertNotEquals(null, settlerFigure);

        //Ilegal diagonal move
        targetCoords.x = 5;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 5;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal diagonal move
        targetCoords.x = 6;
        targetCoords.y = 4;
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        targetCoords.x = 6;
        targetCoords.y = 2;
        settlerFigure = CGame.GameLayout.GetAt(targetCoords).getM_figurine();

        //Ilegal move to the same position
        targetCoords.x = 6;
        targetCoords.y = 2;
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move to occupied field
        targetCoords.x = 6;
        targetCoords.y = 3;
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Legal horizontal move
        targetCoords.x = 5;
        targetCoords.y = 2;
        assertTrue(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Legal diagonal move
        targetCoords.x = 5;
        targetCoords.y = 3;
        assertTrue(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 8;
        targetCoords.y = 3;
        boolean testOK = false;
        try {
            settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

        //Ilegal move out of bounds
        targetCoords.x = 6;
        targetCoords.y = -1;
        testOK = false;
        try {
            settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

    }

    @Test
    public void isLegalMoveKicking() throws Exception {
        try {
            CGame game = new CGame();
        }
        catch(Exception ex){
            int i = 0;
        }

        CGame.GameLayout.GetAt(new TPoint(0, 4)).setM_figurine(null);
        CGame.GameLayout.GetAt(new TPoint(2, 2)).setM_figurine(null);
        CField field = CGame.GameLayout.GetAt(new TPoint(5, 3));
        field.setM_figurine(new CSettlerFigurine(field));

        CFigurine settler = CGame.GameLayout.GetAt(new TPoint(5, 3)).getM_figurine().getSettlerFigurine();
        assertNotEquals(null, settler);

        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(4, 4))));

        field = CGame.GameLayout.GetAt(new TPoint(4, 4));
        field.setM_figurine(new CSettlerFigurine(field));
        settler = CGame.GameLayout.GetAt(new TPoint(4, 4)).getM_figurine().getSettlerFigurine();
        assertNotEquals(null, settler);
        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(2, 2))));
        assertFalse(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(0, 4))));

    }


}