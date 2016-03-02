package TraceSecteur;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;





public class Visu extends JFrame {
	private ArrayList<Secteur> listeFIR;
	private ArrayList<Secteur> detailSecteursElementaires;
	private ArrayList<Balise> listebalises;
	private JPanel zoneSecteur;
	
	public Visu(){
		listeFIR= new ArrayList<Secteur>();
		detailSecteursElementaires = new ArrayList<Secteur>();
		listebalises=new ArrayList<Balise>();
		zoneSecteur=new JPanel();
		
		chargerCoordonneesBalises();
//		afficherCoordonnesBalisesdsTerminal();
		chargerSecteur();
//	    afficherSecteurdsTerminal();
	    chargerCoordonneesSecteurE();
//	    afficherCoordonneesSecteurdsTerminal();
	
	    incorporationBalisesDansSecteurE();
	    afficherBalisesDesSEdsTerminal();
	    
	    
	    
	   
	    
	    this.setTitle("Interface visualisation secteur aerien");
	    this.setSize(800, 800);
	    //this.setLocationRelativeTo(null);
	    //placer la fenetr eou on veut sur l'ecran
	    this.setLocation(400, 10);
	    //autoriser le redimensionnement de la fenetre
	    this.setResizable(true);  //false pour l'autoriser
	    //pour garder en premier plan mï¿½thode setAlwaysOnTop(boolean b)
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	
	    

//    	- une barre de menus
    	JMenuBar jmb = new JMenuBar();
    	JMenu menuGerer = new JMenu("Gerer");
    	jmb.add(menuGerer);
    	this.setJMenuBar(jmb);
    	JMenuItem menuCharger = new JMenuItem("Charger fichier vol");
    	JMenuItem  menuQuitter = new JMenuItem("Quitter");
    	menuGerer.add(menuCharger);
    	menuGerer.addSeparator();
    	menuGerer.add(menuQuitter);
        
    	
    	menuQuitter.addActionListener(new ActionQuitter());
    	
    	Container contenu = this.getContentPane();
    	affichageSecteurdsInterface();
    	contenu.add(this.zoneSecteur);
	    this.setVisible(true);
	  }
	
	public void afficherBalisesDesSEdsTerminal(){
		ArrayList<Balise> lb=new ArrayList<Balise>();
		for(Secteur s:detailSecteursElementaires){
			lb=s.getListebalises();
			int compteur =0;
			for(Balise b:lb){
				System.out.println(b);	
				compteur++;
			}
			System.out.println("nombre de balises pour le secteur : "+s.getIndicatif()+" : "+compteur);
		}
	}
	
	
	public void incorporationBalisesDansSecteurE(){
		int [] x=null;
		int [] y=null;
			for(Secteur s:detailSecteursElementaires){
				Polygone poly = s.getListepoints();
				x=new int[poly.nombredepointstotal()];
				y=new int[poly.nombredepointstotal()];
				ArrayList<Balise> lb=new ArrayList<Balise>();
				int minx, miny,maxx,maxy;
				miny=minx=Integer.MAX_VALUE;
			    maxy=maxx=Integer.MIN_VALUE;
			    //on récupére les coordonnées min et max de chaque secteur
			    for(int i=0;i<poly.nombredepointstotal();i++){
						Point p=poly.getPoint(i);
						x[i]=(int) p.getCoordX();
						y[i]=(int) p.getCoordY();
				//		System.out.println("Notre point : "+p);
				//		System.out.println("valeur de x : "+x[i]);
				//		System.out.println("valeur de y : "+y[i]);
						if (x[i] < minx) {
							minx = x[i];
						} else if (x[i] > maxx) {
							maxx = x[i];
						}
						y[i]=(int) p.getCoordY();
						if (y[i] < miny) {
							miny = y[i];
						} else if (y[i] > maxy) {
							maxy = y[i];
						}
				}
					//System.out.println("nom du secteur : "+s.getIndicatif());
					//System.out.println(String.format("x: [%d-%d], y: [%d-%d]",minx,maxx,miny,maxy));
					for(Balise b:listebalises){
						if((b.getCoord_latitude()>=minx) && (b.getCoord_latitude()<=maxx)){
							if((b.getCoord_longitude()>=miny) && (b.getCoord_longitude()<=maxy)){
								lb.add(new Balise(b.getNom(),b.getCoord_latitude(),b.getCoord_longitude()));
							//	System.out.println("Nom: "+b.getNom()+" lat: "+b.getCoord_latitude()+" long: "+b.getCoord_longitude());	
							}
						}
					}
					s.setListebalises(lb);
			}	
	}
	
	
	
	
	public void affichageSecteurdsInterface(){
		repaint();
	}
	
	
	public void paint(Graphics g) { 
		Secteurgraphique sg=new Secteurgraphique();
    	super.paint(g);
    	sg.dessiner(g, this.zoneSecteur, detailSecteursElementaires);
    } 													
	

	
	
	
	
	public void afficherCoordonnesBalisesdsTerminal(){
		for(Balise b:listebalises){
			System.out.println(b);
		}
		
	}
	
	public void chargerCoordonneesBalises(){
		String nomfic="Balises.txt";
		BufferedReader fe;
		String tampon=null;
		try {
			fe=new BufferedReader(new FileReader(nomfic));
			while((tampon=fe.readLine()) != null){
				StringTokenizer t = new StringTokenizer(tampon,",");
				double longitudebal=Double.parseDouble((String) t.nextElement());
				double latitudebal=Double.parseDouble((String) t.nextElement());
				String informationbal=(String) t.nextElement();
				informationbal=informationbal.substring(1, informationbal.length()-1);
				StringTokenizer t2 = new StringTokenizer(informationbal," ");
				String poubelle=(String) t2.nextElement();
				String nombalise = (String) t2.nextElement();
				listebalises.add(new Balise(nombalise,latitudebal,longitudebal));
				}
			
			fe.close();
		} catch (IOException e) {
			System.out.println("Probleme de chargement du fichier...");
			e.printStackTrace();
		}
	}
		
	
	
	public void afficherCoordonneesSecteurdsTerminal(){
		for(Secteur s:detailSecteursElementaires){
			System.out.println(s);
		}
	}
	
	
	public void chargerCoordonneesSecteurE(){
		String nomfic="coordFIRv1.txt";
		BufferedReader fe;
		String tampon=null;
		try{
			fe=new BufferedReader(new FileReader(nomfic));
			while((tampon=fe.readLine()) != null){
				ArrayList<Polygone> listedepoints=new ArrayList<Polygone>();				
				Polygone poly=new Polygone();
				StringTokenizer t = new StringTokenizer(tampon," ");
				String nomdusecteur=(String) t.nextElement();
				String FL_h=(String) t.nextElement();
				String FL_l=(String) t.nextElement();
				while (t.hasMoreTokens()) {
					String chaine = (String) t.nextElement();
					if(chaine.equals(",") || chaine.equals("--") || chaine.equals("")==true){
						String poubelle=chaine;
					}
					else{
						String latitude=chaine;
						String poubelle=(String) t.nextElement();
						String longitude=(String) t.nextElement();
						//on crï¿½e un point avec les coordonnï¿½es rï¿½cupï¿½rï¿½es
						if(!latitude.equals("Frontière")){	
							Point p=new Point(latitude,longitude);
							//on affecte ce point au polygone constituant notre secteur
							poly.setPoint(p);
						}
					}	
				}
				detailSecteursElementaires.add(new Secteur(nomdusecteur, poly));				
			}		
			fe.close();
	} catch (IOException e) {
		System.out.println("Probleme de chargement du fichier...");
		e.printStackTrace();
	} 	
	}
	
	public void afficherSecteurdsTerminal(){
		ArrayList<Secteur> secteursElementaires = new ArrayList<Secteur>();
		for (Secteur s:listeFIR){
			secteursElementaires=s.getListesecteurs();
			System.out.println(s.getIndicatif() + " a pour secteur elementaire : ");
			for(Secteur se:secteursElementaires){
				System.out.println(se.getIndicatif());
			}
		}	
	}
	
	
	
	public void chargerSecteur(){
		String nomfic="listeSecteur.txt";
		BufferedReader fe;
		Secteur secteur=new Secteur();
		Secteur se=new Secteur();
		String tampon=null;
		try{
			fe=new BufferedReader(new FileReader(nomfic));
			while((tampon=fe.readLine()) != null){
				ArrayList<Secteur> listeSecteurE=new ArrayList<Secteur>();
				StringTokenizer t = new StringTokenizer(tampon," ");
				String nomdusecteur=(String) t.nextElement();
				secteur.setIndicatif(nomdusecteur);
				 while (t.hasMoreTokens()) {			
					 String nomdusoussecteur=(String) t.nextElement();
					 se.setIndicatif(nomdusoussecteur);
					 listeSecteurE.add(new Secteur(nomdusoussecteur));
				}
				 secteur.setListesecteurs(listeSecteurE);			
				listeFIR.add(new Secteur(nomdusecteur,listeSecteurE)); 
			}
			fe.close();
	} catch (IOException e) {
		System.out.println("Probleme de chargement du fichier...");
		e.printStackTrace();
	} 
	
	}
//  classes  inner des listeners des composants :
    //---------------------------------------------------------
    class ActionQuitter implements ActionListener {
    	public void actionPerformed(ActionEvent arg0) {
    		System.exit(0);
    	}
    }
}
