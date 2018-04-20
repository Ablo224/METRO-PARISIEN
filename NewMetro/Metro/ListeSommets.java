import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Write a description of class ListeSommets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListeSommets
{
    public String [] tabSommet;
    
    public int [] source;
    
    public int nbSource;
    
    public int [] destination;
    
    public int nbDest;
    
    public final int nbSourceDest = 10;
    
    
    /** A revoir */
    public int nbSommets;

    /**
     * Constructor for objects of class ListeSommets
     */
    public ListeSommets(int nbrSommets)
    {
        this.tabSommet = new String [nbrSommets];
        this.nbSommets = nbrSommets;
        this.source = new int [nbSourceDest];
        this.destination = new int [nbSourceDest];
        this.nbSource = 0;
        this.nbDest = 0;
        for(int i=0; i<this.source.length; i++)
        {
            source[i] = -1;
            destination[i] = -1;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void  remplireTableauSommet(String monFichier) throws IOException, NoSuchElementException
    {
        
        String index;
         int i=0;
        
        try( FileInputStream fs = new FileInputStream (new File(monFichier));
                Scanner scanner = new Scanner(fs))
        {
             
            while((scanner.hasNextLine())==true)
            {
                index = scanner.next();
             
                if(index.equals("#"))
                {
                    scanner.nextLine();
                }
                
                else if(index.equals("V"))
                {
                     scanner.nextInt();
                     this.tabSommet[i] = scanner.nextLine();
                     i++;
                }
                else{break;}
            }
            fs.close();
            scanner.close();
            
        }
    }
    
    public  String[] getTableauSommet()
    {
        return tabSommet;
    }
    
    public int getNbSommets()
    {
        return nbSommets;
    }
    
    public void idenSource(String source)
    {
        int j=0;
        for(int i=0; i<this.nbSommets; i++)
        {
            if(this.tabSommet[i].equals(" "+source) )
            {
                this.source[j++]= i;
            }
        }
        this.nbSource = j;
    }
    
    public void idenDestination(String destination)
    {
        int j=0;
        for(int i=0; i<this.nbSommets; i++)
        {
            if(this.tabSommet[i].equals(" "+destination))
            {
                this.destination[j++]= i;
            }
        }
        this.nbDest = j;
    }
        
    
    
   /* public static void main(String[] args)
    {
        ListeSommets ls;
        ls = new ListeSommets(384);
        
        try{
            ls.remplireTableauSommet("metro.txt");
            System.out.println(ls.getNbSommets());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException t)
        {
            System.out.println(t.getMessage());
        }
    }*/
    
    
}
