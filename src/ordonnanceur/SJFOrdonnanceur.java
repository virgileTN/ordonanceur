package ordonnanceur;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SJFOrdonnanceur extends AbstractOrdonnanceur {

	public SJFOrdonnanceur(int nbCoeur) {
		super(nbCoeur);
	}

	@Override
	protected Task nextTask(List<Task> pendingList) {
		return Collections.min(pendingList, new Comparator<Task>() {
			public int compare(Task t1, Task t2) {
				if(t1.getDuree() == t2.getDuree())
					return Integer.compare(t1.getNum(), t2.getNum());
				else
					return Integer.compare(t1.getDuree(), t2.getDuree());
			}
		});
	}
}
