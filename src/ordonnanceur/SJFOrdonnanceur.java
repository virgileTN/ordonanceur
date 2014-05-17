package ordonnanceur;

public class SJFOrdonnanceur extends TriOrdonnanceur {

	public SJFOrdonnanceur(int nbCoeur) {
		super(nbCoeur);
	}

	@Override
	protected boolean isSup(Task t1, Task t2) {
		if(t1.getDebut() == t2.getDebut()) {
			if(t1.getDuree() == t2.getDuree())
				return t1.getNum() > t2.getNum();
			else
				return t1.getDuree() > t2.getDuree();
		} else {
			return t1.getDebut() > t2.getDebut();
		}
				
	}

}
