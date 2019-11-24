package Classes;

import DataTypes.TIntResult;
import DataTypes.TPoint;

public class CGeneralHelper {

    public static TPoint indexToCoords (int index) {
        //DONE - TODO Review!
        switch(index) {
            case 0:
                // code block
                break;
            case 1:
                // code block
                break;
            default:
                // code block
        }
    }

    public static TIntResult coordsToIndex (TPoint coords) {
        //DONE

        int value = -1;

        //prvni radek
        if (coords.x == 0 && coords.y == 0)
            value = 0;
        if (coords.x == 0 && coords.y == 1)
            value = 1;
        if (coords.x == 0 && coords.y == 2)
            value = 2;

        //druhy radek
        if (coords.x == 1 && coords.y == 0)
            value = 3;
        if (coords.x == 1 && coords.y == 1)
            value = 4;
        if (coords.x == 1 && coords.y == 2)
            value = 5;

        //treti radek
        if (coords.x == 2 && coords.y == 0)
            value = 6;
        if (coords.x == 2 && coords.y == 1)
            value = 7;
        if (coords.x == 2 && coords.y == 2)
            value = 8;
        if (coords.x == 2 && coords.y == 3)
            value = 9;
        if (coords.x == 2 && coords.y == 4)
            value = 10;
        if (coords.x == 2 && coords.y == 5)
            value = 11;
        if (coords.x == 2 && coords.y == 6)
            value = 12;

        //ctvrty radek
        if (coords.x == 3 && coords.y == 0)
            value = 13;
        if (coords.x == 3 && coords.y == 1)
            value = 14;
        if (coords.x == 3 && coords.y == 2)
            value = 15;
        if (coords.x == 3 && coords.y == 3)
            value = 16;
        if (coords.x == 3 && coords.y == 4)
            value = 17;
        if (coords.x == 3 && coords.y == 5)
            value = 18;
        if (coords.x == 3 && coords.y == 6)
            value = 19;

        //paty radek
        if (coords.x == 4 && coords.y == 0)
            value = 20;
        if (coords.x == 4 && coords.y == 1)
            value = 21;
        if (coords.x == 4 && coords.y == 2)
            value = 22;
        if (coords.x == 4 && coords.y == 3)
            value = 23;
        if (coords.x == 4 && coords.y == 4)
            value = 24;
        if (coords.x == 4 && coords.y == 5)
            value = 25;
        if (coords.x == 4 && coords.y == 6)
            value = 26;

        //sesty radek
        if (coords.x == 5 && coords.y == 0)
            value = 27;
        if (coords.x == 5 && coords.y == 1)
            value = 28;
        if (coords.x == 5 && coords.y == 2)
            value = 29;

        //sedmy radek
        if (coords.x == 6 && coords.y == 0)
            value = 30;
        if (coords.x == 6 && coords.y == 1)
            value = 31;
        if (coords.x == 7 && coords.y == 2)
            value = 32;

        TIntResult result = new TIntResult();
        if (value == -1){
            result.message = "Coordinates were not entered correctly";
            result.success = false;
            return result;
        }
        result.value = value;
        result.success = true;
        return result;
    }

}
