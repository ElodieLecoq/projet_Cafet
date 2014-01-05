package projet.gui;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import projet.i18n.Labels;
import projet.model.Commande;
import projet.model.Commande.BoissonType;


public class Boisson extends CafetPanel {

	private JLabel contenuLabel;
	private ButtonGroup group;
	private List<JRadioButton> choices;
	
	public Boisson(Commande commande){
		super(commande);
		commande.setBoisson(BoissonType.cocacola);
	}
	
	@Override
	public void resetLanguage(){
		super.resetLanguage();		
		this.contenuLabel.setText(Labels.getLabel("label.boisson"));
		
		int i = 0;
		for(JRadioButton button : choices){
			button.setText(Labels.getLabel("label."+BoissonType.values()[i]));
			i++;
		}
	}
	
	@Override
	JPanel getMainPanel() {
		choices = new ArrayList<JRadioButton>();
		JPanel middlePanel = new JPanel(new GridBagLayout());
		
		//Panel du context
		JPanel milieu = new JPanel(new GridLayout(0,1));
		middlePanel.add(milieu);

		this.contenuLabel = new JLabel();
		milieu.add(contenuLabel);
		
		group = new ButtonGroup();
		BoissonChange action = new BoissonChange();
		for (BoissonType type : BoissonType.values()) {
			JRadioButton b = new JRadioButton("", true);
			choices.add(b);
			b.addActionListener(action);
			group.add(b);
			milieu.add(b);
		}
		
		return middlePanel;
	}
	
	@Override
	String getComponentId() {
		return "Boisson";
	}
	
	private class BoissonChange implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = 0;
			for(JRadioButton b : choices){
				if (group.getSelection() == b.getModel()) {
					commande.setBoisson(BoissonType.values()[i]);
					return;
				}
				i++;
			}
		}
	}
}


