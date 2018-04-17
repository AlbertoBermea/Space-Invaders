/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage bonus;
    public static BufferedImage sprites;
    public static BufferedImage enemy1[];
    public static BufferedImage enemy2[];
    public static BufferedImage enemy3[];
    public static BufferedImage es1;
    public static BufferedImage es2;
    public static BufferedImage es3;
    public static BufferedImage es4;
    public static BufferedImage es5;
    public static BufferedImage es6;
    public static BufferedImage pause;
    public static BufferedImage gameOver;
    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/fondo-negro.jpg");
        player = ImageLoader.loadImage("/images/nave.png");
        bonus = ImageLoader.loadImage("/images/enemigo.png");
        pause = ImageLoader.loadImage("/images/pause.png");
        gameOver = ImageLoader.loadImage("/images/gameOverDB.jpg");
        sprites = ImageLoader.loadImage("/images/spritesDB.png");

    SpreadSheet spritesheet = new SpreadSheet(sprites);
    enemy1 = new BufferedImage[2];
    enemy2 = new BufferedImage[2];
    enemy3 = new BufferedImage[2];
    
    for(int i=0;i<2;i++){
        enemy1[i] = spritesheet.crop(i*39, 1, 39, 54);
        enemy2[i] = spritesheet.crop(i*39, 54, 39, 54);
        enemy3[i] = spritesheet.crop(i*39, 110, 39, 54);
    }
    
        es1 = ImageLoader.loadImage("/images/escudo s1.png");
        es2 = ImageLoader.loadImage("/images/escudo s2.png");
        es3 = ImageLoader.loadImage("/images/escudo s3.png");
        es4 = ImageLoader.loadImage("/images/escudo s4.png");
        es5 = ImageLoader.loadImage("/images/escudo s5.png");
        es6 = ImageLoader.loadImage("/images/escudo s6.png");
    }
    
}
