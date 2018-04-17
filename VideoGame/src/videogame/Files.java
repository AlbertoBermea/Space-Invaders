/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ALBER
 */
public class Files {
    public static void saveFile(Game game){
        //define objects
        PrintWriter printWriter;
        try{
            //creating file object
            printWriter = new PrintWriter(new FileWriter("data.txt"));
            //Writting the game
            printWriter.println("" + game.getScore()+ "," + game.getVidas());
            printWriter.println("" + game.getPlayer().getX() + "," + game.getPlayer().getY() );
            printWriter.println("" + game.getEnemy().size());
            for(Enemy enemy : game.getEnemy()){
                printWriter.println("" + enemy.getX() + "," + enemy.getY() + "," + enemy.getVel() + "," + enemy.getRank() + "");
            }
            printWriter.println("" + game.getEscudito().size());
            for(Escudo escudo : game.getEscudito()){
                printWriter.println("" + escudo.getX() + "," + escudo.getY() + "," + escudo.getStage() + "");
            }
            printWriter.println("" + game.getBulletsEnemy().size());
            for(BulletEnemy bullete : game.getBulletsEnemy()){
                printWriter.println("" + bullete.getX() + "," + bullete.getY() + "");
            }
            if(game.getBullet() != null ){
                printWriter.println("Si hay bala");
                printWriter.println("" + game.getBullet().getX() + "" ); 
                printWriter.println("" + game.getBullet().getY() + "" );  
            }
            if(game.getEnemybonus() != null ){
                printWriter.println("Si enemy bonus");
                printWriter.println("" + game.getEnemybonus().getX() + "" );
                printWriter.println("" + game.getEnemybonus().getY() + "" );
                printWriter.println("" + game.getEnemybonus().getSide() + "" );
            }       
            
            //escribir en el documento todoas las variables de control
            printWriter.println("" + game.getContCol() + "");         
            printWriter.println("" + game.getAltura() + "");            
            printWriter.println("" + game.getNumBullet() + "");            
            printWriter.println("" + game.getContBullets() + "");            
            printWriter.println("" + game.getNumEnemy() + "");                        
            printWriter.println("" + game.getContEnemy() + "");          
            printWriter.println("" + game.isShoot() + "" );            
            printWriter.println("" + game.getBullEnemyX() + "" );            
            printWriter.println("" + game.getBullEnemyY() + "" );
            printWriter.println("" + game.getSecsRandEnemyB() + "" );            
            printWriter.println("" + game.getContEnemyBonus() + "" );
            printWriter.println("" + game.getContDeadEnemys() + "" );
            printWriter.println("" + game.isAvisar() + "" );
            printWriter.println("" + game.getVidaExtra() + "" );
            printWriter.println("" + game.isPoints()+ "" );
            printWriter.println("" + game.getContTiempPoints()+ "" );
            printWriter.println("" + game.getNumPoint() + "" );
            printWriter.println("" + game.getPointX() + "" );
            printWriter.println("" + game.getPointY() + "" );
            printWriter.println("" + game.getNumBonus() + "" );
            printWriter.println("" + game.getNew_width_brick() + "" );
            printWriter.println("" + game.getNew_height_brick() + "" );
        
            printWriter.close();
        } catch (IOException ioe){
            System.out.println("Se te lleno el pedo" + ioe.toString());
        }
    }
    public static void loadFile(Game game){
        BufferedReader bufferedReader;
        try {
            //open the file
            bufferedReader = new BufferedReader(new FileReader("data.txt"));
            //get the first line
            String line = bufferedReader.readLine();
            //getting every token from the line
            String[] tokens = line.split(",");
            //score y vidas
            game.setScore(Integer.parseInt(tokens[0]));
            game.setVidas(Integer.parseInt(tokens[1]));
            
            //getting the next line
            line = bufferedReader.readLine();
            //getting every token from the line
            tokens = line.split(",");
            
            //posicion del personaje
            game.getPlayer().setX(Integer.parseInt(tokens[0]));
            game.getPlayer().setY(Integer.parseInt(tokens[1]));
            
            //enemies
            int enemies = Integer.parseInt(bufferedReader.readLine());
            //clearing enemies
            game.getEnemy().clear();
            //adding enemies
            for (int i = 0; i < enemies; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                int velo = Integer.parseInt(tokens[2]);
                int rank = Integer.parseInt(tokens[3]);
                Enemy enemy = new Enemy(x,y,30,40,velo,rank,game);
                game.getEnemy().add(enemy);
            }
            
            //escudos
            int escuditos = Integer.parseInt(bufferedReader.readLine());
           
            game.getEscudito().clear();
            for (int i = 0; i < escuditos; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                int stage = Integer.parseInt(tokens[2]);
                Escudo esc = new Escudo(x,y,25,25,stage,game);
                game.getEscudito().add(esc);
            }
            
            //bullets enemy
            int bul = Integer.parseInt(bufferedReader.readLine());
            //clearing enemies
            game.getBulletsEnemy().clear();
            //adding enemies
            for (int i = 0; i < bul; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                BulletEnemy bol = new BulletEnemy(x,y,9,9,game);
                game.getBulletsEnemy().add(bol);
            }
            
            //getting the next line
            line = bufferedReader.readLine();
            
            //en caso de que hubiera un bala la creamos
            if( line.equals(new String ("Si hay bala"))){   
                game.setBullet(null);
                if(game.getBullet() == null){
                    int x = Integer.parseInt(bufferedReader.readLine());
                    int y = Integer.parseInt(bufferedReader.readLine());
                    game.setBullet(game.crearBala(x,y,10,10));
                }                    
                
                line = bufferedReader.readLine();
            }
            
            // en caso de que hubiera un bonus enemigo lo creamos
            if( line.equals(new String ("Si enemy bonus"))){   
                game.setEnemybonus(null);
                if(game.getEnemybonus() == null){
                    int x = Integer.parseInt(bufferedReader.readLine());
                    int y = Integer.parseInt(bufferedReader.readLine());
                    int side = Integer.parseInt(bufferedReader.readLine());
                    game.setEnemybonus(game.crearBonus(x,y,50,50,side));
                }
                line = bufferedReader.readLine();
            }
            
            // Pasar todos los parametro de control del juego
            game.setContCol(Integer.parseInt(line));
            game.setAltura(Integer.parseInt(bufferedReader.readLine()));
            game.setNumBullet(Integer.parseInt(bufferedReader.readLine()));
            game.setContBullets(Integer.parseInt(bufferedReader.readLine()));
            game.setNumEnemy(Integer.parseInt(bufferedReader.readLine()));
            game.setContEnemy(Integer.parseInt(bufferedReader.readLine()));            
            game.setShoot(Boolean.parseBoolean(bufferedReader.readLine()));
            game.setBullEnemyX(Integer.parseInt(bufferedReader.readLine()));
            game.setBullEnemyY(Integer.parseInt(bufferedReader.readLine()));
            game.setSecsRandEnemyB (Integer.parseInt(bufferedReader.readLine()));
            game.setContEnemyBonus(Integer.parseInt(bufferedReader.readLine()));
            game.setContDeadEnemys(Integer.parseInt(bufferedReader.readLine()));
            game.setAvisar(Boolean.parseBoolean(bufferedReader.readLine()));
            game.setVidaExtra(Integer.parseInt(bufferedReader.readLine()));
            game.setPoints(Boolean.parseBoolean(bufferedReader.readLine()));
            game.setContTiempPoints(Integer.parseInt(bufferedReader.readLine()));
            game.setNumPoint(Integer.parseInt(bufferedReader.readLine()));
            game.setPointX(Integer.parseInt(bufferedReader.readLine()));
            game.setPointY(Integer.parseInt(bufferedReader.readLine()));
            game.setNumBonus(Integer.parseInt(bufferedReader.readLine()));
            game.setNew_width_brick(Integer.parseInt(bufferedReader.readLine()));
            game.setNew_height_brick(Integer.parseInt(bufferedReader.readLine()));
          
            
            
        } catch (IOException ioe) {
            System.out.println("Juego no ha sido guardado " + ioe.toString());
        }        
    }
}