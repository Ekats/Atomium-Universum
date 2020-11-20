package main;

import engine.io.Input;
import engine.io.Window;
import org.lwjgl.glfw.GLFW;

public class Main implements Runnable{
    public Thread game;
    public Window window;
    public final int WIDTH = 1280, HEIGHT = 760;

    public void start(){
        game = new Thread(this, "game");
        game.start();
    }
    public void init(){
        System.out.println("Initializing Game.");
        window = new Window(WIDTH, HEIGHT, "Atoms");
        window.setBackgroundColor(0.0f, 0.0f, 0.0f);
        window.create();
    }
    public void run(){
        init();
        while (!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE))
        {
            update();
            render();
            if (Input.isKeyDown(GLFW.GLFW_KEY_F11)) window.setFullscreen(!window.isFullscreen());
        }
        window.destroy();
    }

    private void update(){
        window.update();
        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT))
            System.out.println("X: " + Input.getScrollX() + ", Y: " + Input.getScrollY());
    }

    private void render(){
        window.swapBuffers();
    }

    public static void main(String[] args){
        new Main().start();
    }
}
