package com.ressourcemanagement.model;


import com.ressourcemanagement.enumeration.PanneFrequence;
import com.ressourcemanagement.enumeration.PaneOrder;

import java.util.Date;

/**
 * @author Said
 * @version 1.0
 * @created 05-Apr-2024 10:40:33 AM
 */
public class Panne {
	private long idPanne;
	private Date dateApparition;
	private boolean demanderChanger;
	private boolean demanderReparer;
	private String explication;
	private PanneFrequence frequence;
	private PaneOrder ordre;
	private long idRessource;
	private PanneFrequence m_PanneFrequence;
	public PaneOrder m_PaneOrder;

}//end Panne