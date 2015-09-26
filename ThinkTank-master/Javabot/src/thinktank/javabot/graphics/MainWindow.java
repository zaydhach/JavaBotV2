package thinktank.javabot.graphics;

import java.awt.Dimension;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import thinktank.javabot.physics.Physique;
import thinktank.javabot.physics.Tank;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private static PanneauDessin game;

	 
	private static JFileChooser chooser = new JFileChooser();
    
	
	public static MainWindow window = new MainWindow();
	

	/* Coordonnées saisies par le user */
	private static int setX;
	private static int setY;
	
	private JPanel container = new JPanel();
	private JPanel c2 = new JPanel();
	
	public static Physique phy;
	
	
	/**
	 * Affichage principal de l'application
	 **/
	
	public MainWindow() {
		
		int lx = 30;
		int ly = 22;
		phy = new Physique(lx, ly);
		game = new PanneauDessin(phy);
		
		this.setTitle("JavaBot");
		this.setSize(740, 560);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
        

		container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
		

		
		container.add(game);
		
		
		
		this.setContentPane(container);
		this.setResizable(true);
		this.setVisible(true); 
		
		game.repaint();
		GraphicInterface NewGame=new GraphicInterface();
		
		
		NewGame.jPanel5.add(container);
		
		
		
		
		//NewGame.jPanel5.add(c2);
		NewGame.setVisible(true);
		Point p = NewGame.getLocationOnScreen();
		System.out.println(p.getX());
		System.out.println(p.getY());
		this.setVisible(false); 
	
	}
	
	/**Graphics
	 * Fonction main principale
	 **/
	public static void main(String args[]) {
		
		
		// MAP HARD CODE
		for(int i = 5; i < 10; i++)
		{
			window.phy.newMur(i,5);
	
		}
		for(int i = 18; i < 25; i++)
		{
			window.phy.newMur(i,15);
	
		}
		for(int i = 5; i < 10 ; i++)
		{
			window.phy.newMur(30,i);
	
		}
		for(int i = 28; i < 33; i++)
		{
			//window.phy.newMur(i,20);
	
		}
		for(int i = 10; i < 15 ; i++)
		{
			window.phy.newMur(8,i);
	
		}
		
		
		
		while(true){
			
			if(!GraphicInterface.stoped || GraphicInterface.NextStepFlag){
				window.phy.iter();
				if(GraphicInterface.NextStepFlag)
					GraphicInterface.NextStepFlag=false;
			}
			window.game.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static PanneauDessin getPanneauDessin()
	{
		return game;
	}



}