import java.awt.Color;
import java.util.ArrayList;

import javax.swing.UIManager;


import helpers.OutputHelpers;
import helpers.StringHelpers;

public class AppMain 
{
	public static void main(String[] args) {
		setStyle();
		new MainForm();

	}
	
	private static void setStyle() 
	{
		UIManager.put("Optionpane.background", Color.BLUE);
		UIManager.put("JPanel.background", Color.LIGHT_GRAY);
		
	}
}
