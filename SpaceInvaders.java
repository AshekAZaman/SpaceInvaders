/*
This is a simple arcade game called Space Invaders! In the game, a swarm of aliens moves back-and-forth across
screen, moving down once the swarm has reached the end of the screen. The player, at the bottom, moves back-andforth, shooting the aliens.
The game is won if the player successfully shoots all the aliens. The game is lost if the aliens reach the bottom.
*/

import java.util.ArrayList;
public class SpaceInvaders{

//Variables to determine the size of the SpaceInvader    
private int invaderHeight;
private int invaderWidth;

//Variables for Sprite Objects
private ArrayList<Sprite> gameObjects;
private Ship playerShip;
private Bullet playerBullet1;
private Bullet playerBullet2;
private int alienSpeed;
private int alienHorizonal;
private int alienVertical;
private boolean moveRight;

//Variables for the Ship
private int shipX;
private int shipY;

//Variables to for the bullets in the screen
private int bulletCount;
private int bulletX;
private int bulletY;
private int bulletSpeed;

/*
Constructor to build the game, that plays in a screen that has the
size of the provided height and width.
*/
public SpaceInvaders(int height, int width){
    this.invaderHeight = height;
    this.invaderWidth = width;    
    gameObjects=new ArrayList<Sprite>();
    
    //Intialzing the ship
    shipX = invaderWidth/2;
    shipY = invaderHeight/2+invaderHeight/3;
    playerShip=new Ship(shipX,shipY);	
	gameObjects.add(playerShip);   

    bulletCount = 0;
    bulletSpeed = 2;
    alienSpeed = 1;
    alienHorizonal = 4;
    alienVertical = 5;
    moveRight = false;

    drawAliens();

}//SpaceInvaders

/*
Update is called 30 times per second to update the placement of all your items
*/
public void update(){
   moveBullets();
   moveAliens();
   collision();   
}//update

/*
Helper method for Collisions!
*/
private void collision(){
    for(int i = 0 ; i<gameObjects.size(); i++){
if(i<gameObjects.size()){
    if(gameObjects.get(i)!=null){
        if(gameObjects.get(i) instanceof Alien){
            if(!(gameObjects.get(i) instanceof Ship) && !(gameObjects.get(i) instanceof Bullet)){
            if(gameObjects.contains(playerBullet1)){
            checkCollision(playerBullet1,(Alien)gameObjects.get(i));
            }//if                     
        }//if
    }//if
}//if
    if(i<gameObjects.size()){
        if(gameObjects.get(i) instanceof Alien){
            if(!(gameObjects.get(i) instanceof Ship) && !(gameObjects.get(i) instanceof Bullet)){
            if(gameObjects.contains(playerBullet2)){
            checkCollision(playerBullet2,(Alien)gameObjects.get(i));
            }//if                        
        }//if
    }//if
}//if
}//if

    }//for

}//collision

/*
Helper method for collision()
*/
private void checkCollision(Bullet pBullet, Alien eAlien){
    if(pBullet != null){        
        int xLow, xHigh, yLow, yHigh;
        xLow = eAlien.getX()-(3*Display.ALIEN_SHAPE.length);
        xHigh = eAlien.getX()+(3*Display.ALIEN_SHAPE.length);
        yLow = eAlien.getY()+(2*Display.ALIEN_SHAPE.length);
        yHigh = eAlien.getY()-(2*Display.ALIEN_SHAPE.length);

        if(pBullet.getX()>xLow && pBullet.getX()<xHigh && pBullet.getY()>yHigh && pBullet.getY()<yLow){
            gameObjects.remove(pBullet);
            gameObjects.remove(eAlien);
            bulletCount--;
            
        }//if
    }//if
}//checkCollision

/*
Helper method to draw Aliens!
*/
private void drawAliens(){      
    
	for(int i = 0 ; i< alienHorizonal*(6*Display.ALIEN_SHAPE.length) ; i+=6*Display.ALIEN_SHAPE.length){
        for(int j = invaderHeight/15; j<alienVertical*(3*Display.ALIEN_SHAPE.length) ; j+=(3*Display.ALIEN_SHAPE.length)){
            gameObjects.add(new Alien(i,j));
        }           
    }

    
}//drawAliens

private void moveAliens(){
   
    for(int i = 0; i < gameObjects.size(); i++){     
        
    if(gameObjects.get(i)!=null){
        if(gameObjects.get(i) instanceof Alien){      

             if(gameObjects.get(i).getX() >invaderWidth - ((6*Display.ALIEN_SHAPE.length))){
                 moveRight = true;
                 int count = 0;
                 while(count < gameObjects.size()){
                    if(gameObjects.get(count)!=null  && gameObjects.get(count) instanceof Alien ){
                        gameObjects.set(count,new Alien(gameObjects.get(count).getX(),gameObjects.get(count).getY()+Display.ALIEN_SHAPE.length));
                    }
                 count++;
                 }
             }else if(gameObjects.get(i).getX() < 0){
                 moveRight = false;
                 int count = 0;
                 while(count < gameObjects.size()){
                    if(gameObjects.get(count)!=null  && gameObjects.get(count) instanceof Alien ){
                        gameObjects.set(count,new Alien(gameObjects.get(count).getX(),gameObjects.get(count).getY()+Display.ALIEN_SHAPE.length));
                    }
                 count++;
                 }
             }
            
            
             if(moveRight == true){
                int newPositionX = gameObjects.get(i).getX() - alienSpeed;  
                int newPostionY = gameObjects.get(i).getY() ;                
                gameObjects.set(i,new Alien(newPositionX,newPostionY));  
                }
            else{            
                int newPositionX = gameObjects.get(i).getX() + alienSpeed;  
                int newPostionY = gameObjects.get(i).getY();            
                gameObjects.set(i,new Alien(newPositionX,newPostionY));
            
    }
            
        }//if
    }//if
}//for

}//moveAliens



/*
 Helper method for moving the bullets!
*/
private void moveBullets(){
    if(gameObjects.contains(playerBullet1)){
       
        if(playerBullet1.getY()>0){
        int newBulletY = playerBullet1.getY()-bulletSpeed;
        gameObjects.remove(playerBullet1);
        playerBullet1 = new Bullet(playerBullet1.getX(),newBulletY);
        gameObjects.add(playerBullet1);
        }else{
        gameObjects.remove(playerBullet1);
        bulletCount--;
        }
    }

    if(gameObjects.contains(playerBullet2)){
       
        if(playerBullet2.getY()>0){
        int newBulletY=playerBullet2.getY()-bulletSpeed;
        gameObjects.remove(playerBullet2);
        playerBullet2 = new Bullet(playerBullet2.getX(),newBulletY);
        gameObjects.add(playerBullet2);
        }else{
        gameObjects.remove(playerBullet2);
        bulletCount--;
        }
    }

}


/*
This method returns an ArrayList of all the items that are to be drawn onto
the screen.
*/
public ArrayList<Sprite> getItems(){    
    return gameObjects;
}//getItems

/*
Returns the status of the game. This is used by the Display object. 
*/
public int status(){
    int status = Display.CONTINUE;
    int alienCount = 0;
    boolean shipWrecked = false;
    for(int i = 0; i < gameObjects.size(); i++){
        if(gameObjects.get(i) instanceof Alien){
            alienCount++;
            int xLow, xHigh, yLow, yHigh;
            xLow = gameObjects.get(i).getX()-(3*Display.ALIEN_SHAPE.length);
            xHigh = gameObjects.get(i).getX()+(3*Display.ALIEN_SHAPE.length);
            yLow = gameObjects.get(i).getY()+(3*Display.ALIEN_SHAPE.length);
            yHigh = gameObjects.get(i).getY()-(3*Display.ALIEN_SHAPE.length);
            if(playerShip.getX()>xLow && playerShip.getX()<xHigh && playerShip.getY()>yHigh && playerShip.getY()<yLow){
                shipWrecked = true;
            }//if
            
            
        }//if
    }//for
    
    if(alienCount == 0){
        status = Display.WIN;
    }//if

    if(shipWrecked){
        status = Display.LOSE;
    }//if

    return status;
}//status

/*
This method is called when the player presses the left or right arrows. If the
player presses the left arrow, direction is set to Display.MOVE_LEFT. If the player presses the right arrow,
direction is set to Display.MOVE_RIGHT.
*/
public void move(int direction){
  
    boolean moveAble = false;
    
    if(direction==Display.MOVE_RIGHT){ 
        if(shipX<invaderWidth-4*(playerShip.getColorGrid().length)){       
        this.shipX+=10;	
        moveAble=true;     
        }
	}else if(direction==Display.MOVE_LEFT){     
        if(shipX>(2*playerShip.getColorGrid().length)){  
		this.shipX-=10;	
        moveAble=true;	     
        }
	}

    if(moveAble){
    gameObjects.remove(playerShip);
    playerShip=new Ship(shipX,shipY);	
    gameObjects.add(playerShip);   
    }

}//move

/*
This method is called when the player presses the spacebar. When called, the player’s ship
checks if it can shoot a new bullet. They player is allowed to have a maximum of 2 bullets. 
*/
public void shoot(){    
    
    if(bulletCount < 2 ){
        this.bulletX = this.shipX;
        this.bulletY = this.shipY;
        if(gameObjects.contains(playerBullet1)){       
        playerBullet2 = new Bullet(bulletX,bulletY);
        gameObjects.add(playerBullet2);            
        }else{      
        playerBullet1 = new Bullet(bulletX,bulletY);
        gameObjects.add(playerBullet1);        
        }
        bulletCount++;
    }    

}//shoot



}//SpaceInvaders
