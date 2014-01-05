package projet.model;

public class Commande {
	
	public enum BoissonType {
		cocacola, eau, jusdefruits, biere;
	}
	
	public enum FormuleType {
		aucune,
		plat_boisson,
		plat_dessert_boisson,
		entree_plat;
	}

	public enum DessertType {
		compote, yaourt, clementine;
	}
	
	public enum PlatType {
		pizza, quiche, sandwich;
	}
	
	public enum EntreeType {
		salade, terrine;
	}
	
	public enum PaiementType {
		monnaie, moneo;
	}
		
	private static int PRIX_ENTREE = 2;
	private static int PRIX_PLAT = 4;
	private static int PRIX_BOISSON = 1;
	private static int PRIX_DESSERT = 2;
	
	
	private String identifiant;
	private FormuleType formule = FormuleType.plat_boisson;
	private EntreeType entree = EntreeType.salade;
	private PlatType plat = PlatType.quiche;
	private DessertType dessert;
	private BoissonType boisson;
	private PaiementType paiement;

	public Commande(){
	}
	
	public FormuleType getFormule() {
		return formule;
	}

	public void setFormule(FormuleType formule) {
		this.formule = formule;
	}
	public EntreeType getEntree() {
		return entree;
	}

	public void setEntree(EntreeType entree) {
		this.entree = entree;
	}

	public PlatType getPlat() {
		return plat;
	}

	public void setPlat(PlatType plat) {
		this.plat = plat;
	}

	public DessertType getDessert() {
		return dessert;
	}

	public void setDessert(DessertType dessert) {
		this.dessert = dessert;
	}

	public BoissonType getBoisson() {
		return boisson;
	}

	public void setBoisson(BoissonType boisson) {
		this.boisson = boisson;
	}

	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String id){
		this.identifiant = id;
	}
	public PaiementType getPaiement() {
		return paiement;
	}
	public void setPaiement(PaiementType p) {
		this.paiement = p;
	}

	public int getPrix() {
		switch(this.formule){
		case entree_plat :
			return PRIX_ENTREE + PRIX_PLAT;
		case plat_boisson :
			return PRIX_BOISSON + PRIX_PLAT;
		case plat_dessert_boisson :
			return PRIX_BOISSON + PRIX_PLAT + PRIX_DESSERT;
		case aucune :
			int prix = 0;
			if(entree != null){
				prix += PRIX_ENTREE;
			}
			if(plat != null){
				prix += PRIX_PLAT;
			}
			if(dessert != null){
				prix += PRIX_DESSERT;
			}
			if(boisson != null){
				prix += PRIX_BOISSON;
			}
			return prix;
		default: 
			return 0;
		}
	}
}
