import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;


/************      Impl�mentation de l'Algorithme de Dijkstra   ***************/

public class Dijkstra {
	
	
    final MatriceChemins g;                                  //le graphe de travail
    final ListeSommets listeSommet;                         // la liste des sommets
    final int n;                                           // nombre de sommets de g
    public int source;                                    // position actuelle du skieur
    public int dest;                                     // destination du skieur
    public List<Integer> itineraire;
    int[] dist;                                        // tableau des distance de la source � un sommet ***
    int[] pred;                                       // tableau pere ***
    boolean[] traiter;                               //  ***
    PriorityQueue<Noeud> nonTraiter;

    
    //constructeur
    public Dijkstra(MatriceChemins g, ListeSommets ls, int source, int   dest)
    {
        
        this.g = g;
        n = g.Taille;
        this.source = source;
        this.dest = dest;
        listeSommet = ls;
        dist = new int [n];
        pred = new int [n];
        itineraire = new ArrayList<Integer>();
        traiter = new boolean [n];
        for(int i=0; i<n; i++) {  // initialise les distance de la source au sommet i a infini
        	
        		dist[i] = Integer.MAX_VALUE;
        		pred[i] = -1;// initialise tableau de pere à -1
        		traiter[i] = false;//true si pas traité
        }
        
        this.dist[this.source] = 0; // distance de la source à la source
        this.pred[this.source] = this.source; // source est sont propre père
        nonTraiter = new PriorityQueue<Noeud>();
        nonTraiter.add( new Noeud(this.source, 0) );
     }
     
    // mise a jour de la distance, de la priorite, et du predecesseur d'un sommet
    public void update(int y, int x)
    {
        int distance = g.matrice[x][y].distance; 
        if( dist[y] > dist[x] + distance){
            dist[y] = dist[x] + distance;
            pred[y] = x;
            nonTraiter.add( new Noeud(y,dist[y]) );
        }
    }
    
    // trouve le prochain sommet  nonTraiter � traiter
    public int nextNoeud()
    {
        
        while( !nonTraiter.isEmpty() ){
            Noeud n = nonTraiter.poll();
            if( !traiter[n.id] ){ //return false si pas trait�
                return n.id;
            }
        }
        return -1;
    }
    
    // une etape de l'algorithme Dijkstra
    public int uneEtape()
    {
        
        int sommet = nextNoeud();
        if(sommet != -1){
            traiter[sommet] = true;
            
            for(int i=0; i<g.succ.get(sommet).size(); i++)
            		update(g.succ.get(sommet).get(i), sommet);
            	
        }
        return sommet;
    }
    
    // algorithme de Dijkstra complet
    public int distancePlusCourtChemin()
    {
        int sommet = source;
        while( sommet != dest && sommet != -1){
             sommet = uneEtape();
        }
        if(sommet == -1){
            return -1;
        }
        return dist[dest];
    }
    
    public void setSource(int source)
    {
        this.source = source;
    }
    
    public void setDest(int dest)
    {
        this.dest = dest;
    }
        
    
    
    public void itineraire()
    {
        itineraire.add(dest);
        
        int id = pred[dest];
        while(id != source)
        { 
            itineraire.add(id);
            id = pred[id];
        }
       itineraire.add(id);
    }
    
    public void afficher()
    {
    	int sommet, sommet1;
    	if(this.source == this.dest)
    	{
    		System.out.println("Pas besoin de vous déplacez, vous y êtes déja  :-) ");
    		return;
    	}
       
        ListIterator<Integer> it = this.itineraire.listIterator(this.itineraire.size());
        
        while(it.hasPrevious())
        {
            sommet = it.previous();
            if(sommet == this.source)
            {
                System.out.println("\tVous êtes actuellement à "+ listeSommet.tabSommet[ sommet ]);
                
                sommet1 = it.previous();
                
                if(g.matrice[sommet][sommet1].getArc().contains("piste"))
                	System.out.print("\tPrenez la "+g.matrice[sommet][sommet1].getArc());
                else
                	System.out.print("\tPrenez le "+g.matrice[sommet][sommet1].getArc());

               System.out.println(" jusqu'à"+ listeSommet.tabSommet[ sommet1 ]); 
               it.next();
            }
            else if(sommet == this.dest)
            {
                System.out.print("\n\tvous devriez arriver à"+ listeSommet.tabSommet[ sommet ]+" dans ");
            }
            
            else if(sommet != this.dest)
            {
                
                sommet1 = it.previous();
                if(g.matrice[sommet][sommet1].getArc().contains("Piste")==true)
                {
                    System.out.print("\tUne fois à"+listeSommet.tabSommet[sommet]+" continuer sur la "+g.matrice[sommet][sommet1].getArc());
                    System.out.println(" jusqu'à"+ listeSommet.tabSommet[ sommet1 ]); 
                }
                else
                {
                	System.out.print("\tUne fois à"+listeSommet.tabSommet[ sommet ]+" continuer sur le "+g.matrice[sommet][sommet1].getArc());
                	System.out.println(" jusqu'à"+ listeSommet.tabSommet[ sommet1 ]); 
                }
                     
                          
                it.next();
                
            }
        }
    }
        
        
}
