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
    
    
    public String nomArc;
    
  
    
    /**
     * Constructor for objects of class Chemin
     */
    
    public Chemin()
    {
        this.distance = 0;
        this.nomArc="";
    }
    
    public Chemin(int distance, String nomArc)
    {
        this.distance = distance;
        this.nomArc= nomArc;
    }
    
    
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    
    
    
    public void setArc(String nomArc)
    {
        this.nomArc = nomArc;
    }
    

  
    public int getDistance()
    {
        return this.distance;
    }
    
   
    
    /**
     * 
     */
    public String getArc()
    {
        return this.nomArc;
    }
    
    public String affichage()
    {
        return this.distance+" "+this.nomArc;
    }
}
