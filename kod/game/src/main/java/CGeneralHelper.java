import DataTypes.TPoint;

public class CGeneralHelper {
    public static final int BOARD_WIDTH = 7;

    public static TPoint indexToCoords(int index) throws Exception {
        //DONE
        switch (index) {
            case 0:
                return new TPoint(2, 0);
            case 1:
                return new TPoint(3, 0);
            case 2:
                return new TPoint(4, 0);
            case 3:
                return new TPoint(2, 1);
            case 4:
                return new TPoint(3, 1);
            case 5:
                return new TPoint(4, 1);
            case 6:
                return new TPoint(0, 2);
            case 7:
                return new TPoint(1, 2);
            case 8:
                return new TPoint(2, 2);
            case 9:
                return new TPoint(3, 2);
            case 10:
                return new TPoint(4, 2);
            case 11:
                return new TPoint(5, 2);
            case 12:
                return new TPoint(6, 2);
            case 13:
                return new TPoint(0, 3);
            case 14:
                return new TPoint(1, 3);
            case 15:
                return new TPoint(2, 3);
            case 16:
                return new TPoint(3, 3);
            case 17:
                return new TPoint(4, 3);
            case 18:
                return new TPoint(5, 3);
            case 19:
                return new TPoint(6, 3);
            case 20:
                return new TPoint(0, 4);
            case 21:
                return new TPoint(1, 4);
            case 22:
                return new TPoint(2, 4);
            case 23:
                return new TPoint(3, 4);
            case 24:
                return new TPoint(4, 4);
            case 25:
                return new TPoint(5, 4);
            case 26:
                return new TPoint(6, 4);
            case 27:
                return new TPoint(2, 5);
            case 28:
                return new TPoint(3, 5);
            case 29:
                return new TPoint(4, 5);
            case 30:
                return new TPoint(2, 6);
            case 31:
                return new TPoint(3, 6);
            case 32:
                return new TPoint(4, 6);
        }
        throw new Exception("Entered index is out of bound");
    }

    public static TPoint indexToGameCoords(int index) throws Exception {
        //DONE
        switch (index) {
            case 0:
                return new TPoint(2, 0);
            case 1:
                return new TPoint(3, 0);
            case 2:
                return new TPoint(4, 0);
            case 3:
                return new TPoint(2, 1);
            case 4:
                return new TPoint(3, 1);
            case 5:
                return new TPoint(4, 1);
            case 6:
                return new TPoint(0, 2);
            case 7:
                return new TPoint(1, 2);
            case 8:
                return new TPoint(2, 2);
            case 9:
                return new TPoint(3, 2);
            case 10:
                return new TPoint(4, 2);
            case 11:
                return new TPoint(5, 2);
            case 12:
                return new TPoint(6, 2);
            case 13:
                return new TPoint(0, 3);
            case 14:
                return new TPoint(1, 3);
            case 15:
                return new TPoint(2, 3);
            case 16:
                return new TPoint(3, 3);
            case 17:
                return new TPoint(4, 3);
            case 18:
                return new TPoint(5, 3);
            case 19:
                return new TPoint(6, 3);
            case 20:
                return new TPoint(0, 4);
            case 21:
                return new TPoint(1, 4);
            case 22:
                return new TPoint(2, 4);
            case 23:
                return new TPoint(3, 4);
            case 24:
                return new TPoint(4, 4);
            case 25:
                return new TPoint(5, 4);
            case 26:
                return new TPoint(6, 4);
            case 27:
                return new TPoint(2, 5);
            case 28:
                return new TPoint(3, 5);
            case 29:
                return new TPoint(4, 5);
            case 30:
                return new TPoint(2, 6);
            case 31:
                return new TPoint(3, 6);
            case 32:
                return new TPoint(4, 6);
        }
        throw new Exception("Entered index is out of bound");
    }

    public static int coordsToIndex(TPoint coords) throws Exception {
        //DONE
        //prvni radek
        if (coords.x == 2 && coords.y == 0)
            return 0;
        if (coords.x == 3 && coords.y == 0)
            return 1;
        if (coords.x == 4 && coords.y == 0)
            return 2;

        //druhy radek
        if (coords.x == 2 && coords.y == 1)
            return 3;
        if (coords.x == 3 && coords.y == 1)
            return 4;
        if (coords.x == 4 && coords.y == 1)
            return 5;

        //treti radek
        if (coords.x == 0 && coords.y == 2)
            return 6;
        if (coords.x == 1 && coords.y == 2)
            return 7;
        if (coords.x == 2 && coords.y == 2)
            return 8;
        if (coords.x == 3 && coords.y == 2)
            return 9;
        if (coords.x == 4 && coords.y == 2)
            return 10;
        if (coords.x == 5 && coords.y == 2)
            return 11;
        if (coords.x == 6 && coords.y == 2)
            return 12;

        //ctvrty radek
        if (coords.x == 0 && coords.y == 3)
            return 13;
        if (coords.x == 1 && coords.y == 3)
            return 14;
        if (coords.x == 2 && coords.y == 3)
            return 15;
        if (coords.x == 3 && coords.y == 3)
            return 16;
        if (coords.x == 4 && coords.y == 3)
            return 17;
        if (coords.x == 5 && coords.y == 3)
            return 18;
        if (coords.x == 6 && coords.y == 3)
            return 19;

        //paty radek
        if (coords.x == 0 && coords.y == 4)
            return 20;
        if (coords.x == 1 && coords.y == 4)
            return 21;
        if (coords.x == 2 && coords.y == 4)
            return 22;
        if (coords.x == 3 && coords.y == 4)
            return 23;
        if (coords.x == 4 && coords.y == 4)
            return 24;
        if (coords.x == 5 && coords.y == 4)
            return 25;
        if (coords.x == 6 && coords.y == 4)
            return 26;

        //sesty radek
        if (coords.x == 2 && coords.y == 5)
            return 27;
        if (coords.x == 3 && coords.y == 5)
            return 28;
        if (coords.x == 4 && coords.y == 5)
            return 29;

        //sedmy radek
        if (coords.x == 2 && coords.y == 6)
            return 30;
        if (coords.x == 3 && coords.y == 6)
            return 31;
        if (coords.x == 4 && coords.y == 6)
            return 32;

        throw new Exception("Coordinates were not entered correctly");
    }

}
