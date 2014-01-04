package projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import projet.i18n.Help;
import projet.i18n.Labels;
import projet.model.Commande;
import projet.model.RefreshListener;

public class Login extends CafetPanel {

	private JLabel idLabel;
	private JTextField idText;
	private JLabel contextLabel;
	private JLabel errorLabel;
	
	private RefreshListener refreshListener;
	
	public Login(Commande commande) {
		super(commande, false);
	}

	@Override
	public void resetLanguage() {
		super.resetLanguage();
		this.nextButton.setText(Labels.getLabel("button.ok"));
		this.idLabel.setText(Labels.getLabel("label.login"));
		this.contextLabel.setText(Labels.getLabel("label.context"));
		this.errorLabel.setText("");
	}

	@Override
	JPanel getMainPanel() {
		JPanel middlePanel = new JPanel(new BorderLayout());
		
		//create languages buttons
		LanguageButton fr = new LanguageButton(Locale.FRANCE, new ImageIcon(CafetPanel.class.getResource("/images/connection/drapeau_fr.jpg")));
		LanguageButton en = new LanguageButton(Locale.US, new ImageIcon(CafetPanel.class.getResource("/images/connection/drapeau1.jpg")));
		
		//create action on click 
		LanguageAction action = new LanguageAction();
		fr.addMouseListener(action);
		en.addMouseListener(action);
		
		//create languages panel
		JPanel languagesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		languagesPanel.add(fr);
		languagesPanel.add(en);
		
		middlePanel.add(languagesPanel, BorderLayout.NORTH);
		
		JPanel contentPanel = new JPanel(new BorderLayout());
		middlePanel.add(contentPanel, BorderLayout.CENTER);
		
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.red);
		errorLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		contentPanel.add(errorLabel, BorderLayout.NORTH);
		
		JPanel loginPanel = new JPanel(new GridBagLayout());
		contentPanel.add(loginPanel, BorderLayout.CENTER);
		
		// Panel du context
		JPanel milieu = new JPanel();
		milieu.setLayout(new BoxLayout(milieu, BoxLayout.Y_AXIS));
		loginPanel.add(milieu);

		this.contextLabel = new JLabel();
		milieu.add(contextLabel);
		this.idLabel = new JLabel();
		idText = new JTextField(10);

		// Panel Formulaire
		JPanel form = new JPanel();
		milieu.add(form);
		form.add(idLabel);
		form.add(idText);

		return middlePanel;
	}

	public boolean isIdentifiantValid() {
		errorLabel.setText("");
		if(idText.getText().equals("")){
			errorLabel.setText(Labels.getLabel("error.login.empty"));
			return false;
		}
		else{
			commande.setIdentifiant(idText.getText());
			return true;
		}
	}

	public void addRefreshListener(RefreshListener listener){
		this.refreshListener = listener;
	}
	
	@Override
	String getComponentId() {
		return "Login";
	}

	/**  
	 * On click on a LanguageButton, we get the locale , pass it to Labels class and reset screen to update labels
	 * @author Elodie
	 *
	 */
	private class LanguageAction extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//get locale from button
			LanguageButton button = (LanguageButton)e.getSource();
			//set new locale in lables manager
			Labels.setLanguage(button.getLanguage());
			Help.setLanguage(button.getLanguage());
			//reset IHM to update all label with new language version
			Login.this.resetLanguage();
			
			if(Login.this.refreshListener != null){
				Login.this.refreshListener.refreshPerformed();
			}
		}
	}
}
