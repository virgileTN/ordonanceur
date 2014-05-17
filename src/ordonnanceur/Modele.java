package ordonnanceur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class Modele {
	TaskList listeTache;
	Ordonnanceur ordo;
	public Modele(){
		
	}
	public Modele(int NbCoeurs, String typOrd, String cheminFichier, int quantum) throws FileNotFoundException{
		InputStream is = new FileInputStream(cheminFichier);
		listeTache = new TaskList(is);
		switch(typOrd){
		//mode    First In First out
		case "FIFO" :
			ordo = new FIFOOrdonnanceur(NbCoeurs);
			break;
		/*//mode Round Robin
		case "RR" :
			ordo = new RROrdonnanceur(NbCoeurs,quantum);
			break;
		//mode Priority
		case "PR" :
			ordo = new PROrdonnanceur(NbCoeurs);
			break;
		//mode shortest remaining Time
		case "SRT" :
			ordo = new SRTOrdonnanceur(NbCoeurs);
			break;*/
		}
	}
	public List<Coeur> getResult(){
		return ordo.getResult(listeTache);
	}
	public void addTask(Task tache){
		listeTache.addTask(tache);
	}
	public void effectuer(int temps){
		ordo.effectuer(temps); 
	}
}
