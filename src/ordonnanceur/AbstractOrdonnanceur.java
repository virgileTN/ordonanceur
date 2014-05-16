package ordonnanceur;

import java.util.ArrayList;
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
	
	public List<Coeur> getResult(TaskList list) {
		List<Task> ordered = this.getOrderedList(list);
		
		for(Coeur coeur : this.coeurList) {
			coeur.reset();
		}
		
		for(Task task : ordered) {
			Coeur nextCoeur = earlierFinishedCoeur(this.coeurList);
			
			nextCoeur.addTask(task);
		}
		
		return this.coeurList;
	}
	
	private Coeur earlierFinishedCoeur(List<Coeur> list) {
		int min = 0;
		int minPos = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getReste() < min) {
				minPos = i;
			}
		}
		
		return list.get(minPos);
	}
	
	public void effectuer(int i) {
		for(Coeur coeur : this.coeurList) {
			coeur.effectuer(i);
		}
	}
	
	protected abstract List<Task> getOrderedList(TaskList list);
}
