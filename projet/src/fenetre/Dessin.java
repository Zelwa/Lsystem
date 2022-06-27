package fenetre;

import java.io.File;

import lsystem.Parser;
import lsystem.Reecriture;
import turtle.Trait;
import turtle.Turtle;

public class Dessin {
	Fenetre fen;
	MyCanvas can;
	double agl;
	int it;

	public Dessin (Fenetre fen, MyCanvas can, double agl, int it) {
		this.fen = fen;
		this.can = can;
		this.agl = agl;
		this.it = it;
	}

	//Methode qui permet de creer un L-Systeme et le dessiner dans le canvas d'une fenetre donnee
	public void creer() {
		//Import du fichier texte contenant la regle de reecriture et l'axiome
		File file = new File("src/fenetre/regles.txt");
		//On prends la regle du fichier qui se trouve sur les 2 premieres lignes du fichier
		Parser regles = new Parser(file);
		regles.lire();
		Reecriture mot = new Reecriture(this.it,regles.getAxiome(),regles.getRegles());
		mot.createLSystem();
		String txt = mot.getLSystem();
		System.out.println("l-system : "+ txt);

		Turtle francklin = new Turtle(txt, this.agl, this.fen);

		for(Trait trait : francklin.run()) {
			this.can.addTrait(trait);
		}
		this.can.update(this.can.getGraphics());
	}

}
