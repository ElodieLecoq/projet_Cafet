package projet.gui;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import projet.i18n.Labels;
import projet.model.Commande;
import projet.model.Commande.BoissonType;
import projet.model.Commande.DessertType;


public class Boisson extends CafetPanel {

	private JLabel contenuLabel;
	private JRadioButton cb;
	private JRadioButton cb1;
	private JRadioButton cb2;
	private ButtonGroup group;
	
	public Boisson(Commande commande){
		super(commande);
		commande.setBoisson(BoissonType.cocacola);
	}
	
	@Override
	public void resetLanguage(){
		super.resetLanguage();		
		this.contenuLabel.setText(Labels.getLabel("label.boisson"));
	}
	
	@Override
	JPanel getMainPanel() {
		JPanel middlePanel = new JPanel(new GridBagLayout());
		
		//Panel du context
		JPanel milieu = new JPanel(new GridLayout(0,1));
		middlePanel.add(milieu);

		this.contenuLabel = new JLabel();
		milieu.add(contenuLabel);
		
		group = new ButtonGroup();
		BoissonChange action = new BoissonChange();
		this.cb = new JRadioButton("Coca cola", true);
		cb.addActionListener(action);
		this.cb1 = new JRadioButton("Eau minérale");
		cb1.addActionListener(action);
		this.cb2 = new JRadioButton("Jus de fruits");
		cb2.addActionListener(action);
		group.add(cb);
		milieu.add(cb);
		group.add(cb1);
		milieu.add(cb1);
		group.add(cb2);
		milieu.add(cb2);
		
		return middlePanel;
	}
	
	@Override
	String getComponentId() {
		return "Boisson";
	}
	
	private class BoissonChange implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(group.getSelection() == cb.getModel())
			{
				commande.setBoisson(BoissonType.cocacola);
			}
			else if(group.getSelection() == cb1.getModel()){
				commande.setBoisson(BoissonType.eau);
			}
			else{
				commande.setBoisson(BoissonType.jusdefruits);
			}
			
		}
	}
}


