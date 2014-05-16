package ordonnanceur;

public class Test {
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		test_Task_effectuer();
		test_toString();
		
	}
	public static boolean test_Task_effectuer(){
		boolean ok = true;
		Task t = new Task(1,0,10,0,"test");
		if(t.effectuer(5)!=0){
			ok = false;
		}
		if(t.effectuer(8)!=3){
			ok = false;
		}
		if(t.effectuer(8)!=8){
			ok = false;
		}
		if(ok){
			System.out.println("Task_effectuer() [OK]");
			return true;
		}else{
			System.out.println("Task_effectuer() [NOK]");
			return false;
		}
	}
	public static void test_toString(){
		Task t = new Task(1,0,10,0,"test");
		t.effectuer(5);
		System.out.println(t.toString());
	}
	

}
