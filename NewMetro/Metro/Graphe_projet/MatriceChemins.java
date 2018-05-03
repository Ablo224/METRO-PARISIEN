import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MatriceChemins
{
    public  Arc [][] matrice;
    public  int Taille;
    public ArrayList<ArrayList<Integer>> succ; // successeurs de chaque sommet


	public MatriceChemins(int taille)
    {

        matrice = new Arc [taille][taille];
        Taille = taille;
        succ = new ArrayList<ArrayList<Integer>>(taille);

       for (int i = 0; i < taille; i++)
        {
            succ.add(i,new ArrayList<Integer>(taille));
        }

        this.initialiser();
    }

    private void initialiser()
    {
        for(int i=0; i<Taille; i++)
        {
            for(int j=0; j<Taille;j++)
            {
                matrice[i][j] = new Arc();
            }
        }
    }


    public  void remplirMatrice(String monFichier) throws IOException, NoSuchElementException
    {
        String index;
        int temps, id1, id2;
        String nomArc;

        File f = new File(monFichier);

        if(f.isFile() && f.canRead())
        {
            try( FileInputStream fs = new FileInputStream(f))
               {
                  Scanner scanner = new Scanner(fs);
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
                        temps = scanner.nextInt();
                        nomArc = scanner.nextLine();
                        matrice[id1][id2]= new Arc(temps, nomArc);
                        
                        succ.get(id1).add(id2);
                        	
                     }
                     
                   }
                 fs.close();
                 scanner.close();
                 Menu.effaceEcran();
               }
        }
        else
           throw new FileNotFoundException("\n\n\t\t\t  Le fichier correspondant au niveau souhaité n'existe pas !!!");
    }
}
