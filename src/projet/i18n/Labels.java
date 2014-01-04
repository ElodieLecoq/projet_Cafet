package projet.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Labels{

	private static String file ="projet.i18n.Labels";
	private static ResourceBundle labels = ResourceBundle.getBundle(file, Locale.FRANCE);
	
	
	public static void setLanguage(Locale l){
		labels = ResourceBundle.getBundle(file, l);
	}
	
	public static String getLabel(String code){
		try {
			return labels.getString(code) ;
		} catch (MissingResourceException e){
			return code;
		}
	}
}
