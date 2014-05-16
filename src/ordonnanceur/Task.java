package ordonnanceur;

import java.util.Scanner;

public class Task {
	private int num, debut, duree, prio, effectue;
	private String intitule;
	public Task(){
		
	}
	/**
	 * Constructeur à partir d'un String
	 * @param chaine
	 */
	public Task(String chaine){
		Scanner sc = new Scanner(chaine);
		this.num = sc.nextInt();
		this.intitule = sc.next();
		this.debut = sc.nextInt();
		this.duree = sc.nextInt();
		String temp = sc.next();
		try{
			this.prio = Integer.parseInt(temp);
		}
		catch(NumberFormatException e){
			this.prio = 0;
		}
		sc.close();
	}
	/**
	 * Constructeur paramétré
	 * @param num
	 * @param debut
	 * @param duree
	 * @param prio
	 * @param intitule
	 */
	public Task(int num,int debut,int duree,int prio,String intitule){
		this.num = num;
		this.debut = debut;
		this.duree = duree;
		this.prio = prio;
		this.effectue = 0;
		this.intitule = intitule;
	}
	/**
	 * Constructeur de copie
	 * @param Task modele
	 */
	public Task(Task modele){
		this.num = modele.getNum();
		this.debut = modele.getDebut();
		this.duree = modele.getDuree();
		this.prio = modele.getPrio();
		this.effectue = modele.getEffectue();
		this.intitule = modele.getIntitule();
	}
	/**
	 * @return le num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @return le temps de debut
	 */
	public int getDebut() {
		return debut;
	}
	/**
	 * @return la prio
	 */
	public int getPrio() {
		return prio;
	}
	/**
	 * @return la duree
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * @return le temps effectue
	 */
	public int getEffectue() {
		return effectue;
	}
	/**
	 * @return le intitule
	 */
	public String getIntitule() {
		return intitule;
	}
	/**
	 * 
	 * @return L'etat de la tâche
	 */
	public boolean isFinished(){
		//si la durée est supérieure au temps déjà effectué
		if(duree-effectue>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 
	 * @param temps alloué à la tâche
	 * @return temps alloué - temps de traitement de la tâche
	 */
	public int effectuer(int temps){
		if(temps<effectue){
			effectue -= temps;
			return 0;
		}else{
			effectue = duree;
			return temps-effectue;
		}
	}
	/**
	 * 
	 * @return le temps de traitement qu'il reste à la tâche
	 */
	public int getReste(){
		return duree-effectue;
	}
}
