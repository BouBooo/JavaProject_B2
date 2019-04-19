package ynov.clientserver.db.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.ResultSet;


public class Serveur {
	public static void main(String args[])
	{
	String[] chaines={"Toutes les personnes de la base de données", "task2", "task3"};
	try {
	ServerSocket srvr = new ServerSocket(1259);
	System.out.println("Serveur à l'écoute...");
	Socket skt = srvr.accept();
	System.out.println("Un client est connecté !");
	// on initialise les flux de lecture et d'écriture
	PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
	BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	
	while(true){
		int nb = Integer.parseInt(in.readLine());
		System.out.println("Serveur : réception "+nb);
		if(nb<0 || nb>=chaines.length){
			System.out.println("Nombre invalide");
			out.println("Tchao");
			break;
		}
		else if(nb == 0) {
			MySqlConnecteur mc=new MySqlConnecteur("anniversaires");
			
			// SQL Request
			String sql = "SELECT prnom, nom FROM anniv";
			ResultSet rs = mc.select(sql);
			
			// View
			while(rs.next())
			{
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				System.out.print(prenom + "\n");
			}
		}
	}
	System.out.println("Le serveur s'arrête...");
	out.close();
	skt.close();
	srvr.close();
	}
	catch(Exception e) {
	System.out.println("Problème : "+e.getMessage());
	}
	}

}

