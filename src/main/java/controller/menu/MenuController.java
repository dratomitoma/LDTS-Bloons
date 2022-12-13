package controller.menu;

import base.Application;
import base.Play;
import base.Position;
import controller.Controller;
import model.menu.Menu;
import states.GameState;

import java.awt.event.KeyEvent;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu){
        super(menu);
    }
    @Override
    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time){
        if (mousePressed.isBetween(new Position(69*4, 73*4), new Position(186*4, 107*4))){
            application.setState(new GameState(new Play()));
        }
        else if(mousePressed.isBetween(new Position(373,453), new Position(653,553)) || keyPressed == KeyEvent.VK_ESCAPE){
            application.setState(null);
        }
    }
}
