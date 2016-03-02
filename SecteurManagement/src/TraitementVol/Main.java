package TraitementVol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args){         
/*	  	String nomfic="Vol_total.txt";
	  //	String nomfic="/media/commun_mialp_eleves/temp/Data_Vol_12_03_21.txt";
	  //	String nomfic="Vol.txt";
		BufferedReader fe;
		String tampon=null;
		String poubelle=null;
		double tps=0;
		String id_avion=null;
		int numerovol=0;
		String altitude=null;
		double latitude=0;
		double longitude=0;
		String vitesse=null;
		ArrayList<Datavol> listedatavol=new ArrayList<Datavol>();
		try{
			fe=new BufferedReader(new FileReader(nomfic));
			for(int i=0;i<9;i++){
				poubelle=fe.readLine();
			}
			while((tampon=fe.readLine()) != null){		
				StringTokenizer t = new StringTokenizer(tampon," ");
				if(!tampon.equals("")){
					tps = Double.parseDouble((String) t.nextElement());
					id_avion=(String) t.nextElement();
					numerovol=Integer.parseInt((String) t.nextElement());
					for(int j=4;j<26;j++){
						poubelle=(String) t.nextElement();
					}
					latitude=Double.parseDouble((String) t.nextElement());
					longitude=Double.parseDouble((String) t.nextElement());
					for(int j=28;j<33;j++){
						poubelle=(String) t.nextElement();
					}
					altitude=(String) t.nextElement();
					vitesse=(String) t.nextElement();
					listedatavol.add(new Datavol(tps,id_avion,numerovol,altitude,vitesse,latitude,longitude));
				}
			}										
			fe.close();
	} catch (IOException e) {
		System.out.println("Probleme de chargement du fichier...");
		e.printStackTrace();
	} 	
		

		
		//on trie les donnees de vol par ordre chronologique
		Collections.sort(listedatavol);
		//Arrays.sort(listedatavol);
	
	    
	    for(Datavol d:listedatavol){
			//System.out.println(d);
		}		
	    
	    //generation d'un fichier trié
	    BufferedWriter f1;
	    nomfic="datavol.txt";
	    try {
			f1=new BufferedWriter(new FileWriter(nomfic));
			for (Datavol d:listedatavol) {
				Scanner sc = new Scanner(d.toString()); 
				sc.useDelimiter(" ");
				f1.write(sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+"\n");	
				//fs.newLine();
				//fs.write("\n");
				sc.close(); 
			}
			f1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  																										
	    
	    
	    //traitement du fichier datavol.txt généré pour en faire un fichier horodaté
	    	nomfic="datavol.txt";
			BufferedReader f2;
			tampon=null;
			tps=0;
			String tpsconverti;
			id_avion=null;
			numerovol=0;
			altitude=null;
			latitude=0;
			longitude=0;
			vitesse=null;
			ArrayList<Datavol> listedatavolhorodate=new ArrayList<Datavol>();
			try{
				f2=new BufferedReader(new FileReader(nomfic));
				while((tampon=f2.readLine()) != null){		
					StringTokenizer t = new StringTokenizer(tampon," ");
					if(!tampon.equals("")){
						tps = Double.parseDouble((String) t.nextElement());
						//on convertit le temps initialement en double au format "heures:minutes:secondes"
						Date date = new Date((long) (tps*1000));
						DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
						tpsconverti=mediumDateFormat.format(date);
						id_avion=(String) t.nextElement();
						numerovol=Integer.parseInt((String) t.nextElement());
						altitude=(String) t.nextElement();
						vitesse=(String) t.nextElement();
						latitude=Double.parseDouble((String) t.nextElement());
						longitude=Double.parseDouble((String) t.nextElement());
						listedatavolhorodate.add(new Datavol(tpsconverti,id_avion,numerovol,altitude,vitesse,latitude,longitude));
					}
				}										
				f2.close();
		} catch (IOException e) {
			System.out.println("Probleme de chargement du fichier...");
			e.printStackTrace();
		} 	
			
			
			
	    //generation d'un fichier horodaté
		Datavol d1=listedatavolhorodate.get(1);
		String pourcreerfichier=d1.getTempsh();
		StringTokenizer t = new StringTokenizer(pourcreerfichier," ");
		String jour=(String) t.nextElement();
		String mois=(String) t.nextElement();
		String annee=(String) t.nextElement();
		String pasbesoin=null;
	    BufferedWriter f3;
	    nomfic="datavol_"+jour+"_"+mois+"_"+annee+".txt";
	    try {
			f3=new BufferedWriter(new FileWriter(nomfic));
			for (Datavol d:listedatavolhorodate) {
				
				Scanner sc = new Scanner(d.toString()); 
				sc.useDelimiter(" ");
				for(int i=0;i<3;i++){
					pasbesoin=sc.next();
				}
				f3.write(sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+"\n");	
				sc.close(); 
			}
			f3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  																			*/
	    
	    
	    
	    
	    //génération d'un fichier avec des données minutes
	    String nomfic="datavol_21_mars_2012.txt";
		BufferedReader f4;
		String tampon=null;
		String  tempssanslessecondes=null;
		String tempsprecedent=null;
		String id_avionprecedent=null;
		String datavolasupprimer;
		String id_avion=null;
		int numerovol=0;
		String altitude=null;
		double latitude=0;
		double longitude=0;
		String vitesse=null;
		ArrayList<Datavol> listedatavolepure=new ArrayList<Datavol>();
		ArrayList<String> derniereheure=new ArrayList<String>();
		derniereheure.add(null);
		try{
			f4=new BufferedReader(new FileReader(nomfic));
			while((tampon=f4.readLine()) != null){		
				StringTokenizer t = new StringTokenizer(tampon," ");
				if(!tampon.equals("")){
						//System.out.println("\n"+tampon);
						tempssanslessecondes = ((String) t.nextElement()).substring(0, 5);
						id_avion=(String) t.nextElement();
						numerovol=Integer.parseInt((String) t.nextElement());
						altitude=(String) t.nextElement();
						vitesse=(String) t.nextElement();
						latitude=Double.parseDouble((String) t.nextElement());
						longitude=Double.parseDouble((String) t.nextElement());
						if(derniereheure.size()<=numerovol){
							derniereheure.ensureCapacity(numerovol+2);
							derniereheure.set(numerovol,"ok");
						}
						if(!tempssanslessecondes.equals(derniereheure.get(numerovol))){
							listedatavolepure.add(new Datavol(tempssanslessecondes,id_avion,numerovol,altitude,vitesse,latitude,longitude));
							derniereheure.set(numerovol, tempssanslessecondes);
						}
		
						
				}
			}
													
			f4.close();
	} catch (IOException e) {
		System.out.println("Probleme de chargement du fichier...");
		e.printStackTrace();
	} 	
	    
		
		//generation d'un fichier horodaté et epuré
				String pasbesoin=null;
			    BufferedWriter f5;
			    //nomfic="donneevol_"+jour+"_"+mois+"_"+annee+".txt";
			   nomfic="donneevol_21_mars_2012.txt";
			    try {
					f5=new BufferedWriter(new FileWriter(nomfic));
					for (Datavol d:listedatavolepure) {
						Scanner sc = new Scanner(d.toString()); 
						sc.useDelimiter(" ");
						f5.write(sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next()+" "+"\n");	
						sc.close(); 
					}
					f5.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  					
			    
			    System.out.println("Fichier généré");
  }       
}