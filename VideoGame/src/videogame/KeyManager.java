/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author antoniomejorado
 */
public class KeyManager implements KeyListener {
    
    public boolean left;    // flag to move left the player
    public boolean right;   // flag to move right the player
    public boolean space;   //flag to shoot
    private boolean keys[];  // to store all the flags for every key
    public boolean pausa;
    public boolean save;
    public boolean load;
    public boolean reset;
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        
        if(e.getKeyCode() == KeyEvent.VK_P && keys[e.getKeyCode()]== true ){
            keys[e.getKeyCode()]= false ;
        }
        else{
            keys[e.getKeyCode()]=true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        if(e.getKeyCode() != KeyEvent.VK_SPACE && e.getKeyCode() != KeyEvent.VK_P ){
            keys[e.getKeyCode()]=false;
        }
    }
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space=keys[KeyEvent.VK_SPACE];
        keys[KeyEvent.VK_SPACE]=false;
        pausa = keys[KeyEvent.VK_P];
        save = keys[KeyEvent.VK_S];
        load = keys[KeyEvent.VK_L];
        reset = keys[KeyEvent.VK_R];
        
    }
}