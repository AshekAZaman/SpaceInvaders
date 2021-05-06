import java.awt.Color;

public class Bullet extends Sprite 
{
private int bulletX;
private int bulletY;
private Color[][] colorGrid;
    
	public static final Color [][] BULLET_SHAPE = 
		{
				{null,null,null,null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null,null,null,null},
				{null,null,null,null,null,Display.BLACK,null,null,null,null,null},
				{null,null,null,null,null,Display.BLACK,null,null,null,null,null},
				{null,null,null,null,null,Display.BLACK,null,null,null,null,null},
				{null,null,null,null,null,Display.BLACK,null,null,null,null,null},
				{null,null,null,null,null,null,null,null,null,null,null},
				{null,null,null,null,null,null,null,null,null,null,null},
				
				
		};
        
	public Bullet(int x, int y){
        bulletX=x;
		bulletY=y;
		colorGrid=BULLET_SHAPE;
	}//Constructor

    public int getX(){
		return bulletX;
	}//getX
	
	public int getY(){
		return bulletY;
	}//getY
	
	public Color[][] getColorGrid(){
		return this.colorGrid;
	}//getColorGrid


}//Bullet