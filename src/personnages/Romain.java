package personnages;

public class Romain {
	private String nom;
	private int force;
	private static final int MAX = 2;
	private Equipement[] equipementTab = new Equipement[MAX];
	private int nbEquipement = 0;
	//private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert invariant(force);
	}

	private boolean invariant(int force) {
		return force > 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {

		case 2:
			System.out.println("Le soldat " + nom + " est dèjà bien protégé");
			break;
		case 1:
			if (equipementTab[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déja " + equipement + "!");
			} else {
				System.out.println("Le soldat s'équipe avec un " + equipement + ".");
				equipementTab[nbEquipement] = equipement;
				nbEquipement++;
			}
			break;
		case 0:
			System.out.println("Le soldat s'équipe avec un " + equipement + ".");
			equipementTab[nbEquipement] = equipement;
			nbEquipement++;
			break;

		default:
			break;
		}
	}

	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + ":";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int avant=force;
//		force-=forceCoup;
//		assert invariant(force):"Invariant fin";
//		if (force>0) {
//			parler("Aie");
//		}else {
//			parler("J'abandonne...");	
//		}
//		assert force<avant;
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup= calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		if (force==0) {
			parler("Aïe");
		}else {
		equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipementTab[i] != null && equipementTab[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) {
			forceCoup=0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipementTab[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipementTab[i];
				nbEquipementEjecte++;
				equipementTab[i] = null;
			}
		}
		return equipementEjecte;
	}

	@Override
	public String toString() {
		return "Romain[nom=" + nom + ",force=" + force + "]";
	}

	public static void main(String[] args) {
		Romain romainminus = new Romain("Romain minus", 6);
		System.out.println(romainminus.getNom());
		System.out.println(romainminus);
		// romainminus.prendreParole();
		// romainminus.recevoirCoup(3);
		Equipement casque = Equipement.CASQUE;
		// System.out.println(casque);
		Equipement bouclier = Equipement.BOUCLIER;
		// System.out.println(bouclier);
		romainminus.sEquiper(casque);
		romainminus.sEquiper(casque);
		romainminus.sEquiper(bouclier);
		romainminus.sEquiper(casque);
	}

}
