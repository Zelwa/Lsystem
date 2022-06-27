package turtle;
import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;

import fenetre.Fenetre;



public class Turtle {
	//Initialisation des differentes piles
	LinkedList<Trait> crt;
	Stack<Point> pilePoint;
	Stack<Double> pileAngle;
	Stack<Color> pileCouleur;

	String mot;
	double constanteAngle;
	int longueur, hauteur, largeur;
	//Differentes Couleurs pour l'arbre
	Color vert1 =  new Color(86, 130, 3);
	Color vert2 = new Color(22, 184, 78);
	Color marron = new Color(91, 60, 17);
	Color marron2 = new Color(90, 58, 34);

	public Turtle(String mot, double angle, Fenetre f) {
		this.crt = new LinkedList<Trait>();
		this.pilePoint = new Stack<Point>();
		this.pileAngle = new Stack<Double>();
		this.pileCouleur = new Stack<Color>();

		this.mot = mot;
		this.longueur = 100;
		this.largeur = f.getX();
		this.hauteur = f.getY();
		this.constanteAngle = angle;
	}

	public LinkedList<Trait> run() {
		boolean bonneLongueur = false;

		while (!bonneLongueur) {
			Point point1 = new Point(this.largeur/2, this.hauteur);//origine
			Point point2 = point1;

			//Premiere couleur pour l'arbre
			this.pileCouleur.push(marron);

			double angleCourant = 0d;
			float lineWidth = 10;
			boolean broken = false;

			for (int  i = 0; i < this.mot.length(); i++) {
				char lettre = this.mot.charAt(i);

				if (lettre == '+') {
					angleCourant = angleCourant - this.constanteAngle;
				}

				if (lettre == '-') {
					angleCourant = angleCourant + this.constanteAngle;
				}

				if (lettre == '[') {
					this.pilePoint.push(point1);
					this.pileAngle.push(angleCourant);
				}

				if (lettre == ']') {
					point1 = this.pilePoint.pop();
					angleCourant = this.pileAngle.pop();
				}

				if (this.mot.charAt(i) == 'C' && this.mot.charAt(i+1)== '0') {
					this.pileCouleur.push(marron);
				}

				if (this.mot.charAt(i) == 'C' && this.mot.charAt(i+1)== '1') {
					this.pileCouleur.push(vert1);
				}

				if (this.mot.charAt(i) == 'C' && this.mot.charAt(i+1)== '2') {
					this.pileCouleur.push(vert2);
				}

				if (this.mot.charAt(i) == 'C' && this.mot.charAt(i+1)== '3') {
					this.pileCouleur.push(marron2);
				}

				else if (lettre != ']' && lettre != '[' && lettre != '+' && lettre != '-' && lettre != 'C' && lettre != '0' && lettre != '1' && lettre != '2'){
					point2 = nouveauPoint(point1, angleCourant);

					//calcul de ratio en fonction de la distance de l'arbre a l'origine
					lineWidth = 0.000023f * ( 100 * ((this.largeur/2) - Math.abs((this.largeur/2) - point2.x)  + point2.y));

					if (point2.x > this.largeur || point2.x < 0 || point2.y < 0) {
						this.crt.clear();
						this.pilePoint.clear();
						this.pileAngle.clear();
						this.longueur = this.longueur/2;
						broken = true;
						break;
					}
					Trait tr = new Trait(point1.x,point1.y,point2.x,point2.y,lineWidth);
					tr.couleur = pileCouleur.peek();
					this.crt.add(tr);
					point1 = point2;
				}
			}
			if (!broken) {
				bonneLongueur = true;
			}
		}
		return this.crt;
	}

	//Methode qui permet e partir d'un point et d'un angle de donner le point d'arrivee etant donner la longueur d'un trait
	public Point nouveauPoint(Point coord,Double angle){
		int x = Math.toIntExact(Math.round(coord.x - this.longueur *Math.cos(Math.toRadians(90+angle))));
		int y = Math.toIntExact(Math.round(coord.y - this.longueur*Math.sin(Math.toRadians(90+angle))));
		return new Point(x,y);
	}
}
