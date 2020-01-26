import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonLoadGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonLoadGame extends Actor
{
    /**
     * Act - do whatever the ButtonLoadGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            try {
                CGame.LoadGame();
            } catch (Exception e) {
                e.printStackTrace();
                //TODO Warning!
            }
        }
    }
}
