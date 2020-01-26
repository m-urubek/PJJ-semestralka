//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

//addObject(new MessageDialog(TDialogType.Error, e.getMessage(), this.getWidth(), this.getHeight()), this.getWidth()/2, this.getHeight()/2);

import greenfoot.*;
import DataTypes.TDialogType;

public class MessageDialog extends Actor {
    GreenfootImage inner;
    int _width;
    int _height;

    private String insertNewLines(String string) {
        for (int i = 0; i < string.length(); i++){
            if (i%90==0){
                string = string.substring(0, i) + "\n" + string.substring(i, string.length());
                if (string.length()-1 != i){
                    i++;
                }
            }
        }
        return string;
    }

    public MessageDialog(TDialogType dialogType, String text, int width, int height) {
        _width = width;
        _height = height;
        if (dialogType == TDialogType.Error) {
            this.inner = new GreenfootImage(insertNewLines(text), 30, Color.RED, new Color(180, 0, 0, 180));
        }
        if (dialogType == TDialogType.PlayerWon) {
            this.inner = new GreenfootImage(text, 40, Color.RED, new Color(0, 0, 0, 180));
        }
        if (dialogType == TDialogType.RedEndedTurn) {
            this.inner = new GreenfootImage(text, 40, Color.BLUE, new Color(0, 0, 0, 180));
        }
        if (dialogType == TDialogType.BlueEndedTurn) {
            this.inner = new GreenfootImage(text, 40, Color.RED, new Color(0, 0, 0, 180));
        }
        // inner.scale(width, height);
    }

    public void addedToWorld(World world) {
        GreenfootImage outer = new GreenfootImage(_width, _height);
        int leftX = (_width - this.inner.getWidth()) / 2;
        int topY = (_height - this.inner.getHeight()) / 2;
        outer.drawImage(this.inner, leftX, topY);
        this.setImage(outer);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            this.getWorld().removeObject(this);
        }

    }
}
