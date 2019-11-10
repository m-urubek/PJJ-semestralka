package Classes;

import DataTypes.TPoint;
import org.junit.Test;

import static org.junit.Assert.*;

public class CGameLayoutTest {

    @Test
    public void testMoveIndian() {
        CGameLayout testBoard = new CGameLayout();
        CGameLayout controlBoard = new CGameLayout();

        //Legal horizontal move
        TPoint sourceCoords = new TPoint(3,3);
        TPoint targetCoords = new TPoint(4,3);
        testBoard.Move(sourceCoords, targetCoords);
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Legal vertical move
        sourceCoords = new TPoint(4,3);
        targetCoords = new TPoint(4,4);
        testBoard.Move(sourceCoords, targetCoords);
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Legal vertical move
        sourceCoords = new TPoint(4,4);
        targetCoords = new TPoint(4,3);
        testBoard.Move(sourceCoords, targetCoords);
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal backward move
        sourceCoords = new TPoint(4,3);
        targetCoords = new TPoint(3,3);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal diagonal move
        sourceCoords = new TPoint(4,3);
        targetCoords = new TPoint(4,4);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal too far away move
        sourceCoords = new TPoint(4,3);
        targetCoords = new TPoint(4,6);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal move to occupied field
        sourceCoords = new TPoint(3,0);
        targetCoords = new TPoint(3,1);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(3,0);
        targetCoords = new TPoint(3,-1);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(3,6);
        targetCoords = new TPoint(3,7);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(0,2);
        targetCoords = new TPoint(0,1);
        testBoard.Move(sourceCoords, targetCoords);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard,controlBoard));
    }

    @Test
    public void testMoveSettler() {

    }
}