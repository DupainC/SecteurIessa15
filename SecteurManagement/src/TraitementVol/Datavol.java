package TraitementVol;
import java.util.ArrayList;


public class Datavol implements Comparable {
	private double temps;
	private String tempsh;
	private String id_avion;
	private int numerovol;
	private String altitude;
	private String vitesse;
	private double latitude;
	private double longitude;
	
	public Datavol(){
		this.temps=0;
		this.id_avion="XXXXX";
		this.numerovol=0;
		this.altitude="x";
		this.vitesse="x";
		this.latitude=0;
		this.longitude=0;
	}

	public Datavol(double t,String id,int num,String alt,String vit,double lat,double lg){
		this.temps=t;
		this.tempsh="";
		this.id_avion=id;
		this.numerovol=num;
		this.altitude=alt;
		this.vitesse=vit;
		this.latitude=lat;
		this.longitude=lg;
	}
	
	public Datavol(String t,String id,int num,String alt,String vit,double lat,double lg){
		this.temps=0;
		this.tempsh=t;
		this.id_avion=id;
		this.numerovol=num;
		this.altitude=alt;
		this.vitesse=vit;
		this.latitude=lat;
		this.longitude=lg;
	}
	
	
	public double getTemps() {
		return temps;
	}

	public void setTemps(double temps) {
		this.temps = temps;
	}

	public String getId_avion() {
		return id_avion;
	}

	public void setId_avion(String id_avion) {
		this.id_avion = id_avion;
	}

	public int getNumerovol() {
		return numerovol;
	}

	public void setNumerovol(int numerovol) {
		this.numerovol = numerovol;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getVitesse() {
		return vitesse;
	}

	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getTempsh() {
		return tempsh;
	}

	public void setTempsh(String tempsh) {
		this.tempsh = tempsh;
	}

	public String toString() {	
		if(temps!=0){
			return this.temps+" "+this.id_avion+" "+this.numerovol+" "+this.altitude+" "+this.vitesse+" "+this.latitude+" "+this.longitude;
		}
		else{
			return this.tempsh+" "+this.id_avion+" "+this.numerovol+" "+this.altitude+" "+this.vitesse+" "+this.latitude+" "+this.longitude;
		}
	}

	//on redéfinit compareTo
	public int compareTo(Object other) {
		 int result;
		 double t1=((Datavol) other).getTemps();
		 double t2=this.getTemps();
		  if(t1>t2){
			  result = -1;
		  }
		  else if(t1==t2){
			  result = 0;
		  }
		  else
		  {    
		    result=1;
		  }
		return result;
	}
}
