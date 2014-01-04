package projet.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import projet.i18n.Labels;
import projet.model.Commande;


public class Recapitulatif extends CafetPanel{
	private JLabel contenuLabel;
	private JLabel formuleLabel;
	private JLabel entreeLabel;
	private JLabel entreeText;
	private JLabel platLabel;
	private JLabel dessertLabel;
	private JLabel boissonLabel;
	private JLabel formuleText;
	private JLabel platText;
	private JLabel dessertText;
	private JLabel boissonText;
	private JLabel prixLabel;
	private JLabel prixText;
	
	public Recapitulatif(Commande commande) {
		super(commande);
	}
	
	
	@Override
	public void resetLanguage(){
		super.resetLanguage();		
		this.contenuLabel.setText(Labels.getLabel("label.recap"));
		
		this.formuleLabel.setText(Labels.getLabel("label.formule"));
		this.formuleText.setText(Labels.getLabel("label."+commande.getFormule()));
		
		this.entreeLabel.setText(Labels.getLabel("label.entree"));
		this.entreeText.setText(Labels.getLabel("label."+commande.getEntree()));
		
		this.platLabel.setText(Labels.getLabel("label.plat"));
		this.platText.setText(Labels.getLabel("label."+commande.getPlat()));
		
		this.dessertLabel.setText(Labels.getLabel("label.dessert"));
		this.dessertText.setText(Labels.getLabel("label."+commande.getDessert()));
		
		this.boissonLabel.setText(Labels.getLabel("label.boisson"));
		this.boissonText.setText(Labels.getLabel("label."+commande.getBoisson()));
		
		this.prixLabel.setText(Labels.getLabel("label.prix"));
		this.prixText.setText(commande.getPrix() +" €");
	}
	
	@Override
	JPanel getMainPanel() {
		JPanel middlePanel = new JPanel(new GridBagLayout());
		
		JPanel contenuPanel = new JPanel(new GridBagLayout());
		this.contenuLabel = new JLabel();
		contenuLabel.setFont(contenuLabel.getFont().deriveFont(18f));
		
		contenuPanel.add(contenuLabel);
		
		JPanel insidePanel = new JPanel();
		insidePanel.setLayout(new BoxLayout(insidePanel, BoxLayout.PAGE_AXIS));
		
		insidePanel.add(contenuPanel);
		
		insidePanel.add(Box.createRigidArea(new Dimension(0, 6)));
		
		//Panel du context
		JPanel milieuPanel = new JPanel(new GridBagLayout());
		JPanel milieu = new JPanel(new GridLayout(6,2));
		milieuPanel.add(milieu);
		
		insidePanel.add(milieuPanel);
		
		this.formuleLabel = new JLabel();
		milieu.add(formuleLabel);
		
		this.formuleText = new JLabel();
		milieu.add(formuleText);
		
		this.entreeLabel = new JLabel();
		milieu.add(entreeLabel);
		
		this.entreeText = new JLabel();
		milieu.add(entreeText);
		
		this.platLabel = new JLabel();
		milieu.add(platLabel);
		
		this.platText = new JLabel();
		milieu.add(platText);
		
		this.dessertLabel = new JLabel();
		milieu.add(dessertLabel);
		
		this.dessertText = new JLabel();
		milieu.add(dessertText);
		
		this.boissonLabel = new JLabel();
		milieu.add(boissonLabel);
		
		this.boissonText = new JLabel();
		milieu.add(boissonText);
		
		this.prixLabel = new JLabel();
		milieu.add(prixLabel);
		
		this.prixText = new JLabel();
		milieu.add(prixText);
		
		middlePanel.add(insidePanel);
		return middlePanel;
	}
	
	@Override
	String getComponentId() {
		return "Recapitulatif";
	}
}


