//source: https://www.greenfoot.org/topics/2673

import greenfoot.*;

public class ErrorDialog extends Actor
{
    GreenfootImage inner;

    public ErrorDialog(String text)
    {
        inner = new GreenfootImage(text, 100, Color.RED, new Color(0, 0, 0, 180));
    }

    // create a gameover image the size of the world
    public void addedToWorld(World world)
    {
        int wide = world.getWidth();
        int high = world.getHeight();
        GreenfootImage outer = new GreenfootImage(wide, high);
        int leftX = (wide - inner.getWidth())/2;
        int topY = (high - inner.getHeight())/2;
        outer.drawImage(inner, leftX, topY);
        setImage(outer);
    }

    // the following is optional
    // remove pop-up when clicked on
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
}