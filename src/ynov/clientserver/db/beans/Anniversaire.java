package ynov.clientserver.db.beans;

import org.json.JSONObject;

public class Anniversaire {
	private String m_prenom;
	private String m_nom;
	private int m_anneeNaissance;
	
	public Anniversaire(String prenom, String nom, int anneeNaissance) {
		super();
		m_prenom = prenom;
		m_nom = nom;
		m_anneeNaissance = anneeNaissance;
	}
	
	public String toString()
	{
		return String.format("%20s %20s né(e) en %d",
				m_prenom, m_nom, m_anneeNaissance);
	}

	public String getPrenom() {
		return m_prenom;
	}

	public void setPrenom(String prenom) {
		m_prenom = prenom;
	}

	public String getNom() {
		return m_nom;
	}

	public void setNom(String nom) {
		m_nom = nom;
	}

	public int getAnneeNaissance() {
		return m_anneeNaissance;
	}

	public void setAnneeNaissance(int anneeNaissance) {
		m_anneeNaissance = anneeNaissance;
	}

	public JSONObject toJsonObject() {
		return new JSONObject();
	}
}
