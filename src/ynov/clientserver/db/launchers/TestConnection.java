package ynov.clientserver.db.launchers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import ynov.clientserver.db.connector.MySqlConnecteur;

public class TestConnection {

	public static void main(String[] args) {
		try
		{
			MySqlConnecteur mc = new MySqlConnecteur("anniversaires");
			
			// SQL Request
			String sql = "SELECT * FROM anniv";
			ResultSet rs = mc.select(sql);
			
			// View
			while(rs.next())
			{
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				Date annee = rs.getDate("anneeNaissance");
				int sexe = rs.getInt("sexe");
				
				System.out.print(prenom + " - " + nom + " : " + annee + "\n");
			}
		}
		catch(Exception exc)
		{
			System.err.println(exc.getMessage());
		}

	}

}