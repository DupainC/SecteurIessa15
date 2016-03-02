package TraceSecteur;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Polygone  extends JPanel {
	private ArrayList<Point> contour;

	public Polygone() {
		contour=new ArrayList<Point>();
	}
	public Polygone(ArrayList<Point> liste_point) {
		contour=liste_point;
	}
	
	public void setPoint(Point p) {
		contour.add(p);
	}
	public Point getPoint(int index){
		return contour.get(index);
	}
	public int nombredepointstotal(){
		return contour.size();
	}
	public void removePoint(Point p) {
		contour.remove(p);
	}
	
	public ArrayList<Point> getContour() {
		return contour;
	}

	public void setContour(ArrayList<Point> contour) {
		this.contour = contour;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int [] x=new int[contour.size()];
		int [] y=new int[contour.size()];
		System.out.println(contour.size());
	/*	for (int i=0;i<contour.size();i++){
			x[i]=(int)(contour.get(i)).getCoord_X();
			System.out.println("val x :"+x[i]);
			y[i]=(int)(contour.get(i)).getCoord_Y();
			System.out.println("val y :"+y[i]);
		}
		g.drawPolygon(x,y,x.length);
		g.fillPolygon(x,y,x.length);		*/
	}
	

	public String toString() {	
		String chaine ="";
		for (Point p:contour)
			chaine = chaine +" " + p;  
		return "Notre polygone :\n" +chaine;
	}
}
