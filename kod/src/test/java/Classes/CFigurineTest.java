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

        for (int i = 0; i<33; i++) {
            if (CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i))==null) {
                System.out.println("N");
            } else if (CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i)).getM_figurine()==null) {
                System.out.println("E");
            } else if (CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i)).getM_figurine().getSettlerFigurine()!=null) {
                System.out.println("S");
            } else if (CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i)).getM_figurine().getIndianFigurine()!=null) {
                System.out.println("I");
            }
        }


        //if (CGame.GameLayout.GetAt(targetCoords).getM_figurine() is CSettlerFigurine){

        //}

        //if getFigurine(coors) is settler
        //        mojeFigurka = (settler)getFigurine(coors)



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
/*
        //Ilegal move too far away
        targetCoords.x = 2;
        targetCoords.y = 7;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = -1;
        targetCoords.y = 2;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 2;
        targetCoords.y = 9;
        assertFalse(indianFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

 */
    }
/*
    @Test
    public void isLegalMoveIndianTest() {
        boolean thrown = false;
        try{
            isLegalMoveIndian();
        }catch(Exception ex){
            thrown = true;
        }
        assertTrue(thrown);
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
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));

        //Ilegal move out of bounds
        targetCoords.x = 6;
        targetCoords.y = -1;
        assertFalse(settlerFigure.isLegalMove(CGame.GameLayout.GetAt(targetCoords)));
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

        CFigurine settler = CGame.GameLayout.GetAt(new TPoint(6, 2)).getM_figurine();


        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(4, 4))));
        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(2, 2))));
        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(0, 4))));


        settler = CGame.GameLayout.GetAt(new TPoint(6, 4)).getM_figurine();

        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(4, 2))));
        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(2, 4))));
        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(0, 2))));

        field = CGame.GameLayout.GetAt(new TPoint(5, 4));
        field.setM_figurine(new CSettlerFigurine(field));
        field = CGame.GameLayout.GetAt(new TPoint(4, 3));
        field.setM_figurine(new CIndianFigurine(field));
        CGame.GameLayout.GetAt(new TPoint(3, 2)).setM_figurine(null);

        settler = CGame.GameLayout.GetAt(new TPoint(5, 4)).getM_figurine();

        assertTrue(settler.isLegalMove(CGame.GameLayout.GetAt(new TPoint(3, 2))));

    }

*/
}