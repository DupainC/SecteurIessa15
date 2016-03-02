package TraceSecteur;


public class Temps {//extends time{
	private int heure;
	private int minute;
	
	
	public Temps(){
		this.heure=0;
		this.minute=0;
	}
	public Temps(int h, int m){
		this.heure=h;
		this.minute=m;	
	}
	public Temps(float nbre){
	//	this.heure=0;
	//	this.minute=0;	
		this.heure=(int) nbre;
	}
	
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public String toString() {	
		return "Temps :" +this.heure+":"+this.minute;
	}
	public void trierTemps(){
		
	}
	public Temps convertirTemps(Float temp){
		Temps tps=new Temps();
		
		return tps;
	}
}
