package turtle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Trait{
	int x1,y1,x2,y2;
	Color couleur;
	float width;

	//Constructeur de la classe Trait avec des coordonnees de depart et d'arrivee et une largeur
	public Trait(int x1,int y1,int x2, int y2, float width){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.width = width;
	}

	public int getX1() {
		return this.x1;
	}

	public int getY1() {
		return this.y1;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY2() {
		return this.y2;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String toString() {
		return "Mon trait : (("+this.x1+","+this.y1+")("+this.x2+","+this.y2+"))";
	}

	//Methode qui permet de dessiner un trait avec la methode drawline
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(width));
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
		g.setColor(couleur);
	}
}
