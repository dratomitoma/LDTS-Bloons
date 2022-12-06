package controller.menu;

import base.Application;
import base.Play;
import base.Position;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
import controller.Controller;
import model.menu.Menu;
import states.GameState;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu){
        super(menu);
    }
    @Override
    public void step(Application application, Position mousePressed, long time){
        System.out.println("MenuController: " + mousePressed.getX() + ", " + mousePressed.getY());
        if (mousePressed.getX()>69*4 && mousePressed.getX()<186*4 && mousePressed.getY()>73*4 && mousePressed.getY()<107*4){
            System.out.println("Starting GameState");
            application.setState(new GameState(new Play()));
        }
        else if(mousePressed.getX() >= 373 && mousePressed.getX() <= 653 && mousePressed.getY() >= 453 && mousePressed.getY() <= 553){
            application.setState(null);
        }
    }
}