import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonEndTurn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ButtonEndTurn extends Actor {
    /**
     * Act - do whatever the ButtonEndTurn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            try {
                CGame.EndTurn();
            } catch (Exception e) {
                if (e == null || e.getMessage() == null) {
                    CGeneralHelper.ShowDialog(DataTypes.TDialogType.Error, "Neočekávaná vyjímka");
                } else {
                    CGeneralHelper.ShowDialog(DataTypes.TDialogType.Error, e.getMessage());
                }
                //TODO Warning!
            }
        }
    }
}
