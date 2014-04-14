import javax.swing.SwingUtilities;


public class TestSwing {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				GenericWindow fenetre = new GenericWindow();
				fenetre.setVisible(true);
			}
		});
	}
}
