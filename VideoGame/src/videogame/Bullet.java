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
 * @author Rodrigo
 */
public class Bullet extends Item{

    private Game game;
    
    public Bullet(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
    }

    @Override
    public void tick() {
        setY(getY()- 5);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
       }
}