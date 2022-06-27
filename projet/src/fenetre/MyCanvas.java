package fenetre;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import turtle.Trait;

public class MyCanvas extends Canvas {
	private static final long serialVersionUID = 1L;

	LinkedList<Trait> liste;

	//Constructeur du Canvas avec une taille de la taille de la fenetre et une couleur claire
	public MyCanvas(int x, int y){
		this.liste = new LinkedList<Trait>();
		setBackground (new Color(239, 239, 239));
	    setSize(x, y);
	}

	//Methode qui permet de peindre dans le Canvas une liste de Traits
	public void paint(Graphics g) {
		for(Trait trait : this.liste) {
			trait.paintComponent(g);
		}
	}

	//Methode qui permet de
	public void addTrait(Trait trait) {
		this.liste.add(trait);
	}
}
