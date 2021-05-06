import java.awt.Color;

public abstract class Sprite {

    //gets the x coordinate
    public int getX(){
        System.out.println("Abstract Class getX() is called");
        return -1;
    }//getX

    //gets the y coordinate
    public int getY(){
        System.out.println("Abstract Class getY() is called");
        return -1;
    }//getY

    //gets a 2D array of Color which can later be used to draw the Sprite on the window. 
    public Color[][] getColorGrid(){
        System.out.println("Abstract Class getColorGrid() is called");
        return null;
    }//getColorGrid

    
}//Sprite
