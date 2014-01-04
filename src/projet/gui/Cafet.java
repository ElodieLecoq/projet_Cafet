package projet.gui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Cafet extends JFrame {
	
	public static void main(String[] args) {
		//Création fenêtre
		JFrame jf = new JFrame();
		
		jf.setTitle("Connexion Cafetéria IUT Vannes");
		//Panel principal permettant l'enchaine des écrans
		JPanel principal = new JPanel(new CardLayout());
		jf.add(principal);
		//Panel connexion
		final JPanel connexion = new JPanel(new BorderLayout());
		principal.add(connexion, "connexion");
		
		//Panel du milieu
		JPanel milieu = new JPanel(new GridLayout(2,1));
		connexion.add(milieu);
		
		JLabel context = new JLabel("Bienvenue sur le logiciel de commande de repas de la cafétéria de l'IUT de Vannes");
		milieu.add(context);
		
		//Panel entete
		JPanel entete = new JPanel();
		connexion.add(entete, BorderLayout.PAGE_START);
		
		JLabel titre = new JLabel("Connexion à la cafétéria de l'IUT   ");
		
		entete.add(titre);
		
		JLabel drapeau = new JLabel("");
		drapeau.setIcon(new ImageIcon(Cafet.class.getResource("/images/connection/drapeau1.jpg")));	
		//mettre en haut a droite
		entete.add(drapeau);
		
		//Panel identifiant
		JPanel login = new JPanel();
		milieu.add(login);
		
		JLabel identifiant = new JLabel("Identifiant UBS");
		login.add(identifiant);
		
		JTextField saisi_log = new JTextField(20);
		login.add(saisi_log);
		
		//Panel boutons
		JPanel bouton = new JPanel();
		connexion.add(bouton, BorderLayout.PAGE_END);
		
		JButton Aide = new JButton("Aide");
		bouton.add(Aide);
		
		JButton Valider = new JButton("Valider");
		bouton.add(Valider);
		Valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//connexion.show();
			}
		});
		
		 
		 //Définit sa taille : 500 pixels de large et 300 pixels de haut
		 jf.setSize(600, 400);
		    		
	    //Et enfin, la rendre visible       
	    jf.setVisible(true);
	    
	}
}