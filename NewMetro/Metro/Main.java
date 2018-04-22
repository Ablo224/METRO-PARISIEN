import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    public static void copieTableau( int []tabSource, int []tabDest)
    {
        for(int i=0; i< tabSource.length; i++)
        {
            tabDest[i]= tabSource[i];
        }
    }
    
    public static int distanceMin(Dijkstra d, ListeSommets ls, MatriceChemins matrice)
    {
        //d = new Dijkstra(matrice, ls.source[0], ls.destination[0]);
        int disMin = d.distancePlusCourtChemin();
        int distance = 2;
        for(int i=0; i<ls.nbSource; i++)
        {
            if(ls.source[i] == -1 )
                {
                    return disMin;
                }
            //System.out.println("ici");
            for(int j=0; j<ls.nbDest; j++)
            {
                if(ls.destination[i] == -1 )
                {
                    break;
                }
                //System.out.println("ici");
                Dijkstra newd = new Dijkstra(matrice,  ls, ls.source[i], ls.destination[j]);
                distance = newd.distancePlusCourtChemin();
                if(disMin > distance)
                {
                    disMin = distance;
                    copieTableau(newd.pred,d.pred);
                    d.setSource(ls.source[i]);
                    d.setDest(ls.destination[j]);
                }
            }
        }
        return disMin;
    }
    public static String menu()
    {
    	String fichier=null;
    	int choix=0;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("1.Skieur débutant");
    	System.out.println("2.Skieur expert");
    	System.out.println("Faites votre choix:");
    	choix = sc.nextInt();
    	switch(choix)
    	{
    		case 1:
    			fichier ="debutant.txt";
    			return fichier;
    		case 2:
    			fichier ="expert.txt";
    			return fichier;
    		default:
    			System.out.println("Mauvais choix");return fichier;
    	}
    }
    
    public static String[] sourceDestination()
    {
    	String str[] = new String[2];
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Où êtes vous ? :");
    	str[0] = sc.nextLine();
    	System.out.print("Où allez vous? :");
    	str[1] = sc.nextLine();
    	return str;
    }
    
    
    public static void main(String[] args)
    {
        ListeSommets ls;
        ls = new ListeSommets(71);
        MatriceChemins matrice;
        Dijkstra d;
        int disMin = Integer.MAX_VALUE;
        String file = menu();
        String str[] = new String[2];
        str = sourceDestination();
        

        // test
        try{
            matrice = new MatriceChemins(71);
            matrice.initialiser();
            matrice.remplireMatrice(file);
            ls.remplireTableauSommet(file);
            ls.idenSource(str[0]);
            ls.idenDestination(str[1]);
           
            d = new Dijkstra(matrice, ls, ls.source[0], ls.destination[0]);
            
            disMin = distanceMin(d,ls, matrice);
            
            d.itineraire();// obtenir l'itineraire
            d.afficher();
            System.out.println(disMin/60 + " min "+ disMin%60 + " s");
            
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException t)
        {
            System.out.println(t.getMessage());
        }
    }
}
