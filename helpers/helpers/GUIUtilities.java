package helpers;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;

public class GUIUtilities {
	
	
	private static Color navyBlue = new Color(0, 0, 80);
	
	public static void setNormalFont(JComponent control) {
		Font myFont = new Font("Arial", Font.PLAIN, 12);
		control.setFont(myFont);
		control.setForeground(navyBlue);
	}
	
	public static void setHeadingFont(JComponent control) {
		Font myFont = new Font("Arial", Font.BOLD|Font.ITALIC, 14);
		control.setFont(myFont);
		control.setForeground(navyBlue);
	}

}
