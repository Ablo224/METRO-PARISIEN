import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
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
    public int nbSommets;


    public ListeSommets(int nbrSommets)
    {
        tabSommet = new String [nbrSommets];
        nbSommets = nbrSommets;
        this.initTableauSommet();


        source = new int [nbSourceDest];
        destination = new int [nbSourceDest];
        nbSource = 0;
        nbDest = 0;

        for(int i=0; i<this.source.length; i++)
        {
            source[i] = -1;
            destination[i] = -1;
        }
    }

    private void initTableauSommet()
    {
        for(int i=0; i<nbSommets; i++)
            tabSommet[i] = new String();
    }
    public void  remplirTableauSommet(String monFichier) throws IOException, NoSuchElementException
    {

        String index;
        int i=0;

        File f = new File(monFichier);

        if(f.isFile() && f.canRead())
        {
            try( FileInputStream fs = new FileInputStream (f))
               {
                    Scanner scanner = new Scanner(fs);
                    while((scanner.hasNextLine()))
                    {
                        index = scanner.next();

                        if(index.equals("#"))
                        {
                            scanner.nextLine();
                        }
                        else if(index.equals("V"))
                        {
                             scanner.nextInt();
                             tabSommet[i] = scanner.nextLine();
                             i++;
                        }
                        else
                            break;
                    }
                    fs.close();
                    scanner.close();
                }
        }
        else
           throw new FileNotFoundException("\n\n\t\t\t  Le fichier correspondant au niveau souhaité n'existe pas !!!");
    }

    public  String[] getTableauSommet()
    {
        return tabSommet;
    }

    public int getNbSommets()
    {
        return nbSommets;
    }

    public boolean idenSource(String source)
    {
            int j=0;

            for(int i=0; i< nbSommets; i++)
            {
               if(tabSommet[i].equals(" " + source))
                {
                    this.source[j]= i;
                    nbSource = j;
                    j++;
                    
                    return true;
                }

            }
            
            return false;
    }

    public boolean idenDestination(String destination)
    {
        int j=0;
        for(int i=0; i<this.nbSommets; i++)
        {
            if(this.tabSommet[i].equals(" "+destination))
            {
                this.destination[j]= i;
                this.nbDest = j;
                j++;
                
                return true;
            }
        }
        
        return false;
    }
}

