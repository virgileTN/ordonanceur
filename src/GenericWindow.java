import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GenericWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GenericWindow(){
		build("Ordonnanceur v0.0",800,600,true);
	}
	public GenericWindow(String title, int sizeX,int sizeY,boolean resizable){
		build(title,sizeX,sizeY,resizable);
	}
	private void build(String title, int sizeX,int sizeY,boolean resizable){
		setTitle(title);
		setSize(sizeX,sizeY);
		setLocationRelativeTo(null);
		setResizable(resizable);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.gray);
		for(int i=0;i<100;i++){
			JLabel label = new JLabel("mon texte "+i);
			panel.add(label);
		}
		JButton bouton = new JButton("Cliquez ici !");
		panel.add(bouton);
		JButton bouton1 = new JButton("Cliquez la !");
		panel.add(bouton1);
		return panel;

	}
}
