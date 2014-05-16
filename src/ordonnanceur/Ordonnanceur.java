package ordonnanceur;

import java.util.List;

public interface Ordonnanceur {
	public List<Coeur> getResult(TaskList list);
	void effectuer(int i);
}
