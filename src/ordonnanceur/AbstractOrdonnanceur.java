package ordonnanceur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractOrdonnanceur implements Ordonnanceur{
	protected List<Coeur> coeurList;
	
	/**
	 * Constructeur dépendant du nombre de coeurs
	 * 
	 * @param nbCoeur
	 * 	Nombre de coeurs executant les taches
	 */
	public AbstractOrdonnanceur(int nbCoeur) {
		this.coeurList = new ArrayList<Coeur>(nbCoeur);
		
		for(int i = 0; i < nbCoeur; i++) {
			this.coeurList.add(new Coeur());
		}
	}
	
	public void effectuer(int i) {
		for(Coeur coeur : this.coeurList) {
			coeur.effectuer(i);
		}
	}
}
