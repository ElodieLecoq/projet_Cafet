package projet.gui;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import projet.i18n.Labels;
import projet.model.Commande;
import projet.model.Commande.DessertType;

public class Dessert extends CafetPanel{

	private JLabel contenuLabel;
	private JRadioButton cb;
	private JRadioButton cb1;
	private JRadioButton cb2;
	private ButtonGroup group;
	
	public Dessert(Commande commande){
		super(commande);
		commande.setDessert(DessertType.compote);
	}
	
	@Override
	public void resetLanguage(){
		super.resetLanguage();		
		this.contenuLabel.setText(Labels.getLabel("label.dessert"));
		this.cb.setText(Labels.getLabel("label.compote"));
		this.cb1.setText(Labels.getLabel("label.yaourt"));
		this.cb2.setText(Labels.getLabel("label.clementine"));
	}
	
	@Override
	JPanel getMainPanel() {
		JPanel middlePanel = new JPanel(new GridBagLayout());
		
		//Panel du context
		JPanel milieu = new JPanel(new GridLayout(4,1));
		middlePanel.add(milieu);

		this.contenuLabel = new JLabel();
		milieu.add(contenuLabel);
		
		group = new ButtonGroup();
		
		this.cb = new JRadioButton("", true);
		
		DessertChange action = new DessertChange();
		this.cb.addActionListener(action);
		this.cb1 = new JRadioButton("");
		this.cb1.addActionListener(action);
		this.cb2 = new JRadioButton("");
		this.cb2.addActionListener(action);
		
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
		return "Select";
	}
	
	private class DessertChange implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(group.getSelection() == cb.getModel())
			{
				commande.setDessert(DessertType.compote);
			}
			else if(group.getSelection() == cb1.getModel()){
				commande.setDessert(DessertType.yaourt);
			}
			else{
				commande.setDessert(DessertType.clementine);
			}
			
		}
	}
}
