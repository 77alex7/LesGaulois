package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide" + nom +
				"et ma potion peut aller d'une force " + effetPotionMin + 
				" à " + effetPotionMax +".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + " << " +
	texte + ">>");	
	}
	private String prendreParole() {
		return "Le druide" + nom + " : ";
	}
	
	@Override
	public String toString() {
		return"Druide[nom="+nom+" effetPotionMin="+effetPotionMin+" effetPotionMax"+effetPotionMax+" forcePotion"+forcePotion+"]";
	}
	
	public void preparerPotion() {
		Random random=new Random();
		forcePotion=random.nextInt(effetPotionMax-effetPotionMin + 1);
		forcePotion=forcePotion+effetPotionMin;
		if (forcePotion>7) {
			parler("J'ai préparé une super potion de force"+forcePotion);
		}else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force"+ forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom().equals("Obélix")) {
			parler("Non,Obélix!... Tu n'aura pas de potion magique!");
		}else {
			preparerPotion();
			gaulois.boirePotion(forcePotion);
		}
		
		
		
		
	}
	
	public static void main(String[]args) {
		Druide druide1=new Druide("Panoramix",5,10);
		Gaulois asterix=new Gaulois("Asterix",8);
		Gaulois obelix1=new Gaulois("Obélix",25);
		druide1.preparerPotion();
		System.out.println(druide1.getNom());
		System.out.println(druide1);
		druide1.booster(obelix1);
		
	}
	
	
}
