package com.Tiago27Cruz.hero;

import model.game.Towers.Upgrades;
import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

// antiga interface em vez de abstract class Towers -> se não for para usar podemos eliminar
// backup basicamente
// can be deleted

public interface Towers {
    public void setPosition(Position pos);
    public Position getPosition();
    public void draw(TextGraphics graphics);
    public int getRange();
    public int getValue();
    public int price();
    public Upgrades getUpgrades();
    public boolean upgradeLeft();
    public boolean upgradeRight();
    public int getRadius();
}
