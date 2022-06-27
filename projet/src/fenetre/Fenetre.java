package fenetre;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class Fenetre extends JFrame{
	private static final long serialVersionUID = 1L;
	MyCanvas canvas;
	int x,y;

	public Fenetre(int x, int y){
		//Taille de la Fenetre
		this.x = x;
		this.y = y;

		//Initialisation des parametres de la Fenetre
		this.setTitle("L-Systeme");
		this.setSize(x,y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Creation d'un Canvas
		MyCanvas can = new MyCanvas(x, y);
		this.canvas = can;

		//Modification de l'icene de la JFrame
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/images/logo.png");
		this.setIconImage(img);

		//Creation du menu
		Menu menu = new Menu(this);
		menu.initMenu();

		//Ajout de Canvas
		this.add(can);

		//Apparition de la Fenetre
		this.pack();
		this.setVisible(true);
	}

	public MyCanvas getCanvas() {
		return this.canvas;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
}
