package ordonnanceur;

public class CoeurTest {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		//test_toString();
		test_effectuer();
	}
	public static void test_effectuer(){
		boolean ok = true;
		Coeur c = new Coeur();
		c.addTask(new Task(1,0,10,0,"t1"));
		c.addTask(new Task(1,0,10,0,"t2"));
		c.addTask(new Task(1,0,10,0,"t3"));
		c.addTask(new Task(1,0,10,0,"t4"));
		System.out.println(c.toString());
		c.effectuer(15);
		System.out.println(c.toString());
		c.effectuer(150);
		System.out.println(c.toString());
	}
	public static void test_toString(){
		Coeur c = new Coeur();
		c.addTask(new Task(1,0,10,0,"t1"));
		c.addTask(new Task(1,0,10,0,"t2"));
		c.addTask(new Task(1,0,10,0,"t3"));
		c.addTask(new Task(1,0,10,0,"t4"));
		System.out.println(c.toString());
	}
}
