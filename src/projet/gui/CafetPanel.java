package projet.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import projet.i18n.Help;
import projet.i18n.Labels;
import projet.model.Commande;


public abstract class CafetPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JButton nextButton;
	private JButton previousButton;
	private JButton helpButton;
	
	private ActionListener nextAction;
	private ActionListener previousAction;
	
	protected Commande commande;
	
	public CafetPanel(Commande commande){
		this(commande, true);
	}
	
	
	public CafetPanel(Commande commande, boolean hasPrevious){
		super(new BorderLayout());
			
		this.commande = commande;
		
		nextButton = new JButton();
		previousButton = new JButton();
		helpButton = new JButton();
		
		NextPreviousAction wizardAction = new NextPreviousAction();
		nextButton.addActionListener(wizardAction);
		previousButton.addActionListener(wizardAction);
		helpButton.addActionListener(new HelpAction());
		
		//create buttons panel
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(helpButton);
		//if panel has a previous button add it to IHM
		if(hasPrevious)
			buttonsPanel.add(previousButton);
		buttonsPanel.add(nextButton);
		
		
		this.add(getMainPanel(), BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		resetLanguage();
	}
	
	public void addNextActionListener(ActionListener action){
		this.nextAction = action;
	}
	public void addPreviousActionListener(ActionListener action){
		this.previousAction = action;
	}
	
	abstract String getComponentId();
	
	abstract JPanel getMainPanel();
	
	public void resetLanguage(){
		previousButton.setText(Labels.getLabel("button.previous"));
		nextButton.setText(Labels.getLabel("button.next"));
		helpButton.setText(Labels.getLabel("button.help"));
	}
	
	/**
	 * 
	 * @author Elodie
	 *
	 */
	private class NextPreviousAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			if(nextButton == button){
				if(CafetPanel.this.nextAction != null){
					CafetPanel.this.nextAction.actionPerformed(e);
				}
			}
			else {
				if(CafetPanel.this.previousAction != null){
					CafetPanel.this.previousAction.actionPerformed(e);
				}
			}
		}
	}
	
	private class HelpAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(CafetPanel.this, Help.getLabel("help."+CafetPanel.this.getComponentId()));
		}
		
	}
	
}
