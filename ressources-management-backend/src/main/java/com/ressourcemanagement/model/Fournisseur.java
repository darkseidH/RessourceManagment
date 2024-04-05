package com.ressourcemanagement.model;


/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:24 AM
 */
public class Fournisseur extends User {

	private string adresse;
	private string gerant;
	private string lieu;
	private boolean listeNoire;
	private string nomSociete;
	private string siteInternet;

	public Fournisseur(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Fournisseur