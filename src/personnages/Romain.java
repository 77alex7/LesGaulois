package personnages;

public class Romain {
	private String nom;
	private int force;
	private static final int MAX=2;
	private Equipement[]equipementTab=new Equipement[MAX];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		assert force>0;
		this.nom = nom;
		this.force = force;
	}
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
			
			case 2:
				System.out.println("Le soldat "+ nom + " est dèjà bien protégé");
				break;
			case 1:
				if (equipementTab[0]==equipement) {
					System.out.println("Le soldat "+nom+" possède déja "+equipement+"!");
				}else {
					System.out.println("Le soldat s'équipe avec un "+equipement+".");
					equipementTab[1]=equipement;
					nbEquipement++;
				}
				break;
			case 0:
				equipementTab[0]=equipement;
				nbEquipement++;
				System.out.println("Le soldat s'équipe avec un "+equipement+".");
				break;
		}
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
		//romainminus.prendreParole();
		//romainminus.recevoirCoup(3);
		Equipement casque=Equipement.CASQUE;
		//System.out.println(casque);
		Equipement bouclier=Equipement.BOUCLIER;
		//System.out.println(bouclier);
		romainminus.sEquiper(casque);
		romainminus.sEquiper(casque);
		romainminus.sEquiper(bouclier);
		romainminus.sEquiper(casque);
	}

}
