package Classes;

import Classes.CGameLayout;
import DataTypes.TPoint;

public class TestHelper {

    public static boolean compareContentOfTwoGameLayouts(CGameLayout firstGameLayout, CGameLayout secondGameLayout) throws Exception{
        // true = they are the same
        // false = they are not the same

        byte first, second;
        //System.out.println("----------------------");

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if ((x < 2 && y < 2) || (x < 2 && y > 4) || (x > 4 && y < 2) || (x > 4 && y > 4)) {  // skip corners
                    continue;
                }
                if (firstGameLayout.GetAt(new TPoint(x,y)).getM_figurine() == null) {
                    //First is empty
                    first = 0;
                } else if (firstGameLayout.GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine() != null) {
                    //First is indian
                    first = 1;
                } else {
                    //First is settler
                    first = 2;
                }
                if (secondGameLayout.GetAt(new TPoint(x,y)).getM_figurine() == null) {
                    //Second is empty
                    second = 0;
                } else if (secondGameLayout.GetAt(new TPoint(x,y)).getM_figurine().getIndianFigurine() != null) {
                    //Second is indian
                    second = 1;
                } else {
                    //Second is settler
                    second = 2;
                }
                //System.out.println("["+x+";"+y+"] = "+first+" - "+second);
                if (first != second) {
                    return false;
                }
            }
        }

        return true;
    }


}
