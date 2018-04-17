/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ALBER
 */
public class Escudo extends Item{

    private Game game;
    private int stage;
    
    public Escudo(int x, int y, int width, int height,int stage, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.stage = stage;
    }    

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if (stage == 1){
            g.drawImage(Assets.es1, getX(), getY(), getWidth(), getHeight(), null);
        }
        else if (stage == 2){
            g.drawImage(Assets.es2, getX(), getY(), getWidth(), getHeight(), null);
        }
        else if (stage == 3){
            g.drawImage(Assets.es3, getX(), getY(), getWidth(), getHeight(), null);
        }
        else if (stage == 4){
            g.drawImage(Assets.es4, getX(), getY(), getWidth(), getHeight(), null);
        }
        else if (stage == 5){
            g.drawImage(Assets.es5, getX(), getY(), getWidth(), getHeight(), null);
        }
        else {
            g.drawImage(Assets.es6, getX(), getY(), getWidth(), getHeight(), null);
        }
         
    }
}
