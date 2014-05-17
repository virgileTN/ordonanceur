package ordonnanceur;

public class FIFOOrdonnanceur extends TriOrdonnanceur {

	public FIFOOrdonnanceur(int nbCoeur) {
		super(nbCoeur);
	}

	@Override
	protected boolean isSup(Task t1, Task t2) {
		if(t1.getDebut() == t2.getDebut())
			return t1.getNum() > t2.getNum();
		else
			return t1.getDebut() > t2.getDebut();
	}

}
