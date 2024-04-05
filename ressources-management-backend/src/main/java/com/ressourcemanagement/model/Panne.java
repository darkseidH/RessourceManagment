package com.ressourcemanagement.model;


/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:33 AM
 */
public class Panne {

	private date dateApparition;
	private boolean demanderChanger;
	private boolean demanderReparer;
	private string explication;
	private PanneFrequence frequence;
	private PaneOrder ordre;
	public RessourceMaterielle m_RessourceMaterielle;
	public PaneFrequence m_PaneFrequence;
	public PaneOrder m_PaneOrder;

	public Panne(){

	}

	public void finalize() throws Throwable {

	}
}//end Panne