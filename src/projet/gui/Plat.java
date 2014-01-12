package projet.gui;

import javax.swing.JPanel;

import projet.model.Commande;

public class Plat extends CafetPanel {

	public Plat(Commande commande) {
		super(commande);
	}

	@Override
	String getComponentId() {
		return "PLat";
	}

	@Override
	JPanel getMainPanel() {
		return null;
	}

}
