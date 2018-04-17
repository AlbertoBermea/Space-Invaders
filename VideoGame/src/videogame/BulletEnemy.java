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
public class BulletEnemy extends Item{

    private Game game;
    
    public BulletEnemy(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
    }

    @Override
    public void tick() {
        setY(getY()+ 3);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
       }
    
   
    
}
