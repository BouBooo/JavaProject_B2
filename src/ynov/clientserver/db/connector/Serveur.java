package ynov.clientserver.db.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class Serveur {
	public static void main(String args[])
	{
		try {
			JSONArray res = new JSONArray();
			ServerSocket srvr = new ServerSocket(1260);
			System.out.println("Serveur à l'écoute...");
			Socket skt = srvr.accept();
			System.out.println("Un client est connecté !");
			// on initialise les flux de lecture et d'écriture
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));


			String input = in.readLine();
			System.out.println("Serveur : réception "+input);

			JSONObject jsonObj = new JSONObject(input);
			String commande=jsonObj.getString("commande");
			
			MySqlConnecteur mc=new MySqlConnecteur("anniversaires");


			if(commande.equals("*")) {
				try {
					// SQL Request
					String sql = "SELECT prenom, nom, anneeNaissance FROM anniv";
					ResultSet rs = mc.select(sql);

					while(rs.next())
					{
						JSONObject record=new JSONObject();
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						int annee = rs.getInt("anneeNaissance");
						record.put("Prénom", prenom);
						record.put("Nom", nom);
						record.put("Année", annee);
						res.put(record);
					}
					System.out.println(res);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
			else {
				int valeur = jsonObj.getInt("valeur");
				if(commande.equals("=")) {
					String sql= "SELECT prenom, nom, anneeNaissance FROM anniv WHERE anneeNaissance = "+valeur; ;
					ResultSet rs = mc.select(sql);
				
					while(rs.next())
					{
						JSONObject record=new JSONObject();
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						Date annee = rs.getDate("anneeNaissance");
						record.put("Prénom", prenom);
						record.put("Nom", nom);
						record.put("Année", annee);
						res.put(record);
					}
					System.out.println(res);

				}
				else if(commande.equals("!=")) {
					String sql= "SELECT prenom, nom, anneeNaissance FROM anniv WHERE anneeNaissance != "+valeur; ;
					ResultSet rs = mc.select(sql);
					
					while(rs.next())
					{
						JSONObject record=new JSONObject();
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						Date annee = rs.getDate("anneeNaissance");
						record.put("Prénom", prenom);
						record.put("Nom", nom);
						record.put("Année", annee);
						res.put(record);
					}
					System.out.println(res);

				}
				else if(commande.equals(">")) {
					String sql= "SELECT prenom, nom, anneeNaissance FROM anniv WHERE anneeNaissance > "+valeur; ;
					ResultSet rs = mc.select(sql);
					
					while(rs.next())
					{
						JSONObject record=new JSONObject();
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						int annee = rs.getInt("anneeNaissance");
						record.put("Prénom", prenom);
						record.put("Nom", nom);
						record.put("Année", annee);
						res.put(record);
					}
					System.out.println(res);

				}
				else if(commande.equals("<=")) {
					String sql= "SELECT prenom, nom, anneeNaissance FROM anniv WHERE anneeNaissance <= "+valeur; ;
					ResultSet rs = mc.select(sql);
					

					while(rs.next())
					{
						JSONObject record=new JSONObject();
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						int annee = rs.getInt("anneeNaissance");
						record.put("Prénom", prenom);
						record.put("Nom", nom);
						record.put("Année", annee);
						res.put(record);
					}
					System.out.println(res);

				}
				else {
					System.out.println("Requête invalide");
					out.close();
					skt.close();
					srvr.close();
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

