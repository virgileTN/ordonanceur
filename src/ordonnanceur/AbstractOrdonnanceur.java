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
	
	public List<Coeur> getResult(TaskList list) {
		
		for(Coeur coeur : this.coeurList) {
			coeur.reset();
		}
		
		if(!list.isEmpty()) {
			int time = 0;
			// LinkedList car on a beaucoup d'ajout et de retrait
			List<Task> pendingList = new LinkedList<Task>();
			Iterator<Task> it = list.iterator();
			Task futureTask = it.next();
			// Tant qu'il reste des taches à traiter
			while(futureTask != null || !pendingList.isEmpty()) {
				// Tant qu'il reste des taches à ajouter à la liste des taches en attente
				while(futureTask != null && (time >= futureTask.getDebut() || pendingList.isEmpty())) {
					pendingList.add(futureTask);
					if(it.hasNext())
						futureTask = it.next();
					else
						futureTask = null;
				}
				
				Coeur nextCoeur = earlierFinishedCoeur(this.coeurList);
				time = nextCoeur.getReste();
				Task task = nextTask(pendingList);
				nextCoeur.addTask(task);
				System.out.println("Ajout : " + task);
				System.out.println("En attente :");
				pendingList.remove(task);
				for(Task t : pendingList)
					System.out.println(t);
			}
			pendingList.add(futureTask);
		}
		
		return this.coeurList;
	}

	private Coeur earlierFinishedCoeur(List<Coeur> list) {
		return Collections.min(list, new Comparator<Coeur>() {
			public int compare(Coeur c1, Coeur c2) {
				return Integer.compare(c1.getReste(), c2.getReste());
			}
		});
	}
	
	public void effectuer(int i) {
		for(Coeur coeur : this.coeurList) {
			coeur.effectuer(i);
		}
	}
	
	protected abstract Task nextTask(List<Task> pendingList);
}
