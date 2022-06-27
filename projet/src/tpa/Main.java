package tpa;
import fenetre.Dessin;
import fenetre.Fenetre;
import fenetre.MyCanvas;



public class Main{
	public static void main(String[] args){
		//Creation de la Fenetre et recuperation du Canvas
		Fenetre mainFrame = new Fenetre(1680,920);
		MyCanvas canvas = mainFrame.getCanvas();

		//Mesures pour le premier dessin (modifiable en fenetre)
		int iterations = 5;
		double angle = 36.0;

		//Creation du premier dessin dans le Canvas de la Fenetre avec les mesures fixees
		Dessin dess1 = new Dessin(mainFrame,canvas,angle,iterations);
		dess1.creer();
	}
}
