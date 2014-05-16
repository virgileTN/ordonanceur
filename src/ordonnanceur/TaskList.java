package ordonnanceur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
	private List<Task> list;
	
	/**
	 * Constructeur par defaut
	 * 
	 * Après initialisation la liste est vide.
	 */
	public TaskList() {
		this.list = new ArrayList<Task>();
	}
	
	/**
	 * Constructeur par lecture du fichier de configuration
	 * 
	 * @param input
	 * 		Fichier de configuration
	 */
	public TaskList(InputStream input) {
		this.list = new ArrayList<Task>();
		
		String buffer = null;
		InputStreamReader isrd = new InputStreamReader(input);
		BufferedReader br = new BufferedReader(isrd);
		
		try{
			
			while((buffer = br.readLine()) != null) {
				this.list.add(new Task(buffer));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ajoute une tache à la liste
	 * 
	 * @param task
	 * 		Tache à ajouter
	 */
	public void addTask(Task task) {
		this.list.add(task);
	}
	
	/**
	 * Retourne la tache position i
	 * 
	 * @param i
	 * 		Position de la tache à retourner
	 * @return
	 * 		La tache position i
	 */
	public Task getTask(int i) {
		return this.list.get(i);
	}
	
	
	/**
	 * Retourne le nombre de taches dans la liste
	 * 
	 * @return
	 * 		Nombre de taches dans la liste
	 */
	public int getSize() {
		return this.list.size();
	}
}
