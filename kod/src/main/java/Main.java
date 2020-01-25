import Classes.CGame;

public class Main {
    public static void main(String[] args) {

        try {
            CGame game = new CGame();
            game.SaveGame();
            game.LoadGame();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
