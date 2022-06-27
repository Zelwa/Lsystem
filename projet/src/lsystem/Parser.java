package lsystem;

import java.io.*;
import java.util.ArrayList;

public class Parser{
	File file;
	public String axiome;
	public ArrayList<ArrayList<String>> regles;
	public BufferedReader br;

	public Parser(File f){
		this.file = f;
		this.regles = new ArrayList<ArrayList<String>>();
	}

	//Methode qui lit les 2 premierse lignes du fichier donne
	public void lire(){
		try{
			FileReader in = new FileReader(this.file);
			br = new BufferedReader(in);

			int c = 0;

			for (String line = br.readLine(); line != null; line = br.readLine()){
				c ++;
				if (c == 1) {
					this.axiome = line;
				}
				if (c == 2) {
					String[] tabRegles = line.split(";"); //liste des regles

					for (int i=0; i<tabRegles.length; i++) {
						ArrayList<String> regle = new ArrayList<String>();
						String[] tabAvantApres = tabRegles[i].split("="); //liste des elements d'une regle

						for (int j=0; j<tabAvantApres.length; j++) {
							regle.add(tabAvantApres[j]); //tableau temporaire qui va etre ajoute dans la liste des regles
						}
						this.regles.add(regle);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Accesseur sur l'axiome la premiere ligne du fichier
	public String getAxiome(){
		return this.axiome;
	}

	//Methode qui retourne les regles la 2eme ligne du fichier
	public ArrayList<ArrayList<String>> getRegles(){
		return this.regles;
	}
}
