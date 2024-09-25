package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert force>0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}
	private String prendreParole() {
		return"Le romain"+nom+":";
	}

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int avant=force;
		force-=forceCoup;
		if (force>0) {
			parler("Aie");
		}else {
			parler("J'abandonne...");	
		}
		assert force<avant;
	}
	@Override
	public String toString() {
		return"Romain[nom="+nom+",force="+force+"]";
	}
	
	public static void main(String[]args) {
		Romain romainminus=new Romain("Romain minus",6);
		System.out.println(romainminus.getNom());
		System.out.println(romainminus);
		romainminus.prendreParole();
		romainminus.parler("avadakedabra");
		romainminus.recevoirCoup(-2);
		
		
	}

}
