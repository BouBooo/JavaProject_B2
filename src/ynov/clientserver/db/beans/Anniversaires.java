package ynov.clientserver.db.beans;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import ynov.clientserver.db.connector.MySqlConnecteur;

public class Anniversaires extends ArrayList<Anniversaire> {
	public Anniversaires(boolean empty) {
		if(!empty) {
				MySqlConnecteur mc=new MySqlConnecteur("anniversaires");
				
				try {
					// SQL Request
					String sql = "SELECT prenom, nom FROM anniv";
					ResultSet rs = mc.select(sql);
		
					// View
					while(rs.next())
					{
						String prenom = rs.getString("prenom");
						String nom = rs.getString("nom");
						System.out.print(prenom + "\n");
						//this.add(new Anniversaire(...));
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
		}
	}
	public JSONArray toJsonArray() {
		return new JSONArray();
	}
}
