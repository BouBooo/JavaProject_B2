package ynov.clientserver.db.connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) {
		try {
			Socket skt = new Socket("localhost", 1259);
			// on initialise les flux de lecture et d'écriture
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			Scanner clavier=new Scanner(System.in);
		
				System.out.print("Choisissez l'action à effectuer : ");
				int nb=clavier.nextInt();
				// on envoie ce nombre au serveur
				out.println(nb);
				
				switch (nb) {
				  case 0:
				    System.out.println("Action 1");
				    break;
				  case 1:
				    System.out.println("Action 2");
				    break;
				  case 2:
				    System.out.println("Action 3");
				    break;
				  case 3:
				    System.out.println("Action 4");
				    break;
				  case 4:
				    System.out.println("Action 5");
				    break;
				}
			
			System.out.println("Fin du client. A plus dans l'bus !");
			in.close();
		}
		catch(Exception e)
		{
			System.err.println("Problème client : "+e.getMessage());
		}
	}

}