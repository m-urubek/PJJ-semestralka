import greenfoot.*;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;
import greenfoot.World;

import java.io.*;
import java.util.List;

public class CGame extends World {
    public static CGameLayout GameLayout;
    public static TCurrentPlayerTurn CurrentPlayerTurn;
    public static List<CIndianFigurine> IndianFigurines;
    public static List<CSettlerFigurine> SettlerFigurines;
    public static TState PlayerState;

    public CGame() throws Exception {
        super(991,687,1);
        setBackground(new GreenfootImage("background.png"));
        addObject(new ButtonNewGame(), 92, 46);
        addObject(new ButtonEndTurn(), 900, 46);
        addObject(new ButtonEndGame(), 900, 641);

        if (GameLayout == null) {
            NewGame();
        }
    }

    public static void NewGame() throws Exception {
        if (GameLayout != null) {
            EndGame();
        }
        GameLayout = new CGameLayout();
    }

    public static void EndGame() {
        System.exit(0);
    }

    public void SaveGame() {
        String toSave = "";
        if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian) {
            toSave+="S";
        } else {
            toSave+="I";
        }

        if (CGame.PlayerState == TState.NotMoved) {
            toSave+="N";
        } else if (CGame.PlayerState == TState.CanOnlyKill) {
            toSave+="C";
        } else {
            toSave+="M";
        }

        if (CGame.GameLayout.getM_currentlySelectedFigurine() == null) {
            toSave+="EE";
        } else {
            toSave = toSave +CGame.GameLayout.getM_currentlySelectedFigurine().m_field.getM_x() + CGame.GameLayout.getM_currentlySelectedFigurine().m_field.getM_y();
        }

        toSave+=CGame.GameLayout.SaveGame();

        try {
            FileOutputStream outputStream = new FileOutputStream("Save.txt");

            outputStream.write(toSave.getBytes());

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadGame() {

        try {
            NewGame();
            File file = new File("Save.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String toLoad;
            if ((toLoad = br.readLine()) == null || toLoad.length()!=37) {
                throw new IOException("");
            }

            switch (toLoad.charAt(0)) {
                case 'I':
                    CGame.CurrentPlayerTurn=TCurrentPlayerTurn.Indian;
                    break;
                case 'S':
                    CGame.CurrentPlayerTurn=TCurrentPlayerTurn.Settler;
                    break;
                default:
                    throw new IOException("");
            }

            switch (toLoad.charAt(1)) {
                case 'N':
                    CGame.PlayerState=TState.NotMoved;
                    break;
                case 'C':
                    CGame.PlayerState=TState.CanOnlyKill;
                    break;
                case 'M':
                    CGame.PlayerState=TState.Moved;
                    break;
                default:
                    throw new IOException("");
            }
            TPoint selectedCoords = new TPoint(-1, -1);
            if (toLoad.charAt(2) != 'E') {
                selectedCoords.x = toLoad.charAt(2)-'0';
            }
            if (toLoad.charAt(3) != 'E') {
                selectedCoords.y = toLoad.charAt(3)-'0';
            }

            for (int i = 4; i<toLoad.length(); i++) {
                CField field = CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i-4));
                switch (toLoad.charAt(i)) {
                    case 'i':
                        field.setM_figurine(new CIndianFigurine(field));
                        break;
                    case 's':
                        field.setM_figurine(new CSettlerFigurine(field));
                        break;
                    case 'e':
                        field.setM_figurine(null);
                        break;
                    default:
                        throw new IOException("");
                }
            }

            if (selectedCoords.x >= 0 && selectedCoords.y >= 0) {
                CGame.GameLayout.setM_currentlySelectedFigurine(CGame.GameLayout.GetAt(selectedCoords).getM_figurine());
            } else {
                CGame.GameLayout.setM_currentlySelectedFigurine(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
            try {
                NewGame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void testremainingKillAndRemove(CSettlerFigurine currentFigurine, int x, int y) throws Exception{
        TPoint point = new TPoint(x, y);
        CField field = null;
        try {
            field = CGame.GameLayout.GetAt(point);
        } catch (Exception ex) {
            return;
        }
        if (currentFigurine.isLegalMove(field)) {
            CGame.SettlerFigurines.remove(currentFigurine);
            GameLayout.DeleteFieldContent(currentFigurine.m_field);
        }
    }

    public static void EndTurn() throws Exception{
        //DONE
        for (CSettlerFigurine currentFigurine : CGame.SettlerFigurines) {
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y());
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y());
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() + 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() + 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() - 2);
            testremainingKillAndRemove(currentFigurine,currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() + 2);
        }
        if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian) {
            CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Settler;
        } else {
            CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Indian;
        }
    }
}
