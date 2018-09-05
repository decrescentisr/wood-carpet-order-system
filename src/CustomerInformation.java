import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import helpers.FileHelpers;
import helpers.InputHelpers;
import helpers.OutputHelpers;

public class CustomerInformation extends JPanel 
{
	public static JLabel lblFullName;
	public static JTextField txtFullName;
	public static String name;
	public static JLabel lblLastName; 
	public static JTextField txtLastName;
	public static JLabel lblAddress;
	public static JTextField txtAddress;
	public static JLabel lblAddress2;
	public static JTextField txtAddress2;
	public static JLabel lblCity;
	public static JTextField txtCity;
	public static JLabel lblState;
	public static JTextField txtState;
	public static JLabel lblZipCode;
	public static JTextField txtZipCode;
	public static JLabel lblPhoneNumber;
	public static JTextField txtPhoneNumber;
		
	public CustomerInformation()
	{
		super();
		createPanel();
	}
	
	public void clear()
	{
		txtFullName.setText("");
		txtAddress.setText("");
		
	}
	
	private void createPanel()
	{
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		bag.gridx = 0;
		bag.gridy = 0;
		lblFullName = new JLabel();
		lblFullName.setText("Full Name: ");
		super.add(lblFullName, bag);
		
		bag.gridx = 1;
		bag.gridy = 0;
		txtFullName = new JTextField(10);
		super.add(txtFullName, bag);
		
				
		bag.gridx = 0;
		bag.gridy = 2;
		lblAddress = new JLabel();
		lblAddress.setText("Address: ");
		super.add(lblAddress, bag);
		
		bag.gridx = 1;
		bag.gridy = 2;
		txtAddress = new JTextField(15);
		super.add(txtAddress, bag);
		
	}	
}
