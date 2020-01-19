package Classes;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;
import com.sun.media.jfxmedia.events.PlayerStateEvent;
import org.junit.Test;

import static org.junit.Assert.*;

public class CGameLayoutTest {
    @Test
    public void placeholderTest2() {
        assertTrue(true);
    }


    @Test
    public void testMoveIndian() throws Exception {
        CGame game = new CGame();
        CGameLayout controlBoard = new CGameLayout();
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));
        CGame.CurrentPlayerTurn= TCurrentPlayerTurn.Indian;


        //Legal horizontal move
        TPoint sourceCoords = new TPoint(3, 3);
        TPoint targetCoords = new TPoint(4, 3);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Legal vertical move
        sourceCoords = new TPoint(4, 3);
        targetCoords = new TPoint(4, 4);
        CGame.CurrentPlayerTurn= TCurrentPlayerTurn.Indian;
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));
/*
        //Legal vertical move
        sourceCoords = new TPoint(4, 4);
        targetCoords = new TPoint(4, 3);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal backward move
        sourceCoords = new TPoint(4, 3);
        targetCoords = new TPoint(3, 3);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal diagonal move
        sourceCoords = new TPoint(4, 3);
        targetCoords = new TPoint(4, 4);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal too far away move
        sourceCoords = new TPoint(4, 3);
        targetCoords = new TPoint(4, 6);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal move to occupied field
        sourceCoords = new TPoint(3, 0);
        targetCoords = new TPoint(3, 1);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(3, 0);
        targetCoords = new TPoint(3, -1);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(3, 6);
        targetCoords = new TPoint(3, 7);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(0, 2);
        targetCoords = new TPoint(0, 1);
        testBoard.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(testBoard, controlBoard));
        */
    }

    @Test
    public void testMoveSettler() throws Exception {
        CGame game = new CGame();
        CGameLayout controlBoard = new CGameLayout();
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));
        CGame.CurrentPlayerTurn= TCurrentPlayerTurn.Settler;


        //Legal horizontal move
        TPoint sourceCoords = new TPoint(6, 3);
        TPoint targetCoords = new TPoint(5, 3);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Legal vertical move
        sourceCoords = new TPoint(5, 3);
        targetCoords = new TPoint(5, 2);
        assertTrue(CGame.GameLayout.GetAt(sourceCoords).getM_figurine().isLegalMove(CGame.GameLayout.GetAt(targetCoords)));
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);

        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Legal vertical move
        sourceCoords = new TPoint(5, 2);
        targetCoords = new TPoint(5, 3);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Legal diagonal move
        sourceCoords = new TPoint(5, 3);
        targetCoords = new TPoint(4, 2);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Legal horizontal move
        sourceCoords = new TPoint(4, 2);
        targetCoords = new TPoint(5, 2);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Ilegal diagonal move
        sourceCoords = new TPoint(5, 2);
        targetCoords = new TPoint(4, 3);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Ilegal too far away move
        sourceCoords = new TPoint(6, 4);
        targetCoords = new TPoint(4, 4);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Ilegal out of bounds move
        sourceCoords = new TPoint(6, 4);
        targetCoords = new TPoint(6, 5);
        CGame.PlayerState = TState.NotMoved;
        boolean testOK = false;
        try {
            CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

        //Ilegal out of bounds move
        sourceCoords = new TPoint(6, 4);
        targetCoords = new TPoint(7, 4);
        CGame.PlayerState = TState.NotMoved;
        testOK = false;
        try {
            CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

        //Ilegal out of bounds move
        sourceCoords = new TPoint(6, 4);
        targetCoords = new TPoint(6, 5);
        CGame.PlayerState = TState.NotMoved;
        testOK = false;
        try {
            CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);

        //Legal vertical move
        sourceCoords = new TPoint(6, 4);
        targetCoords = new TPoint(6, 3);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        controlBoard.GetAt(targetCoords).setM_figurine(controlBoard.GetAt(sourceCoords).getM_figurine());
        controlBoard.GetAt(sourceCoords).setM_figurine(null);
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Ilegal move to occupied field
        sourceCoords = new TPoint(6, 3);
        targetCoords = new TPoint(6, 2);
        CGame.PlayerState = TState.NotMoved;
        CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        assertTrue(TestHelper.compareContentOfTwoGameLayouts(CGame.GameLayout, controlBoard));

        //Ilegal move with nonexistent figurine
        sourceCoords = new TPoint(5, 4);
        targetCoords = new TPoint(4, 4);
        CGame.PlayerState = TState.NotMoved;
        testOK = false;
        try {
            CGame.GameLayout.Move(CGame.GameLayout.GetAt(sourceCoords), CGame.GameLayout.GetAt(targetCoords));
        } catch (Exception e) {
            testOK = true;
        }
        assertTrue(testOK);
    }

}