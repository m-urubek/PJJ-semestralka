import DataTypes.TDialogType;
import greenfoot.*;

import DataTypes.TCurrentPlayerTurn;
import DataTypes.TPoint;
import DataTypes.TState;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CGame extends World {
    public static CGame instance = null;

    public static World world;
    public static CGameLayout GameLayout;
    public static TCurrentPlayerTurn CurrentPlayerTurn;
    public static List<CIndianFigurine> IndianFigurines;
    public static List<CSettlerFigurine> SettlerFigurines;
    public static TState PlayerState;
    public static CurrentPlayer currentPlayerGame;

    public CGame() {
        super(991, 687, 1);
        instance = this;
        world = this;
        IndianFigurines = new ArrayList<CIndianFigurine>();
        SettlerFigurines = new ArrayList<CSettlerFigurine>();

        setBackground(new GreenfootImage("background.png"));
        addObject(new ButtonNewGame(), 92, 46);
        addObject(new ButtonEndTurn(), 900, 46);
        addObject(new ButtonEndGame(), 900, 641);
        addObject(new ButtonSaveGame(), 92, 549);
        addObject(new ButtonLoadGame(), 92, 641);
        currentPlayerGame = new CurrentPlayer();
        addObject(currentPlayerGame, 404, 46);

        try {
            NewGame();
        } catch (Exception e) {
            addObject(new MessageDialog(DataTypes.TDialogType.Error, e.getMessage(), this.getWidth(), this.getHeight()), this.getWidth() / 2, this.getHeight() / 2);
        }
    }


    public static void NewGame() throws Exception {
        CurrentPlayerTurn = TCurrentPlayerTurn.Indian;
        PlayerState = TState.NotMoved;
        GameLayout = new CGameLayout();
        currentPlayerGame.setImage(new GreenfootImage("current_player_indian.png"));
    }

    public static void EndGame() {
        Greenfoot.stop();
        System.exit(0);
    }

    public static void SaveGame() {
        String toSave = "";
        if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian) {
            toSave += "S";
        } else {
            toSave += "I";
        }

        if (CGame.PlayerState == TState.NotMoved) {
            toSave += "N";
        } else if (CGame.PlayerState == TState.KilledSomeone) {
            toSave += "C";
        } else {
            toSave += "M";
        }

        if (CGame.GameLayout.getM_currentlySelectedFigurine() == null) {
            toSave += "EE";
        } else {
            toSave = toSave + CGame.GameLayout.getM_currentlySelectedFigurine().m_field.getM_x() + CGame.GameLayout.getM_currentlySelectedFigurine().m_field.getM_y();
        }

        toSave += CGame.GameLayout.SaveGame();

        try {
            FileOutputStream outputStream = new FileOutputStream("Save.txt");

            outputStream.write(toSave.getBytes());

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LoadGame() {

        try {
            NewGame();
            File file = new File("Save.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String toLoad;
            if ((toLoad = br.readLine()) == null || toLoad.length() != 37) {
                throw new IOException("");
            }

            switch (toLoad.charAt(0)) {
                case 'I':
                    CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Indian;
                    break;
                case 'S':
                    CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Settler;
                    break;
                default:
                    throw new IOException("");
            }

            switch (toLoad.charAt(1)) {
                case 'N':
                    CGame.PlayerState = TState.NotMoved;
                    break;
                case 'C':
                    CGame.PlayerState = TState.KilledSomeone;
                    break;
                case 'M':
                    CGame.PlayerState = TState.Moved;
                    break;
                default:
                    throw new IOException("");
            }
            TPoint selectedCoords = new TPoint(-1, -1);
            if (toLoad.charAt(2) != 'E') {
                selectedCoords.x = toLoad.charAt(2) - '0';
            }
            if (toLoad.charAt(3) != 'E') {
                selectedCoords.y = toLoad.charAt(3) - '0';
            }

            for (int i = 4; i < toLoad.length(); i++) {
                CField field = CGame.GameLayout.GetAt(CGeneralHelper.indexToCoords(i - 4));
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

    private static void testForRemainingKillsAndRemove(CSettlerFigurine currentFigurine) {
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y());
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y());
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() + 2);
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x(), currentFigurine.m_field.getM_y() - 2);
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() + 2);
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() + 2, currentFigurine.m_field.getM_y() - 2);
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() - 2);
        testRemainingKillAndRemove(currentFigurine, currentFigurine.m_field.getM_x() - 2, currentFigurine.m_field.getM_y() + 2);
    }

    private static void testRemainingKillAndRemove(CSettlerFigurine currentFigurine, int x, int y) {
        if (currentFigurine == null) {
            return;
        }

        TPoint point = new TPoint(x, y);
        CField field = null;
        try {
            field = CGame.GameLayout.GetAt(point);
        } catch (Exception ex) {
            return;
        }
        if (currentFigurine.isLegalMove(field)) {
            System.out.println("kill settler");
            CGame.SettlerFigurines.remove(currentFigurine);
            CGame.instance.removeObject(currentFigurine);
            currentFigurine.m_field.setM_figurine(null);
        }

    }

    public static void EndTurn() throws Exception {
        //DONE
        if (CGame.PlayerState != TState.NotMoved) {
            if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Settler) {
                for (CSettlerFigurine figurine : CGame.SettlerFigurines) {
                    if (figurine == CGame.GameLayout.getM_currentlySelectedFigurine()) {
                        //neplati pro oznacenou figurku
                        continue;
                    }
                    testForRemainingKillsAndRemove(figurine);
                }
                if (CGame.PlayerState != TState.KilledSomeone) {
                    CSettlerFigurine currentlySelectedFigurine = (CSettlerFigurine) CGame.GameLayout.getM_currentlySelectedFigurine();
                    testForRemainingKillsAndRemove(currentlySelectedFigurine);
                }
            }

            System.out.println("DEBUG");
            if (CGame.CurrentPlayerTurn == TCurrentPlayerTurn.Indian) {
                CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Settler;
                currentPlayerGame.setImage(new GreenfootImage("current_player_settler.png"));
                world.addObject(new MessageDialog(TDialogType.RedEndedTurn, "Hráč Indiáni ukončil svůj tah. Na řadě je hráč Osadníci", world.getWidth(), world.getHeight()), world.getWidth() / 2, world.getHeight() / 2);
            } else {
                CGame.CurrentPlayerTurn = TCurrentPlayerTurn.Indian;
                currentPlayerGame.setImage(new GreenfootImage("current_player_indian.png"));
                world.addObject(new MessageDialog(TDialogType.BlueEndedTurn, "Hráč Osadníci ukončil svůj tah. Na řadě je hráč Indiáni", world.getWidth(), world.getHeight()), world.getWidth() / 2, world.getHeight() / 2);
            }
            CGame.PlayerState = TState.NotMoved;
        }
    }

}
