package base;

import Monkey.Towers;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Play {
    private int width;
    private int height;
    private Player player;
    private int round;
    private List<Bloon> bloons;
    private List<Towers> towers;
    private Color[][] color = new Color[256][144];
    private TextGraphics graphics;
    private Screen screen;

    Play(int x, int y){
        width = x;
        height = y;

    }

    public List<Bloon> bloonSender(int round){
        List<Bloon> sending = new ArrayList<>();

        switch(round){
            case 1:{
                for(int i = 0; i < 14; i++) sending.add(new Bloon("red"));
                break;
            }
            case 2:{
                for(int i = 0; i<30; i++) sending.add(new Bloon("red"));
                break;
            }
            case 3:{
                for(int i = 0; i<20; i++) sending.add(new Bloon("red"));
                for(int i= 0; i<5;i++) sending.add(new Bloon("blue"));
                break;
            }
            case 4:{
                for(int i = 0; i<25;i++)sending.add(new Bloon("blue"));
                break;
            }
            case 5:{
                for(int i = 0; i<20; i++)sending.add(new Bloon("blue"));
                for(int i = 0; i<5; i++)sending.add(new Bloon("green"));
                break;
            }
            case 6:{
                for(int i = 0; i < 20; i++) sending.add(new Bloon("green"));
                break;
            }
            case 7:{
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 8:{
                for(int i = 0; i < 5; i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 30; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 9:{
                for(int i = 0; i < 40; i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 10:{
                for(int i = 0; i < 30; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 11:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("yellow"));
                break;
            }
            case 12:{
                for(int i = 0; i < 25; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 25; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 13:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("pink"));
                break;
            }
            case 14:{
                for(int i = 0; i < 50; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 50; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 5; i++) sending.add(new Bloon("hard"));
                break;
            }
            case 15:{
                for(int i = 0; i<10; i++) sending.add(new Bloon("red"));
                for(int i= 0; i<10;i++) sending.add(new Bloon("blue"));
                for(int i = 0; i < 10; i++) sending.add(new Bloon("green"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("yellow"));
                for(int i = 0; i < 15; i++) sending.add(new Bloon("pink"));
                for(int i = 0; i < 20; i++) sending.add(new Bloon("hard"));
                break;
            }
        }
        return sending;
    }
    public void draw(TextGraphics graphics, Screen screen) {
        this.graphics = graphics;
        this.screen = screen;
        System.out.println("fodase");

        URL resourceMap = getClass().getResource("/map.png");
        BufferedImage map;
        try {
            map = ImageIO.read(resourceMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0;i<256;i++){
            for(int j = 0;j<144;j++){
                color[i][j] = new Color(map.getRGB(i,j));
            }
        }

        TextColor pixelColor;
        for (int i=0;i<256;i++){
            for(int j=0;j<144;j++){
                pixelColor = new TextColor.RGB(color[i][j].getRed(),color[i][j].getGreen(),color[i][j].getBlue());
                screen.setCharacter(i,j,new TextCharacter(' ').withBackgroundColor(pixelColor));
            }
        }

    }
    public void startGame(){
        player = new Player();
        round = 1;
        bloons = bloonSender(round);
        //if click start round
        startRound();
    }

    public boolean isAlive(){
        if(player.getLives()>0) return true;
        return false;
    }

    public boolean hasRoundEnded(){
        if(bloons.isEmpty()){
            round++;
            return true;
        }
        return false;
    }

    public void startRound(){
        for(Bloon bloon : bloons){
            System.out.println("drawing bloon");
            bloon.draw(graphics, screen);
            try {
                screen.refresh();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            bloon.move();
            bloon.draw(graphics, screen);
            try {
                screen.refresh();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //need observer
        }
    }
/*
    public void popBloon(){
        for(Bloon bloon : bloons){
            for(Towers tower: towers) {
                if (bloon.getCoords() <= tower.getRadius()){
                    bloon.pop();
                    if(bloon.getLayers()==0){
                        bloons.remove(bloon);
                        break;
                    }
                }
            }
        }
    }
*/
}