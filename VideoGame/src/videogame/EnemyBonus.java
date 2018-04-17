/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;

/**
 *
 * @author ALBER
 */
public class EnemyBonus extends Item{

    private Game game;
    private int side;
    
    public EnemyBonus(int x, int y, int width, int height,int side, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    

    

    @Override
    public void tick() {
        if( side == 0 )
            setX(getX() + 3);
        else
            setX(getX() - 3);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bonus, getX(), getY(), getWidth(), getHeight(), null);
    }
}
