package com.beta.mario;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas{
    public static final int WIDTH = 270; //초기 넓이 설정
    public static final int HEIGHT = WIDTH; //초기 높이 설정
    public static final int SCALE = 4;
    public static final String TITLE = "Mario";

    private Thread thread;
    private boolean running = false;

    public Game() {
        Dimension size = new Dimension(WIDTH,HEIGHT);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }


    public synchronized void start() {
        if(running) return;
        running = true;
        thread = new Thread();
        thread.start();

    }

    public synchronized void stop() {
        if(!running) return;
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run() {

    }



    public static void main(String[] args){
        Game game = new Game();
        JFrame frame = new JFrame(TITLE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}