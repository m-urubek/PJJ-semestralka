package Classes;

import DataTypes.TPoint;

public class CGeneralHelper {
    public static TPoint indexToCoords (int index) {
        //DONE - TODO Review!
        // x= index MOD 7; y= index DIV 7
        return new TPoint( index % CGame.BOARD_WIDTH, index/CGame.BOARD_WIDTH );
    }

    public static int coordsToIndex (TPoint coords) {
        //DONE - TODO Review!
        // index = x + y*7
        return coords.x + coords.y*CGame.BOARD_WIDTH;
    }
}
