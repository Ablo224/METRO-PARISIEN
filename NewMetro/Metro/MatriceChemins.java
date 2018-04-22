import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class MatriceChemins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatriceChemins
{
    public  Chemin [][] matrice;
    public  int Taille;
    public ArrayList<Integer>[] succ; // successeurs de chaque sommet
    
    

    /**
     * Constructor for objects of class MatriceChemins
     */
    @SuppressWarnings("unchecked") 
    public MatriceChemins(int taille)
    {
        
        this.matrice = new Chemin [taille][taille];
        this.Taille =taille;
        this.succ = new ArrayList[taille];
       
        
        for (int k = 0; k < taille; k++) 
        {
            this.succ[k] = new ArrayList<Integer>();
        }
    }
    
    public void initialiser()
    {
        for(int i=0; i<this.Taille; i++)
        {
            for(int j=0; j<this.Taille;j++)
            {
                this.matrice[i][j] = new Chemin();
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public  void remplireMatrice(String monFichier) throws IOException, NoSuchElementException, NullPointerException
    {
        
        String index;
        int distance, id1, id2;
        String nomArc;
        Chemin chemin;
        
        try( FileInputStream fs = new FileInputStream (new File(monFichier));
                Scanner scanner = new Scanner(fs))
        {
             
            while(scanner.hasNextLine())
            {
                index = scanner.next();
            
                if(index.equals("#") ||index.equals("V") )
                {
                    scanner.nextLine();
                }
                
                else if(index.equals("E"))
                {
                     id1 = scanner.nextInt();
                     id2 = scanner.nextInt();
                     distance = scanner.nextInt();
                     nomArc = scanner.nextLine();
                  
                     matrice[id1][id2]= new Chemin(distance, nomArc);
                     succ[id1].add(id2);
                    
                }
              
                
            }
            fs.close();
            scanner.close();
           
        }
        
            
    }
    
    
    
    /*public static void main(String[] args)
    {
        try{
        MatriceChemins matrice;
        matrice = new MatriceChemins(383);
        remplireMatrice("metro.txt");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException e)
        {
            System.out.println("ici "+e.getMessage());
        }
        catch(NullPointerException e)
        {
            System.out.println("ici "+e.getMessage());
        }
    }*/
        
}
