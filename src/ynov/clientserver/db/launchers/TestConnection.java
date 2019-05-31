package ynov.clientserver.db.launchers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;


import ynov.clientserver.db.connector.MySqlConnecteur;

public class TestConnection {
	public static JSONArray recupere(JSONObject demande) {
		JSONArray res = new JSONArray();
		MySqlConnecteur conn=new MySqlConnecteur("anniversaires");

		String commande=demande.getString("commande");
		
		// All people infos 
		if(commande.equals("*")) {
			String sql="SELECT * FROM anniv";
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
					
					// SQL Results
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int annee = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", annee);
					res.put(record);
				}
		
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// All the people born before (or in) a given year
		else if(commande.equals("<=")) {
			int annee=demande.getInt("valeur");
			String sql="SELECT * FROM anniv WHERE anneeNaissance <= "+annee;
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
	
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int anneeNaissance = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", anneeNaissance);
					res.put(record);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


		// People born in given year
		else if(commande.equals("==")) {
			int annee=demande.getInt("valeur");
			String sql="SELECT * FROM anniv WHERE anneeNaissance = "+annee;
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
	
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int anneeNaissance = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", anneeNaissance);
					res.put(record);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

		// People who aren't born in a given year
		else if(commande.equals("!=")) {
			int annee=demande.getInt("valeur");
			String sql="SELECT * FROM anniv WHERE anneeNaissance != "+annee;
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
	
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int anneeNaissance = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", anneeNaissance);
					res.put(record);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// People born after a given year
		else if(commande.equals(">")) {
			int annee=demande.getInt("valeur");
			String sql="SELECT * FROM anniv WHERE anneeNaissance > "+annee;
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
	
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int anneeNaissance = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", anneeNaissance);
					res.put(record);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return res;
	}

}