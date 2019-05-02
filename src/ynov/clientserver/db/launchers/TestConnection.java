package ynov.clientserver.db.launchers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


import ynov.clientserver.db.connector.MySqlConnecteur;

public class TestConnection {
	public static JSONArray recupere(JSONObject demande) {
		JSONArray res = new JSONArray();
		MySqlConnecteur conn=new MySqlConnecteur("anniversaires");
		// on récupère de demande la commande
		String commande=demande.getString("commande");
		if(commande.equals("*")) {
			String sql="SELECT * FROM anniv";
			try {
				ResultSet rs=conn.select(sql);
				while(rs.next()) {
					JSONObject record=new JSONObject();
					// récupérer les données -> jsonobject record
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					int annee = rs.getInt("anneeNaissance");
					record.put("Prénom", prenom);
					record.put("Nom", nom);
					record.put("Année", annee);
					// ajouter record au jsonarray
					res.put(record);
				}
		
			} catch(Exception e) {
				
			}
		}
		else if(commande.equals("<=")) {
			int annee=demande.getInt("valeur");
			String sql="SELECT * FROM anniv WHERE anneeNaissance<="+annee;
			try {
				
			} catch(Exception e) {
				
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("Tous les enregistrements :");
		JSONObject j1=new JSONObject();
		j1.put("commande", "*");
		System.out.println(TestConnection.recupere(j1));

		

		System.out.println("nés avant 1998 :");
		JSONObject j2=new JSONObject();
		j2.put("commande", "<=");
		j2.put("valeur", 1998);
		System.out.println(TestConnection.recupere(j2));
	}

}