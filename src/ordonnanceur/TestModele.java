package ordonnanceur;

import java.io.FileNotFoundException;

public class TestModele {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Modele mod = new Modele(1, "FIFO", "test.txt", 0);
			Console cons = new Console();
			cons.print(mod.getResult());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
