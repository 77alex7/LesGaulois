package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + ":";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois[nom=" + nom + ",force=" + force + ",effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int effetPotion) {
		force = effetPotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée");
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		//Gaulois obelix1 = new Gaulois("Obélix", 25);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		Romain romain1 = new Romain("Romain1", 9);
		asterix.frapper(romain1);

	}

}
