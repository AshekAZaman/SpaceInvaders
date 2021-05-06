import java.awt.Color;

public class Alien extends Sprite{

    private int alienX;
    private int alienY;
    private Color[][] colorGrid;
    
	public Alien(int x, int y){
        alienX=x;
		alienY=y;	
        colorGrid =	Display.ALIEN_SHAPE;
	}//Constructor

    public int getX(){
		return alienX;
	}//getX
	
	public int getY(){
		return alienY;
	}//getY
	
	public Color[][] getColorGrid(){
		return this.colorGrid;
	}//getColorGrid

}//Alien
