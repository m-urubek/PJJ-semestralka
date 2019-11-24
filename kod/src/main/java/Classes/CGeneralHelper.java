package Classes;

import DataTypes.TIntResult;
import DataTypes.TPoint;
import DataTypes.TPointResult;

public class CGeneralHelper {

    public static TPointResult indexToCoords(int index) {
        //DONE
        TPointResult result = new TPointResult();
        switch (index) {
            case 0:
                result.value = new TPoint(0, 0);
                break;
            case 1:
                result.value = new TPoint(0, 1);
                break;
            case 2:
                result.value = new TPoint(0, 2);
                break;
            case 3:
                result.value = new TPoint(1, 0);
                break;
            case 4:
                result.value = new TPoint(1, 1);
                break;
            case 5:
                result.value = new TPoint(1, 2);
                break;
            case 6:
                result.value = new TPoint(2, 0);
                break;
            case 7:
                result.value = new TPoint(2, 1);
                break;
            case 8:
                result.value = new TPoint(2, 2);
                break;
            case 9:
                result.value = new TPoint(2, 3);
                break;
            case 10:
                result.value = new TPoint(2, 4);
                break;
            case 11:
                result.value = new TPoint(2, 5);
                break;
            case 12:
                result.value = new TPoint(2, 6);
                break;
            case 13:
                result.value = new TPoint(3, 0);
                break;
            case 14:
                result.value = new TPoint(3, 1);
                break;
            case 15:
                result.value = new TPoint(3, 2);
                break;
            case 16:
                result.value = new TPoint(3, 3);
                break;
            case 17:
                result.value = new TPoint(3, 4);
                break;
            case 18:
                result.value = new TPoint(3, 5);
                break;
            case 19:
                result.value = new TPoint(3, 6);
                break;
            case 20:
                result.value = new TPoint(4, 0);
                break;
            case 21:
                result.value = new TPoint(4, 1);
                break;
            case 22:
                result.value = new TPoint(4, 2);
                break;
            case 23:
                result.value = new TPoint(4, 3);
                break;
            case 24:
                result.value = new TPoint(4, 4);
                break;
            case 25:
                result.value = new TPoint(4, 5);
                break;
            case 26:
                result.value = new TPoint(4, 6);
                break;
            case 27:
                result.value = new TPoint(5, 0);
                break;
            case 28:
                result.value = new TPoint(5, 1);
                break;
            case 29:
                result.value = new TPoint(5, 2);
                break;
            case 30:
                result.value = new TPoint(6, 0);
                break;
            case 31:
                result.value = new TPoint(6, 1);
                break;
            case 32:
                result.value = new TPoint(6, 2);
                break;
            default:
                result.success = false;
                result.message = "Entered index is out of bound";
                return result;
        }
        result.success = true;
        return result;
    }

    public static TIntResult coordsToIndex(TPoint coords) {
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
        if (value == -1) {
            result.message = "Coordinates were not entered correctly";
            result.success = false;
            return result;
        } else {
            result.value = value;
            result.success = true;
            return result;
        }
    }

}
