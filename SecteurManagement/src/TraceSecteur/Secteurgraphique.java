package TraceSecteur;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Secteurgraphique {//extends Secteur {
	public void dessiner(Graphics gr, JPanel jp,ArrayList<Secteur> listes) {
		int [] x=null;
		int [] y=null;
       // Graphics g = jp.getGraphics();
		Graphics2D g2 = (Graphics2D) gr;
        int minx, miny,maxx,maxy;
        miny=minx=Integer.MAX_VALUE;
        maxy=maxx=Integer.MIN_VALUE;
        
        g2.setColor(Color.BLACK);
     //   g2.translate(-1600, 400); //offset
        g2.translate(-4200, 300);
      //  g2.scale(8, 8); //zoom
 //       g2.setStroke(new BasicStroke(1));
        
        for(Secteur s:listes){
			Polygone poly = s.getListepoints();
//			System.out.println("taille du polygone : "+poly.nombredepointstotal());
			Point p=new Point();
			x=new int[poly.nombredepointstotal()];
			y=new int[poly.nombredepointstotal()];
			for(int i=0;i<poly.nombredepointstotal();i++){
				p=poly.getPoint(i);
//				System.out.println("Notre point : "+p);
				x[i]=(int) p.getCoordX();
				if (x[i] < minx) {
					minx = x[i];
				} else if (x[i] > maxx) {
					maxx = x[i];
				}
//				System.out.println("valeur de x : "+x[i]);
				y[i]=(int) p.getCoordY();
				if (y[i] < miny) {
					miny = y[i];
				} else if (y[i] > maxy) {
					maxy = y[i];
				}
//				System.out.println("valeur de y : "+y[i]);
			}
			g2.drawPolygon(x, y, x.length);
        }
			
        for(Secteur s:listes){
			Polygone poly = s.getListepoints();
			ArrayList<Balise> lb=s.getListebalises();
        	int xb,yb;
			xb=yb=0;
			for(int j=0;j<lb.size();j++){
				Balise b1=lb.get(j);
				xb=(int) b1.getCoord_latitude();
				yb=(int) b1.getCoord_longitude();
			//	System.out.println("xb "+xb);
			//	System.out.println("yb "+yb);
			//	g2.drawRect((xb/100)-2, (yb/100)-2, 4, 4);
				g2.setColor(Color.RED);
				g2.fillRect((xb/100)-2, (yb/100)-2, 4, 4);
				//g2.setColor(Color.RE);
				g2.drawString(b1.getNom(), (xb/100)-5, (yb/100)-5);
			}
			 
	}
        System.out.println(String.format("x: [%d-%d], y: [%d-%d]",minx,maxx,miny,maxy));
        //g2.drawLine(10, 10, 100, 100);

        
        
    }
}
