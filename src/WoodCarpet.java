import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import helpers.*;

public class WoodCarpet extends JPanel 
{
	public static JRadioButton rdoWood;
	public static JRadioButton rdoCarpet;
	public static JLabel lblDirections;
	
	private DecimalFormat df = new DecimalFormat("$#,###.00");
	
	public WoodCarpet()
	{
		createPanel();
	}
	
	private void createPanel() {
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
				
		bag.gridx = 0;
		bag.gridy = 1;
		bag.weightx = 0;
		bag.weighty = 0;
		rdoWood = new JRadioButton("Wood Flooring $20/sqft");
		super.add(rdoWood, bag);
		
		bag.gridx = 1;
		bag.gridy = 1;
		bag.weightx = 0;
		bag.weighty = 0;
		rdoCarpet = new JRadioButton("Carpet $10/sqft");
		super.add(rdoCarpet, bag);
		
		ButtonGroup groupWoodCarpet = new ButtonGroup();
		groupWoodCarpet.add(rdoCarpet);
		groupWoodCarpet.add(rdoWood);
		
	}
}
