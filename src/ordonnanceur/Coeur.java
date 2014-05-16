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
		//on enleve au temps de traitement restant le temps à effectuer
		tempsTraitement -= temps;
		//si le résultat est négatif, on le borne à 0
		if (tempsTraitement<0){
			tempsTraitement = 0;
		}
		//tant qu'il reste du temps et que la liste n'est pas vide
		while(temps>0 && !list.isEmpty()){
			//on traite la premiere tache
			temps = list.get(0).effectuer(temps);
			//si cette dernière est finie, on la supprime de la liste
			if(list.get(0).isFinished()){
				list.remove(0);
			}
		}
	}
	/**
	 * initialise ou reinitialise le coeur
	 */
	public void reset(){
		//initialise le temps de traitement restant à 0
		tempsTraitement=0;
		//crée une liste de tâches vide 
		list = new ArrayList<Task>();
	}
	/**
	 * retourne une chaine contenant les taches du coeur hyerarchisées 
	 */
	public String toString(){
		String chaine = "";
		int i=0;
		for(Task tache : list){
			chaine = chaine+espacement(i)+tache.toString()+"\n";
			i+=8;
		}
		return chaine;
	}
	/**
	 * 
	 * @param nbEsp
	 * @return une chaine de characéres contenant nbEsp espaces
	 */
	private String espacement(int nbEsp){
		String chaine = "";
		for(int i=0;i<nbEsp;i++){
			chaine = chaine + " ";
		}
		return chaine;
	}
}
