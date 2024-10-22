package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillagois = 0;
	private Gaulois[] villagois;

	public Village(String nom, int nbMax) {
		this.nom = nom;
		villagois = new Gaulois[nbMax];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillagois < villagois.length) {
			villagois[nbVillagois] = gaulois;
			nbVillagois++;
		}
	}

	public Gaulois trouverHabitant(int numero) {
		return villagois[numero];

	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void afficherVillagois() {
		if (chef != null) {
			System.out.println("Le chef est " + chef.getNom());
		} else {
			System.out.println("pas de chef");
		}
		for (int i = 0; i < nbVillagois; i++) {
			System.out.print("Le villagois ");
			System.out.println(villagois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		Chef chef = new Chef("Abracourcix", 6, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		// village.afficherVillagois();
	}
}
