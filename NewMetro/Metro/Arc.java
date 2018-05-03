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
public class Arc
{
    public int distance;
    
    
    public String nomArc;
    
  
    
    /**
     * Constructor for objects of class Chemin
     */
    
    public Arc()
    {
        this.distance = 0;
        this.nomArc="";
    }
    
    public Arc(int distance, String nomArc)
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
