package ynov.clientserver.db.connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class Client {
	public static void main(String args[]) {
		try {
			Socket skt = new Socket("localhost", 1260);
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			Scanner clavier=new Scanner(System.in);
			

			System.out.print("Choisissez l'action à effectuer : ");
			String input = clavier.next();
			JSONObject requete=new JSONObject();
			requete.put("commande", input);
			System.out.println(requete);
			
			if(!input.equals("*")) {
				System.out.print("Choisissez l'année : ");
				int annee=clavier.nextInt();
				requete.put("valeur", annee);
			}
			
			out.println(requete);
				
			System.out.println("Fin du client. A plus dans l'bus !");
			in.close();
		}
			
		catch(Exception e)
		{
			System.err.println("Problème client : "+e.getMessage());
		}
	}

}