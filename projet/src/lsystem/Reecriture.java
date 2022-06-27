package lsystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reecriture{
	private int nbIt;
	private ArrayList<ArrayList<String>> regles;
	private String lsystem;

	//Construction du mot pour construire le L-Systeme en fonction des regles de l'axiome et des iterations
	public Reecriture(int nbIt,String axiome,ArrayList<ArrayList<String>> regle ){
		this.nbIt=nbIt;
		this.regles= new ArrayList<ArrayList<String>>();
		this.regles = regle;
		this.lsystem = axiome;
	}

	public String toString(){
		return ("Regle : " + this.regles + " ,Iterations : " + this.nbIt + " ,Axiome : " + this.lsystem);
	}

	public void regroupementReglesProba(){ //objectif : regrouper les regles correspondant a un meme element de depart
		ArrayList<ArrayList<String>> nvllesRegles = new ArrayList<ArrayList<String>>();
		ArrayList<String> elemsDeDepart = new ArrayList<String>(); //liste des elems de departs pour la creation des "grosses" regles de proba

		while (this.regles.size() != 0){ //on vide this.regles
			if (this.regles.get(0).size() < 3){
				nvllesRegles.add(this.regles.get(0));
				elemsDeDepart.add(this.regles.get(0).get(0));

			} else if (! elemsDeDepart.contains(this.regles.get(0).get(0))){ //si l'elem de depart n'a pas encore ete vu, on cree une nvlle grosse regle lui correspondant
				ArrayList<String> nvlleRegle = new ArrayList<String>();

				nvlleRegle.add(this.regles.get(0).get(0));
				elemsDeDepart.add(this.regles.get(0).get(0));

				nvlleRegle.add(this.regles.get(0).get(1));
				nvlleRegle.add(this.regles.get(0).get(2));

				for (ArrayList<String> regle : this.regles) {
					if (regle.get(0).equals(nvlleRegle.get(0))) {
						nvlleRegle.add(regle.get(1));
						nvlleRegle.add(regle.get(2));
					}
				}
				//verif de la somme des proba == 1 ici
				nvllesRegles.add(nvlleRegle);
			}
			this.regles.remove(0); //on vide this.regles au fur et a musure
		}
		this.regles = nvllesRegles;
	}


	public ArrayList<ArrayList<String>> reglesTriees(){ //objectif : choisir une des probas parmi la liste des elem d'arrivee
		ArrayList<ArrayList<String>> nvllesRegles = new ArrayList<ArrayList<String>>();

		for (ArrayList<String> regle : this.regles) { //on parcourt toutes les regles pour la reduire si on en trouve une liee a des probas
			if (regle.size() < 3){
				nvllesRegles.add(regle);
			} else {
				ArrayList<String> nvlleRegle = new ArrayList<String>();
				HashMap<String,Float> mapTri = new HashMap<>();
				ArrayList<String> listeTri = new ArrayList<>();

				for (int i = 2; i < regle.size(); i = i+2) {
					mapTri.put(regle.get(i-1),Float.parseFloat(regle.get(i))); //creation d'un dictionnaire <elem d'arrivee>;<proba>
				}

				for (Map.Entry<String, Float> entry : mapTri.entrySet()) { //creation d'une liste contenant n fois un string S de proba 0.n
					for (int i = 0; i < (entry.getValue()*100); i++) {
						listeTri.add(entry.getKey());
					}
				}
				nvlleRegle.add(regle.get(0));
				Random randomGenerator = new Random();
				int randomIndex = randomGenerator.nextInt(listeTri.size()); //et on choisit un string S parmi la liste
				nvlleRegle.add(listeTri.get(randomIndex));

				nvllesRegles.add(nvlleRegle);
			}
		}
		return nvllesRegles;
	}

	public void appliqueRegles(){
		String output = ""; //output = this.regles a la fin

		for (int i = 0; i<this.lsystem.length(); i++) {
			String iemeString = "";
			Boolean found = false;
			int compteur = 0;

			while (!found && compteur < taillePlusGrandeRegle() && i+compteur < this.lsystem.length()){
				iemeString += this.lsystem.charAt(i+compteur);
				checkpoint_regles:
					for (ArrayList<String> regle : reglesTriees()) {
						if (regle.get(0).equals(iemeString)) {
							iemeString = regle.get(1);
							found = true;
							break checkpoint_regles;
						}
					}
				compteur ++;
			}

			if (found) {
				output += iemeString;
				this.lsystem = this.lsystem.substring(0, i) + this.lsystem.substring(i+(compteur-1));
			}
			else {
				output += this.lsystem.charAt(i);
			}
		}
		this.lsystem = output;
	}

	public int taillePlusGrandeRegle(){
		int c = 0;
		for (ArrayList<String> regle : this.regles) {
			if (regle.get(0).length() > c){
				c = regle.get(0).length();
			}
		}
		return c;
	}

	public String getLSystem(){
		return this.lsystem;
	}

	public void createLSystem(){
		regroupementReglesProba();
		for (int i=0; i<this.nbIt; i++){
			appliqueRegles();
		}
	}
}
