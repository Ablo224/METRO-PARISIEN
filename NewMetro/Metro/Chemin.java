import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Write a description of class Chemin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chemin
{
    public int distance;
    
    public int ligne;
    
    public String direction;
    
  
    
    /**
     * Constructor for objects of class Chemin
     */
    
    public Chemin()
    {
        this.distance = 0;
        this.ligne = 0;
        this.direction ="";
    }
    
    public Chemin(int distance, int ligne, String direction)
    {
        this.distance = distance;
        this.ligne = ligne;
        this.direction = direction;
    }
    
    
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    
    public void setLigne(int ligne)
    {
        this.ligne = ligne;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    

  
    public int getDistance()
    {
        return this.distance;
    }
    
    /**
     * 
     */
    public int getLigne()
    {
        return this.ligne;
    }
    
    /**
     * 
     */
    public String getDirection()
    {
        return this.direction;
    }
    
    public String affichage()
    {
        return this.distance+" "+this.ligne+" "+this.direction;
    }
}
