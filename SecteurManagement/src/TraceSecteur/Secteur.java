package TraceSecteur;
import java.util.ArrayList;


public class Secteur {
	private String indicatif;
	private int FlyLevelHigh;
	private int FlyLevelLow;
	private ArrayList<Secteur> listesecteurs;
	private Polygone listepoints;
	private ArrayList<Balise> listebalises;
	
	public Secteur() {
		FlyLevelHigh=0;
		FlyLevelLow=0;
		listesecteurs=new ArrayList<Secteur>();
		listebalises=new ArrayList<Balise>();
		listepoints=new Polygone();
		
	}

	public Secteur(String nom) {
		indicatif=nom;
		FlyLevelHigh=0;
		FlyLevelLow=0;
		listesecteurs=new ArrayList<Secteur>();
		listebalises=new ArrayList<Balise>();
		listepoints=new Polygone();
		
	}
	public Secteur(String nom, ArrayList<Secteur> ls){
		indicatif=nom;
		FlyLevelHigh=0;
		FlyLevelLow=0;
		listesecteurs=ls;
		listebalises=new ArrayList<Balise>();
		listepoints=new Polygone();
		
	}
	
	public Secteur(String nom, Polygone p) {
		indicatif=nom;
		FlyLevelHigh=0;
		FlyLevelLow=0;
		listesecteurs=null;
		listebalises=new ArrayList<Balise>();
		listepoints=p;
		
	}
	
	
	public ArrayList<Balise> getListebalises() {
		return listebalises;
	}

	public void setListebalises(ArrayList<Balise> listebalises) {
		this.listebalises = listebalises;
	}

	public String getIndicatif() {
		return indicatif;
	}

	public void setIndicatif(String indicatif) {
		this.indicatif = indicatif;
	}

	public int getFlyLevelHigh() {
		return FlyLevelHigh;
	}
	
	public void setFlyLevelHigh(int flyLevelHigh) {
		FlyLevelHigh = flyLevelHigh;
	}

	public int getFlyLevelLow() {
		return FlyLevelLow;
	}

	public void setFlyLevelLow(int flyLevelLow) {
		FlyLevelLow = flyLevelLow;
	}

	public Polygone getListepoints() {
		return listepoints;
	}

	public void setListepoints(Polygone listepoints) {
		this.listepoints = listepoints;
	}
	public String toString() {	
		//String chaine1 = this.indicatif + "     ->FL_haut: "+FlyLevelHigh+"   ->FL_bas : "+FlyLevelLow+"\n"+"est constitué de :\n";
		String chaine1 = "Le secteur "+this.indicatif+"\n"; 
		String chaine2="";
		if (this.listepoints !=null){
			for(int i=0;i<listepoints.nombredepointstotal();i++){
				Point p= listepoints.getPoint(i);
				chaine2 = chaine2+p;
			}
		}	
		
		
/*		if (this.listesecteurs !=null){
			for(int i=0;i<this.listesecteurs.size();i++){
				System.out.println(this.listesecteurs.get(i));
				
				chaine3 = this.listesecteurs.get(i)+"\n";
			}
		}							*/		
		return chaine1+chaine2;
	}

	public ArrayList<Secteur> getListesecteurs() {
		return listesecteurs;
	}

	public void setListesecteurs(ArrayList<Secteur> listesecteurs) {
		this.listesecteurs = listesecteurs;
	}
/*	public int size(){
		int compteur=0;
		for(int i=0;i<listesecteurs.size();i++){
			compteur++;		
		}
		return compteur;
	}		*/
}
