/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author antoniomejorado
 */
public class Game implements Runnable {
    private BufferStrategy bs;      // to have several buffers when displaying
    private Graphics g;             // to paint objects
    private Display display;        // to display in the game
    String title;                   // title of the window
    private int width;              // width of the window
    private int height;             // height of the window
    private Thread thread;          // thread to create the game
    private boolean running;        // to set the game
    private Player player;          // to use a player
    private KeyManager keyManager;  // to manage the keyboard
    private ArrayList<Enemy> enemy;
    private boolean gameOver;       //to stop the game
    //private ArrayList<Bullet> bullets;  //to store bullets
    private ArrayList<BulletEnemy> bulletsEnemy;
    private int contCol=0;
    private int vel=3;
    private int altura=0;
    private int numBullet = (int) (Math.random() * 60)+100;
    private int contBullets = 0;
    private int numEnemy = (int) (Math.random() * 44)+1;
    private int contEnemy = 0;
    private boolean shoot=false; 
    private int bullEnemyX;
    private int bullEnemyY;
    private Bullet bullet;  //to store bullets
    private ArrayList<Escudo> escudito;
    private EnemyBonus enemybonus;
    private int secsRandEnemyB = (int) (Math.random() * 1500);
    private int contEnemyBonus = 0;
    private int score = 0;
    private int vidas = 3;
    private int contDeadEnemys=1;
    public boolean avisar=false;
    private int vidaExtra=1000;
    //points
    private boolean points=false;
    private int contTiempPoints=0;
    private int numPoint;
    private int pointX;
    private int pointY;
    private int numBonus;
    //reaparecer enemys
    private int new_width_brick = this.getWidth() / 10 - 6;
    private int new_height_brick = this.getHeight() / 3 /5 - 10;
    //sonido
    private SoundClip fondo;
    private SoundClip disparo;
    private SoundClip lost;
    private SoundClip choque;
    
    /**
     * to create title, width and height and set the game is still not running
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height  to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.gameOver = false;
        running = false;
        keyManager = new KeyManager();
        fondo = new SoundClip("/images/fondoDB.wav");
        disparo = new SoundClip("/images/disparo.wav");
        lost = new SoundClip("/images/dragon-ball.wav");
        choque = new SoundClip("/images/choque.wav");
        fondo.setLooping(true);
        fondo.play();
    }

    /**
     * To get the width of the game window
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    
    public int getVel(){
        return vel;
    }
    
    public void setVel(int vel){
        this.vel=vel;
    }
    
    public int getAlt(){
        return altura;
    }
    
    public void setAlt(int alt){
        this.altura=alt;
    }
    
    public int getNumDead(){
        return contDeadEnemys;
    }
    public void setNumDead(int num){
        contDeadEnemys=num;
    }



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Enemy> getEnemy() {
        return enemy;
    }

    public void setEnemy(ArrayList<Enemy> enemy) {
        this.enemy = enemy;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ArrayList<BulletEnemy> getBulletsEnemy() {
        return bulletsEnemy;
    }

    public void setBulletsEnemy(ArrayList<BulletEnemy> bulletsEnemy) {
        this.bulletsEnemy = bulletsEnemy;
    }

    public int getContCol() {
        return contCol;
    }

    public void setContCol(int contCol) {
        this.contCol = contCol;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumBullet() {
        return numBullet;
    }

    public void setNumBullet(int numBullet) {
        this.numBullet = numBullet;
    }

    public int getContBullets() {
        return contBullets;
    }

    public void setContBullets(int contBullets) {
        this.contBullets = contBullets;
    }

    public int getNumEnemy() {
        return numEnemy;
    }

    public void setNumEnemy(int numEnemy) {
        this.numEnemy = numEnemy;
    }

    public int getContEnemy() {
        return contEnemy;
    }

    public void setContEnemy(int contEnemy) {
        this.contEnemy = contEnemy;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public int getBullEnemyX() {
        return bullEnemyX;
    }

    public void setBullEnemyX(int bullEnemyX) {
        this.bullEnemyX = bullEnemyX;
    }

    public int getBullEnemyY() {
        return bullEnemyY;
    }

    public void setBullEnemyY(int bullEnemyY) {
        this.bullEnemyY = bullEnemyY;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public ArrayList<Escudo> getEscudito() {
        return escudito;
    }

    public void setEscudito(ArrayList<Escudo> escudito) {
        this.escudito = escudito;
    }

    public EnemyBonus getEnemybonus() {
        return enemybonus;
    }

    public void setEnemybonus(EnemyBonus enemybonus) {
        this.enemybonus = enemybonus;
    }

    public int getSecsRandEnemyB() {
        return secsRandEnemyB;
    }

    public void setSecsRandEnemyB(int secsRandEnemyB) {
        this.secsRandEnemyB = secsRandEnemyB;
    }

    public int getContEnemyBonus() {
        return contEnemyBonus;
    }

    public void setContEnemyBonus(int contEnemyBonus) {
        this.contEnemyBonus = contEnemyBonus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getContDeadEnemys() {
        return contDeadEnemys;
    }

    public void setContDeadEnemys(int contDeadEnemys) {
        this.contDeadEnemys = contDeadEnemys;
    }

    public boolean isAvisar() {
        return avisar;
    }

    public void setAvisar(boolean avisar) {
        this.avisar = avisar;
    }

    public int getVidaExtra() {
        return vidaExtra;
    }

    public void setVidaExtra(int vidaExtra) {
        this.vidaExtra = vidaExtra;
    }

    public boolean isPoints() {
        return points;
    }

    public void setPoints(boolean points) {
        this.points = points;
    }

    public int getContTiempPoints() {
        return contTiempPoints;
    }

    public void setContTiempPoints(int contTiempPoints) {
        this.contTiempPoints = contTiempPoints;
    }

    public int getNumPoint() {
        return numPoint;
    }

    public void setNumPoint(int numPoint) {
        this.numPoint = numPoint;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getNew_width_brick() {
        return new_width_brick;
    }

    public void setNew_width_brick(int new_width_brick) {
        this.new_width_brick = new_width_brick;
    }

    public int getNew_height_brick() {
        return new_height_brick;
    }

    public void setNew_height_brick(int new_height_brick) {
        this.new_height_brick = new_height_brick;
    }

    public SoundClip getFondo() {
        return fondo;
    }

    public void setFondo(SoundClip fondo) {
        this.fondo = fondo;
    }

    public SoundClip getDisparo() {
        return disparo;
    }

    public void setDisparo(SoundClip disparo) {
        this.disparo = disparo;
    }

    public int getNumBonus() {
        return numBonus;
    }

    public void setNumBonus(int numBonus) {
        this.numBonus = numBonus;
    }
    
    
    
    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());  
        Assets.init();
        player = new Player(300, getHeight() - 100, 1, 100, 100, this);
        
         
        enemybonus = null;
         
        enemy = new ArrayList<Enemy>();
        new_width_brick = getWidth() / 10 - 6;
        new_height_brick = getHeight() / 3 /5 - 10;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 5; j++){
                enemy.add(new Enemy(i * (new_width_brick - 10) + 120, j * (new_height_brick + 15) + 95,30,40,1,((int) (Math.random() * 3) + 1),this));
            }
        }         
         
        escudito = new ArrayList<Escudo>();
         
        int simon = getWidth() / 8;
         
        for( int  y = 0 ; y < 8 ; y += 2 ){
            for ( int i = simon / 2 + (y * simon) , j = 0; i < ((simon / 2) + (y * simon)) + simon  ; i += 25 , j++ ){
                escudito.add(new Escudo(i,getHeight() - 200,25,25,1,this));
                if( j == 0 || j == 3){
                    escudito.add(new Escudo(i,getHeight() - 175,25,25,1,this));
                }
            }
        }                
          
        bullet = null;
        bulletsEnemy = new ArrayList<BulletEnemy>();
        display.getJframe().addKeyListener(keyManager);
    }
    
    @Override
    public void run() {
        init();
        // frames per second
        int fps = 50;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running && !gameOver) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;
            
            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta --;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    private void tick() {
        keyManager.tick();
        
        // para cuando se halla perdido
        if(vidas<=0){
            fondo.stop();
        }
        
        // para salvar el juego
        if(getKeyManager().pausa && getKeyManager().save){
            System.out.println("simon we");
            Files.saveFile(this);
            
        }
        
        //para cagar el juego
        if(getKeyManager().pausa && getKeyManager().load){
            System.out.println("simon we");
            Files.loadFile(this);            
        }
        
        // para resetear el juego
        if(vidas <= 0 && getKeyManager().reset ){
            fondo.play();
            enemy.clear();
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 5; j++){
                    enemy.add(new Enemy(i * (new_width_brick - 10) + 120, j * (new_height_brick + 15) + 95,30,40,1,((int) (Math.random() * 3) + 1),this));
                }
            }
            vel=3;
            score=0;
            vidas = 3;
            contDeadEnemys=1;
            escudito.clear();
            int simon = getWidth() / 8;
         
            for( int  y = 0 ; y < 8 ; y += 2 ){
                for ( int i = simon / 2 + (y * simon) , j = 0; i < ((simon / 2) + (y * simon)) + simon  ; i += 25 , j++ ){
                    escudito.add(new Escudo(i,getHeight() - 200,25,25,1,this));
                    if( j == 0 || j == 3){
                        escudito.add(new Escudo(i,getHeight() - 175,25,25,1,this));
                    }
                }
            }
        }
        
        //tickts de todo cuando no hay pausa y se tienen vidas aun
        if(!getKeyManager().pausa && vidas > 0 ){
        // avancing player with colision
            player.tick();


            //tickear bullet cuando sea necesario
            if( bullet != null)
                bullet.tick();

            // iterar enemigos
            Iterator itr = enemy.iterator();
            while(itr.hasNext()){
                Enemy enemys=(Enemy) itr.next();

                //gameover
                if(player.intersects(enemys)){
                    gameOver=true;
                }  

                //para control de direccion de los enemigos
                if(contCol==0 && enemys.getX()+enemys.getWidth() >= 800 && enemys.getX()+enemys.getWidth() <= 800+vel){
                    this.vel=this.vel*-1;
                    this.altura=20;
                    contCol++;
                }

                //control lado izquierdo
                if(contCol==0 && enemys.getX()<=0){
                    this.vel=this.vel*-1;
                    this.altura=20;
                    contCol++;
                }

                // si ya se puede hacer un disparo buscar el enemigo que lo va a spawnear
                if(shoot){
                    if(contEnemy==numEnemy){
                        bullEnemyX = enemys.getX()+(enemys.getWidth()/2);
                        bullEnemyY = enemys.getY()+enemys.getHeight();
                        bulletsEnemy.add(new BulletEnemy(bullEnemyX,bullEnemyY,9,9,this));
                        shoot=false;
                        contEnemy=0;
                        numEnemy=(int) (Math.random() * enemy.size())+1;
                    }
                    else{
                        contEnemy++; 
                    }
                }     

                //colision bala de player con enemigos
                if( bullet != null && bullet.intersects(enemys) ){
                    bullet = null;
                    pointX=enemys.getX();
                    pointY=enemys.getY()+enemys.getHeight();
                    numPoint=enemys.getRank();
                    points=true;
                    enemy.remove(enemys);
                    contDeadEnemys++;
                    itr = enemy.iterator();
                    score += enemys.getRank() * 10;
                    
                    // para vidas extra
                    if(score>=vidaExtra){
                        vidaExtra=vidaExtra+1000;
                        if(vidas<3){
                            vidas++;
                        }
                    }
                }
                
                //gameover
                if(enemys.getY()>=510){
                    vidas=0;
                }

            }

            //control de tickts para movimiento
            if(contDeadEnemys%9 == 0){
                avisar=true;
            }


            // tickear enemigos
            itr = enemy.iterator();
            while(itr.hasNext()){
                Enemy enemy=(Enemy) itr.next();
                    enemy.tick();

                    //aumentar velocidad 
                    if(enemy.getNumTicks()<=0){
                        enemy.setNumTicks(30);
                        if(!itr.hasNext()){
                            if(vel>0){
                                vel=vel+5;
                            }
                            else{
                                vel=vel-5;
                            }
                        }
                    }
            }

            //control de variable
            if(avisar){
                contDeadEnemys++;
                avisar=false;
            }



            altura=0;
            contCol=0;

            // iterar sobre arreglo de balas de enemigo
            itr = bulletsEnemy.iterator();
            while(itr.hasNext()){
                BulletEnemy bulletEnemys=(BulletEnemy) itr.next();
                bulletEnemys.tick();

                //checar colision entre bala enemigo y escudos
                Iterator itr2 = escudito.iterator();
                while(itr2.hasNext()){
                    Escudo escudo = (Escudo) itr2.next();
                    
                    //collision bullets enemigo con escuditos
                    if(bulletEnemys.intersects(escudo)){
                        bulletsEnemy.remove(bulletEnemys);
                        itr = bulletsEnemy.iterator();
                        escudo.setStage(escudo.getStage() + 1);
                        
                        // ver si escudo ya tiene que ser destruido
                        if(escudo.getStage() >= 7){
                            escudito.remove(escudo);
                            itr2 = escudito.iterator();
                        }
                    }  
                }   

                //colision player con los bulets del enemigo
                if(player.intersects(bulletEnemys)){
                    choque.play();
                    bulletsEnemy.remove(bulletEnemys);
                    player.setX(getWidth()/2 - player.getWidth()/2 );
                    itr = bulletsEnemy.iterator();
                    vidas--;
                }

                //eliminar la bala cuando llega hasta abajo
                if(bulletEnemys.getY() >= getHeight()){
                    bulletsEnemy.remove(bulletEnemys);
                    itr = bulletsEnemy.iterator();
                }
            }

            //control de tiempo entre bala de enemigos
            if(contBullets>=numBullet){
                shoot=true;
                contBullets=0;
                numBullet = (int) (Math.random() * 60)+100;
            }
            else{
                contBullets++;
            }


            //disparo player
            if(this.getKeyManager().space && bullet == null){
                //bullet = null;
                bullet = new Bullet(player.getX() + (player.getWidth() / 2) - 10, player.getY()  ,10,10,this);
                disparo.play();
            }


            // para checar desmadre de escudos
            Iterator itre = escudito.iterator();
            while(itre.hasNext()){
                Escudo escudo = (Escudo) itre.next();
                
                //colision entre la bala del personaje y los escudos
                if(bullet != null && bullet.intersects(escudo)){
                    escudo.setStage(escudo.getStage() + 1);
                    
                    // para ver si el escudo ya se tiene que destruir
                    if(escudo.getStage() >= 7){
                        escudito.remove(escudo);
                        itre = escudito.iterator();
                    }
                    bullet = null;
                }
            }

            //eliminar bala techo arriba
            if( bullet != null && bullet.getY() + bullet.getHeight() <= 0 ){
                bullet = null;
            }

            //crear enemigo bonus si no hay uno activo
            if(enemybonus == null){
                contEnemyBonus++;
                
                //contador de cada cuanto sale el enemigo bonus
                if(contEnemyBonus == secsRandEnemyB){
                    //escoger el lado del que saldra 
                    if( (int) (Math.random() * 2) == 0){
                        enemybonus = new EnemyBonus(0,40,50,50,0,this);
                    }                
                    else{
                         enemybonus = new EnemyBonus(getWidth(),40,50,50,1,this);
                    }
                }
            }
            else{
                enemybonus.tick();
                //checar si ya se tiene que eliminar el bonus
                if((enemybonus.getSide() == 0 && enemybonus.getX() >= getWidth()) ||( enemybonus.getSide() == 1 && enemybonus.getX() <= 0) ){
                    enemybonus = null; 
                    secsRandEnemyB = (int) (Math.random() * 1500);
                    contEnemyBonus = 0;
                }            
                // checar colision enemigo bonus con bala
                if(bullet != null && bullet.intersects(enemybonus)){
                    bullet = null;
                    pointX=enemybonus.getX();
                    pointY=enemybonus.getY()+enemybonus.getHeight();
                    numPoint=4;
                    points=true;
                    System.out.println("numPoint="+numPoint);
                    enemybonus = null;
                    contEnemyBonus = 0;
                    secsRandEnemyB = (int) (Math.random() * 150);
                    numBonus=((int) (Math.random() * 6) + 1) * (50);
                    score += numBonus;
                }
            }
            
            // duracion de puntos en pantalla
            if(points){
                contTiempPoints++;
            }
            if(contTiempPoints>30){
                points=false;
                contTiempPoints=0;
            }

            // control de resetear enemigos
            if(contDeadEnemys>=51){
               for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 5; j++){
                        enemy.add(new Enemy(i * (new_width_brick - 10) + 120, j * (new_height_brick + 15) + 95,30,40,1,((int) (Math.random() * 3) + 1),this));
                    }
                } 
                contDeadEnemys=1;
            }

            System.out.println(contDeadEnemys);
        }
    }
    
    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
        */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        }
        else
        {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.background, 0, 0, width, height, null);
            player.render(g);
            
            Iterator itr = escudito.iterator();
            while(itr.hasNext()){
                Escudo escudit = (Escudo) itr.next();
                escudit.render(g);
            }
            
            itr = enemy.iterator();
            while(itr.hasNext()){
                Enemy enemy=(Enemy) itr.next();
                enemy.render(g);
            }
            
            itr = bulletsEnemy.iterator();
            while(itr.hasNext()){
                BulletEnemy bulletEnemy=(BulletEnemy) itr.next();
                bulletEnemy.render(g);
            }
            
            Font leter = new Font ("Snap ITC", 1, 25);
            g.setFont (leter);
            g.setColor(Color.WHITE);
            
            if(getKeyManager().pausa){
               g.drawImage(Assets.pause, 0, 0, 800, 700, null);
               g.drawString ("Press 'S' to save",100 , 530);
               g.drawString ("Press 'L' to loading",450 , 530);
            }
            
            
            g.drawString ("Vidas",480 , 30);
            g.drawString ("Score="+score,280 , 30);
            
            if(points){
               if(numPoint==1){
                   g.drawString ("10",pointX , pointY);
               }else if(numPoint==2){
                   g.drawString ("20",pointX , pointY);
               }else if(numPoint==3){
                   g.drawString ("30",pointX , pointY);
               }else if(numPoint==4){
                   g.drawString (""+numBonus,pointX , pointY);
               }
            }
            
            if(vidas==3){
                g.drawImage(Assets.player, 570, 10, 60, 30, null);
                g.drawImage(Assets.player, 640, 10, 60, 30, null);
                g.drawImage(Assets.player, 720, 10, 60, 30, null);
            }else if(vidas==2){
                g.drawImage(Assets.player, 570, 10, 60, 30, null);
                g.drawImage(Assets.player, 640, 10, 60, 30, null);
            }else if(vidas==1){
                g.drawImage(Assets.player, 570, 10, 60, 30, null);
            }
            
            // render bullet si se ocupa
            if(bullet != null) 
                bullet.render(g);
            
            //render enemy bonus
            if(enemybonus != null )
                enemybonus.render(g);
            
            if(vidas<=0){
                g.drawImage(Assets.gameOver, 0, 0, 800, 700, null);
                g.drawString ("Score="+score,330 , 50);
                g.drawString ("Press 'R' to reset the game",200 , 600);
            }
            
            bs.show();
            g.dispose();
        }
       
    }
    
    /**
     * setting the thead for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }           
        }
    }

    
    public Bullet crearBala(int x, int y, int width, int height){
        
        return new Bullet(x,y,width,height,this);
    } 
    public EnemyBonus crearBonus(int x,int y,int width , int height, int side ){
        return new EnemyBonus(x,y,width,height,side,this);
    }

}
