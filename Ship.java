import java.awt.Color;

public class Ship extends Sprite{

    private int shipX;
    private int shipY;
    private Color[][] colorGrid;
    
	public Ship(int x, int y){
        shipX=x;
		shipY=y;	
        colorGrid =	Display.SHIP_SHAPE;
	}//Constructor

    public int getX(){
		return shipX;
	}//getX
	
	public int getY(){
		return shipY;
	}//getY
	
	public Color[][] getColorGrid(){
		return this.colorGrid;
	}//getColorGrid

}//Ship
