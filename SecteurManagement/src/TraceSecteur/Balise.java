package TraceSecteur;

public class Balise {
	private final static int COEFFICIENT = 100;
	private String nom;
	//private Temps heurepassage;
	//private int flylevel;
	private int coord_latitude;
	private int coord_longitude;
	
	public Balise(){
		this.nom="Inconnu";
	//	this.heurepassage=new Temps();
	//	this.flylevel=0;
		coord_latitude=0;
		coord_longitude=0;
	}

	
	public Balise(String nom, float tps, String fl, double latitude, double longitude){
		Temps t=new Temps();
		this.nom=nom;
	//	this.heurepassage=t.convertirTemps(tps);
	//	this.flylevel=Integer.parseInt(fl);
		this.coord_latitude=(int) (latitude*COEFFICIENT);
		this.coord_longitude=(int) (longitude*COEFFICIENT);
	}

	public Balise(String nom, double latitude, double longitude){
		Temps t=new Temps();
		this.nom=nom;
		this.coord_latitude=(int) (latitude*COEFFICIENT);
		this.coord_longitude=(int) (longitude*COEFFICIENT);
	}
	
	public double getCoord_latitude() {
		return coord_latitude;
	}

	public void setCoord_latitude(double coord_latitude) {
		this.coord_latitude = (int) (coord_latitude*COEFFICIENT);
	}

	public double getCoord_longitude() {
		return coord_longitude;
	}

	public void setCoord_longitude(double coord_longitude) {
		this.coord_longitude = (int) (coord_longitude*COEFFICIENT);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

/*	public Temps getHeurepassage() {
		return heurepassage;
	}

	public void setHeurepassage(Temps heurepassage) {
		this.heurepassage = heurepassage;
	}

	public int getFlylevel() {
		return flylevel;
	}

	public void setFlylevel(int flylevel) {
		this.flylevel = flylevel;
	}														*/

	public String toString() {	
		return this.nom+"   	Coord ("+coord_latitude/COEFFICIENT+","+coord_longitude/COEFFICIENT+")";//+this.heurepassage+"   "+this.flylevel;
	}
}
