package projet.gui;

import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LanguageButton extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Locale language;
	
	public LanguageButton(Locale locale, Icon image){
		super(image);
		this.language = locale;
	}
	
	public Locale getLanguage(){
		return language;
	}
}
