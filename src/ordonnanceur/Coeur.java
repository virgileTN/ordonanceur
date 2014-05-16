package ordonnanceur;

import java.util.ArrayList;
import java.util.List;

public class Coeur {
	//entier mémorisant le temps de traitement restant
	private int tempsTraitement;
	//liste de tâches attribuées au coeur
	private List<Task> list;
	/**
	 * contructeur par défaut
	 */
	public Coeur(){
		reset();
	}
	/**
	 * Ajouter une tâche au coeur
	 * @param tache
	 */
	public void addTask(Task tache){
		//ajout 
		list.add(tache);
		//ajout du temps restant pour traiter la tâche au temps de traitement total du coeur
		tempsTraitement += tache.getReste();
	}
	/**
	 * 
	 * @param tache
	 * @param posTask
	 */
	public void addTask(Task tache, int posTask){
		//on ajoute la tâche à la position donnée
		list.add(posTask, tache);
		//et on incrémente le temps de traitement avec le temps nécéssaire pour traiter la tâche
		tempsTraitement += tache.getReste();
	}
	/**
	 * Retourne la tâche située la position demandée
	 * @param noTask
	 * @return
	 */
	public Task getTask(int noTask){
		return list.get(noTask);
	}
	/**
	 * 
	 * @return
	 */
	public int getReste(){
		return tempsTraitement;
	}
	/**
	 * avance le temps du coeur et met a jour les taches en fonction
	 * @param temps
	 */
	public void effectuer(int temps){
		int save = temps;
		for(Task tache : list){
			temps = tache.effectuer(temps);
			if(temps ==0){
				tempsTraitement -= save;
				return;
			}else{
				tempsTraitement = temps;
			}
		}
		tempsTraitement -=temps;
	}
	/**
	 * initialise ou reinitialise le coeur
	 */
	public void reset(){
		//initialise le temps de traitement restant à 0
		int tempsTraitement=0;
		//crée une liste de tâches vide 
		list = new ArrayList<Task>();
	}
}
