import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu
{
	private int choix = 0;
	private String fichier = null;


	private void enteteMenu()
	{
		 System.out.println("\t\t***********************************************");
		 System.out.println("\t\t|                BIENVENUE                    |");
	     System.out.println("\t\t|                    A                        |");
	     System.out.println("\t\t|             SERRE - CHEVALIER               |");
	     System.out.println("\t\t***********************************************");
	     System.out.println("\t\t          Quel type de skieur êtes-vous ?      ");
		 System.out.println("\t\t              1- Débutant                   ");
		 System.out.println("\t\t              2- Expérimenté                ");
		 System.out.println("\t\t              3- Quitter                ");


	}


	public String gestionMenu()
	   {

		   Scanner sc = new Scanner(System.in);

		   try
		    {
			    while(choix != 1 && choix != 2 && choix != 3)
			     {
			        effaceEcran();
			    	this.enteteMenu();
			    	System.out.println("\t\t\t   Veuillez saisir votre choix :");
			    	choix = sc.nextInt();

			     }
		    }
		   catch(InputMismatchException e)
		    {
			   System.out.println("\n\t\t\t   Votre saisie est incorrecte !!! \n \t\t   Merci de relancer l'application \n\n");
			   sc.close();
		    }
		   finally
		   {

			switch(choix)
			     {
			        case 1:
			        	fichier = "debutant.txt";
			        	return fichier;
			        case 2:
			        	fichier ="expert.txt";
			        	return fichier;	
			        default:
			        	break;
			     }

		   }

          return null;
	   }

    public void sourceDestination(ListeSommets ls)
    {
    	boolean exit1 = false, exit2 = false;
    	
    	String str[] = new String[2];

    	Scanner sc = new Scanner(System.in);
    	
    	String[] nomSommets = ls.getTableauSommet();
    	
      	
    	while(!exit1)
    	{
    		
    		System.out.println("\t\t   Où vous trouvez-vous ? :  ");
    		System.out.println("\t\t   PS: Souhaitez-vous afficher la liste des sommets o/n?");
 
    		str[0] = sc.nextLine();
    		if(str[0].equals("o"))
    		{
    			effaceEcran();
    			
    			for(String string : nomSommets)
    				 System.out.println(string);
    			exit1 = false;
    		}
    				
    		else
    		{
    			effaceEcran();
    			System.out.println("\t\t   Où vous trouvez-vous ? :  ");
    			
    			str[0] = sc.nextLine();
    			exit1 = ls.idenSource(str[0]);
    			effaceEcran();
    		}
    			
    	}
        
    	effaceEcran();
    	
    	while(!exit2)
    	{
        	System.out.println("\t\t   A quel endroit souhaitez-vous vous rendre ? :  ");
        	System.out.println("\t\t   PS: Souhaitez-vous afficher la liste des sommets o/n?");
        	      	
        	str[1] = sc.nextLine();
        	
       		if(str[1].equals("o"))
    		{
    			effaceEcran();
    			
    			for(String string : nomSommets)
    				 System.out.println(string);
    			exit2 = false;
    		}
    				
    		else
    		{
    			effaceEcran();
    			System.out.println("\t\t   A quel endroit souhaitez-vous vous rendre ? :  ");
    			
    			str[1] = sc.nextLine();
    			exit2 = ls.idenDestination(str[1]);
    			effaceEcran();
    		}
        	
    	}

    	sc.close();
    	effaceEcran();

    }


	public static void effaceEcran()
	  {

		 try
		 {

			 final String systExpl = System.getProperty("os.name").toLowerCase();

			 if(systExpl.contains("windows"))
				 {
				    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				 }
			 else
			 {
				 for(int i=0; i< 1000; i++)
					System.out.println("\n");
				 System.out.print("\033[H\033[2J");
				 System.out.flush();
			 }

		   }
		  catch(Exception e)
		   {
			  System.exit(1);
		   }

	  }

}
