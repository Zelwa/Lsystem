package fenetre;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu extends JMenuBar{
	private static final long serialVersionUID = 1L;
	static double angleC = 20.0;
	static int iterationC = 4;
	Fenetre mainFrame;
	static int cpt = 9;
	static char[] str = "123456789".toCharArray();

	public Menu (Fenetre mainFrame) {
		this.mainFrame = mainFrame;
	}

	//LE MENU et ses items principaux
	JMenuBar menuBar = new JMenuBar();
	JMenu fichier = new JMenu("Fichier");
	JMenu angle = new JMenu("Angles");
	JMenu iteration = new JMenu("Iterations");

	//Item dans Fichier
	JMenuItem retry = new JMenuItem("Recommencer");
	JMenuItem reset = new JMenuItem("Reset");
	JMenuItem save = new JMenuItem("Sauvegarder l'image");
	JMenuItem quitter = new JMenuItem("Quitter");

	//Items dans Angles
	JMenuItem angle0 = new JMenuItem("10e");
	JMenuItem angle1 = new JMenuItem("20e");
	JMenuItem angle2 = new JMenuItem("22.5e");
	JMenuItem angle3 = new JMenuItem("25e");
	JMenuItem angle4 = new JMenuItem("25.7e");
	JMenuItem angle5 = new JMenuItem("36e");
	JMenuItem angle6 = new JMenuItem("45e");
	JMenuItem angle7 = new JMenuItem("60e");
	JMenuItem angle8 = new JMenuItem("72e");
	JMenuItem angle9 = new JMenuItem("90e");
	JMenuItem angle10 = new JMenuItem("120e");

	//Items dans Iterations
	JMenuItem it1 = new JMenuItem("1");
	JMenuItem it2 = new JMenuItem("2");
	JMenuItem it3 = new JMenuItem("3");
	JMenuItem it4 = new JMenuItem("4");
	JMenuItem it5 = new JMenuItem("5");
	JMenuItem it6 = new JMenuItem("6");
	JMenuItem it7 = new JMenuItem("7");


	//Construction du Menu
	public void initMenu() {
		//Fichier
		//Refaire le dessin
		retry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				MyCanvas canvas = mainFrame.getCanvas();
				Graphics2D g = (Graphics2D)canvas.getGraphics();
				canvas.update(g);
			}
		});
		retry.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));

		//Reset pour remettre des valeurs normales
		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 4;
				angleC = 20;
				setIt(iterationC);
				setAgl(angleC);

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,angleC,iterationC);
				dess1.creer();
			}

		});
		reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));

		//Enregistrer
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyCanvas canvas = mainFrame.getCanvas();
				Image image = canvas.createImage(canvas.getWidth(),canvas.getHeight());
				Graphics g2 = image.getGraphics();
				canvas.paint(g2);
				cpt -= 1;
				try {
					ImageIO.write((RenderedImage)image,"png",new File("src/images/"+str[cpt]+".png"));
				} catch (IOException e1) {
					System.out.println("Erreur de sauvegarde");
					e1.printStackTrace();
				}
			}
		});
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

		//Quitter
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));


		//Ajout de l'enregistrement et quitter a la categorie "Fichier"
		fichier.add(retry);
		fichier.add(reset);
		fichier.addSeparator();
		fichier.add(save);
		fichier.add(quitter);
		fichier.setMnemonic('F');

		//Iterations
		it1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 1;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 2;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 3;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 4;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 5;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 6;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		it7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nouvelles valeurs
				iterationC = 7;
				setIt(iterationC);
				double agl = getAgl();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(otherFrame,canvas,agl,iterationC);
				dess1.creer();
			}
		});

		///ajout des iterations a la categorie "Iterations"
		iteration.add(it1);
		iteration.add(it2);
		iteration.add(it3);
		iteration.add(it4);
		iteration.add(it5);
		iteration.add(it6);
		iteration.add(it7);
		iteration.setMnemonic('I');

		//Angles
		angle0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 10.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 20.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 22.5;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 25.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 20.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 36.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 45.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 60.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 72.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 90.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		angle10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//nouvelles valeurs
				angleC = 120.0;
				setAgl(angleC);
				int it = getIt();

				//retrait de l'ancienne fenetre et creation d'une nouvelle fenetre
				mainFrame.setVisible(false);
				Fenetre otherFrame = new Fenetre(mainFrame.x,mainFrame.y);
				MyCanvas canvas = otherFrame.getCanvas();

				//Ajout d'un nouveau dessin avec les nouvelles valeurs dans le canvas de la fenetre
				Dessin dess1 = new Dessin(mainFrame,canvas,angleC,it);
				dess1.creer();
			}
		});

		//Ajout des angles a la categorie "Angle"
		angle.add(angle0);
		angle.add(angle1);
		angle.add(angle2);
		angle.add(angle3);
		angle.add(angle4);
		angle.add(angle5);
		angle.add(angle6);
		angle.add(angle7);
		angle.add(angle8);
		angle.add(angle9);
		angle.add(angle10);
		angle.setMnemonic('A');

		//Ajout des categories a la menuBar et a la Jframe
		menuBar.add(fichier);
		menuBar.add(angle);
		menuBar.add(iteration);
		mainFrame.setJMenuBar(menuBar);
	}

	public int getIt() {
		return iterationC;
	}

	public double getAgl() {
		return angleC;
	}

	public void setIt(int i) {
		iterationC = i;
	}

	public void setAgl(double i) {
		angleC = i;
	}
}
