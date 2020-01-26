import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonSaveGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonSaveGame extends Actor
{
    /**
     * Act - do whatever the ButtonSaveGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            CGame.SaveGame();
        }
    }
}
