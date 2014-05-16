package ordonnanceur;

import java.util.List;

public class Console implements View {
	public Console(){
		
	}
	public void print(List<Coeur> listeCoeur){
		for(int i=0;i<listeCoeur.size();i++){
			System.out.println("Coeur n°"+i);
			System.out.println(listeCoeur.get(i).toString());
		}
	}
}
