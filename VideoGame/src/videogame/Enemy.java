/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;

/**
 *
 * @author Rodrigo
 */
public class Enemy extends Item{

    private Game game;
    private int vel;
    private int rank;
    private Animar enemys1;
    private Animar enemys2;
    private Animar enemys3;
    private int contTicksVel=0;
    private int numTicksVel=30;
    
    public Enemy(int x, int y, int width, int height, int vel,int rank, Game game) {
        super(x, y, width, height);
        this.vel = vel;
        this.game = game;
        this.rank = rank;
        
        this.enemys1 = new Animar(Assets.enemy1, 600);
        this.enemys2 = new Animar(Assets.enemy2, 600);
        this.enemys3 = new Animar(Assets.enemy3, 600);
    }

    public int getVel(){
        return vel; 
    }
   
    public void setVel(int vel){
        this.vel=vel;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public int getNumTicks(){
        return numTicksVel;
    }
    
    public void setNumTicks(int numTicks){
        numTicksVel=numTicks;
    }
    
   

    @Override
    public void tick() {
        
        if(contTicksVel>=numTicksVel || game.avisar || game.getAlt()>0){
            
            if(game.getNumDead()%9 == 0){
                numTicksVel=numTicksVel-30;
                //game.setNumDead(game.getNumDead()+1);
            }
            
            setX(getX() + game.getVel());
            setY(getY() + game.getAlt());
            contTicksVel=0;
            
        }
        contTicksVel++;
        
      this.enemys1.tick();
      this.enemys2.tick();
      this.enemys3.tick();
        
    }

    @Override
    public void render(Graphics g) {
        if(rank == 1){
            g.drawImage(enemys1.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else if(rank == 2){
            g.drawImage(enemys2.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else{
            g.drawImage(enemys3.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}

