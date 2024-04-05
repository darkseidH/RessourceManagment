package com.ressourcemanagement.model;


/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:28 AM
 */
public class Ordinateur extends RessourceMaterielle {

	private string cpu;
	private string disque dur;
	private string ecran;
	private string ram;

	public Ordinateur(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Ordinateur