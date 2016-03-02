package TraceSecteur;


public class Point {
	private int coordX;
	private int coordY;
	
	public Point() {
		coordX=0;
		coordY=0;
	}

	public Point(String x,String y) {
		coordX=(int)(convertirdegresdecimal(x)/1000);
		coordY=(int)(convertirdegresdecimal(y)/1000);
	}
	
	public Point(double d1,double d2) {
		coordX=(int)d1;
		coordY=(int)d2;
	}
	
	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = (int)coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = (int)coordY;
	}

	
	public double convertirdegresdecimal(String x){
		double dataconvertie=0;
		double degres;
		double minutes;
		double secondes;
		boolean signenegatif=false;
		if(x.length()==11){
			if(((x.charAt(x.length()-1))=='W'))	signenegatif=true;
			else signenegatif=false;
			degres=Double.parseDouble(x.substring(0,3));
			minutes=Double.parseDouble(x.substring(4,6));
			secondes=Double.parseDouble(x.substring(7,9));	
		}
		else{
			if(((x.charAt(x.length()-1))=='S'))	signenegatif=true;
			else signenegatif=false;
			degres=Double.parseDouble(x.substring(0,2));
			minutes=Double.parseDouble(x.substring(3,5));
			secondes=Double.parseDouble(x.substring(6,8));
		}
		dataconvertie = (degres+(minutes/60)+(secondes/3600))*100000;
		if(signenegatif) return dataconvertie*(-1);
		else return dataconvertie;
	}
	

	public String toString() {	
		return "->x: "+coordX+"   ->y : "+coordY+"\n";
	}
}
