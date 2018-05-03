import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;



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
        int disMin = d.distancePlusCourtChemin();
        int distance = 2;
        for(int i=0; i<ls.nbSource; i++)
        {
            if(ls.source[i] == -1 )
                {
                    return disMin;
                }
            for(int j=0; j<ls.nbDest; j++)
            {
                if(ls.destination[i] == -1 )
                {
                    break;
                }
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




    public static void run()
    {
    	ListeSommets ls = new ListeSommets(71);
    	MatriceChemins matrice;
    	Dijkstra d;
    	int disMin = Integer.MAX_VALUE;
    	 
    	 
        Menu menu = new Menu();
        String file = menu.gestionMenu();

        if(file == null)
            System.exit(1);

    	        
        try{
            matrice = new MatriceChemins(71);
            matrice.remplirMatrice(file);
            ls.remplirTableauSommet(file);
  
    		menu.sourceDestination(ls);
    		
            d = new Dijkstra(matrice, ls, ls.source[0], ls.destination[0]);

            disMin = distanceMin(d,ls, matrice);

            d.itineraire();							// Calcule l'itinéraire
            //System.out.println("\n\n\n");
            d.afficher();					   	   //Affiche l'itinéraire
            
            if(disMin > 0)
            	System.out.println(disMin + " min ");
        }
        catch(NoSuchElementException t)
        {
            System.out.println(t.getMessage());
        }
        catch( FileNotFoundException fnde)
        {
           System.out.println(fnde.getMessage());
           System.exit(1);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args)
    {
        run();
    }
}
