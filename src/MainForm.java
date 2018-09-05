import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import helpers.ApplicationHelpers;

@SuppressWarnings("serial")
public class MainForm extends JFrame
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
	JTabbedPane jtp;
	
	public MainForm(){
		super();
		createTabPane();
		setFrame();
		
		ApplicationHelpers.displayApplicationInformation("Flooring Application", "Course Project", "Java Business Application");
	}
	
	private void createTabPane()
	{
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		jtp = new JTabbedPane();
		jtp.addTab("Customer Information", new CustomerInformation());
		jtp.addTab("Wood Flooring and Carpet Selection", new WoodCarpet());
		jtp.addTab("Calculations", new Calculations());
		
		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.gridx = 0;
		bag.gridy = 0;
		bag.ipady = 250;
		bag.weightx = 1;
		bag.weighty = .75;
		this.add(jtp, bag);
		
		bag.fill = GridBagConstraints.CENTER;
		bag.gridx = 0;
		bag.gridy = 1;
		bag.ipady = 40;
		bag.ipadx = 400;
		bag.weightx = 1;
		bag.weighty = .25;
		bag.insets = new Insets(10,0,10,0);
		
		this.add(new ExitButton("Wood Flooring and Carpet Ordering System"), bag);
		
	}
	
	private void setFrame()
	{
		Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		super.setTitle("Client Application");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(windowSize);
		
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
}
