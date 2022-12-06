package states;

import ScreenLoader.ScreenLoader;
import base.Application;
import base.Position;
import controller.Controller;
import drawer.Drawer;

import java.io.IOException;

public abstract class State<T> {
    protected final T context;
    protected final Controller<T> controller;
    protected final Drawer<T> drawer;
    public State(T context){
        this.context=context;
        this.controller = getController();
        this.drawer = getDrawer();
    }

    public T getContext() {
        return context;
    }
    public abstract Controller<T> getController();
    public abstract Drawer<T> getDrawer();

    public void step(Application application, ScreenLoader screen, long time) {
        Position mousePressed = screen.getMousePressed();
        controller.step(application, mousePressed, time);
        try {
            drawer.draw(screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
