import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonNewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonNewGame extends Actor
{
    /**
     * Act - do whatever the ButtonNewGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            try {
                CGame.NewGame();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO Warning!
            }
        }
    }
}
