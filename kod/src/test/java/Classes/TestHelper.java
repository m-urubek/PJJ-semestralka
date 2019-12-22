package Classes;

import Classes.CGameLayout;
import DataTypes.TPoint;

public class TestHelper {

    public static boolean compareContentOfTwoGameLayouts(CGameLayout firstGameLayout, CGameLayout secondGameLayout) throws Exception{
        // true = they are the same
        // false = they are not the same

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if ((x < 3 && y > 2) || (x > 4 && y > 2)) {  // skip corners
                    continue;
                }

                if (firstGameLayout.GetAt(new TPoint(x, y)) != secondGameLayout.GetAt(new TPoint(x, y))) {
                    return false;
                }
            }
        }

        return true;
    }


}
