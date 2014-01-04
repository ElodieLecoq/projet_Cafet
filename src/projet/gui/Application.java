package projet.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import projet.i18n.Labels;
import projet.model.Commande;
import projet.model.RefreshListener;


public class Application extends JFrame implements RefreshListener {

	private Login login;
	private Dessert dessert;
	private Boisson boisson;
	private Recapitulatif recapitulatif;
	private Commande commande;
	
	public Application() {

		//new Command()
		this.commande = new Commande();
		
		this.login = new Login(commande);
		this.dessert = new Dessert(commande);
		this.boisson = new Boisson(commande);
		this.recapitulatif = new Recapitulatif(commande);
				
		this.login.addNextActionListener(new LoginAction(dessert));
		this.login.addRefreshListener(this);
		
		
		//add special ecran pour choisir nouveau ou deja utilise
		
		this.dessert.addNextActionListener(new ChangeEcranAction(boisson));
		this.dessert.addPreviousActionListener(new ChangeEcranAction(login));
		
		this.boisson.addNextActionListener(new ChangeEcranAction(recapitulatif));
		this.boisson.addPreviousActionListener(new ChangeEcranAction(dessert));
		
		this.recapitulatif.addPreviousActionListener(new ChangeEcranAction(boisson));
		
		getContentPane().add(this.login);
		
		resetTitle();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Définit sa taille : 500 pixels de large et 300 pixels de haut
		this.setSize(600, 400);
		    		
	    //Et enfin, la rendre visible       
	    this.setVisible(true);
	}
	
	public void resetTitle(){
		this.setTitle(Labels.getLabel("label.title"));
	}
	
	
	private class LoginAction extends ChangeEcranAction {
		
		public LoginAction(CafetPanel panel) {
			super(panel);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Application.this.login.isIdentifiantValid()){
				super.actionPerformed(e);
			}
		}
	}
	
	
	private class ChangeEcranAction implements ActionListener {
		
		CafetPanel panel;
		
		public ChangeEcranAction(CafetPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
					panel.resetLanguage();
					Application.this.getContentPane().removeAll();
					Application.this.getContentPane().add(panel);
					//use to open the next panel
					Application.this.revalidate();
					Application.this.repaint();
		}
	}
	
	@Override
	public void refreshPerformed() {
		resetTitle();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application app = new Application();
		
	}
}
