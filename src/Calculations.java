import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helpers.FileHelpers;
import helpers.InputHelpers;
import helpers.NumberHelpers;
import helpers.OutputHelpers;


public class Calculations extends JPanel 
{

	
	
	JLabel lblLength;
	JTextField txtLength;
	JLabel lblWidth;
	JTextField txtWidth;
	JLabel lblArea;
	static JTextField txtArea;
	public static double area;
	JLabel lblFlooringType;
	JTextField txtFlooringType;
	JLabel lblFlooringCost;
	JTextField txtFlooringCost;
	JLabel lblTotal;
	JTextField txtTotal;
	JButton btnCalculate; 
	JButton btnSubmit;
	JButton btnDisplayOrder;
	JButton btnDisplay;
	JButton btnCost;
	
	private DecimalFormat df = new DecimalFormat("$#,##0.00");
	
	
	public Calculations()
	{
		super();
		createPanel();
	}
	
	public void clear() {
		txtArea.setText("");
		txtLength.setText("");
		txtWidth.setText("");
	}
	private void createPanel()
	{
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		//layout the panel in two four rows, two columns
				//column 0, row 0, start counting at 0 (zero)
		bag.gridx = 0;
		bag.gridy = 0;
		lblLength = new JLabel();
		lblLength.setText("Enter the length of your room:");
		super.add(lblLength, bag);
		
		//column 1, row 0
		bag.gridx = 1;
		bag.gridy = 0;
		txtLength = new JTextField(5);
		super.add(txtLength, bag);
		
		//column 0, row 1
		bag.gridx = 0;
		bag.gridy = 1;
		lblWidth = new JLabel();
		lblWidth.setText("Enter the width of your room:");
		super.add(lblWidth, bag);
		
	////column 1, row 1
		bag.gridx = 1;
		bag.gridy = 1;
			
		txtWidth = new JTextField(5);
		super.add(txtWidth, bag);
		
		//row 2, span both columns
		//take up half the column
		bag.gridx = 0;
		bag.gridy = 2;
		bag.gridwidth = 2;
		btnCalculate = new JButton("Calculate Area");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double width, length;
				
				width = InputHelpers.parseDoubleField(txtLength, "Width", 5, 100);
				length = InputHelpers.parseDoubleField(txtWidth, "Length", 5, 100);
				
				if(length > 0 && width > 0) {
					area = length * width;
					txtArea.setText(OutputHelpers.formattedDouble(area, 2));
					//writeToFile1(length, width, area);
				}
				else {
					txtArea.setText("");
				}
								
		}
	
	}
);
				
		super.add(btnCalculate, bag);
		
		//column 0, row 3
		bag.gridx = 0;
		bag.gridy = 3;
		lblArea = new JLabel();
		lblArea.setText("The area of your room is:");
		super.add(lblArea, bag);
		
		//column 1, row 3
		bag.gridx = 1;
		bag.gridy = 3;
		txtArea = new JTextField(5);
		txtArea.setEditable(false); //read only field
		super.add(txtArea, bag);
		
		//column 0, row 4
		bag.gridx = 0;
		bag.gridy = 4;
		lblFlooringType = new JLabel();
		lblFlooringType.setText("The flooring type is:");
		super.add(lblFlooringType, bag);
		
		//column 1, row 4
		bag.gridx = 1;
		bag.gridy = 4;
		txtFlooringType = new JTextField(10);
		txtFlooringType.setEditable(true); 
		super.add(txtFlooringType, bag);
		
		//column 0, row 4
		bag.gridx = 0;
		bag.gridy = 5;
		lblFlooringCost = new JLabel();
		lblFlooringCost.setText("The flooring cost is:");
		super.add(lblFlooringCost, bag);
				
		//column 1, row 4
		bag.gridx = 1;
		bag.gridy = 5;
		txtFlooringCost = new JTextField(5);
		txtFlooringCost.setEditable(false); //read only field
		super.add(txtFlooringCost, bag);
		
		//column 0, row 5
		bag.gridx = 0;
		bag.gridy = 6;
		lblTotal = new JLabel();
		lblTotal.setText("Total cost is:");
		super.add(lblTotal, bag);
						
		//column 1, row 5
		bag.gridx = 1;
		bag.gridy = 6;
		txtTotal = new JTextField(10);
		txtTotal.setEditable(false); //read only field
		super.add(txtTotal, bag);
		
		//column 0, row 8
		bag.gridx = 0;
		bag.gridy = 8;
		bag.weightx = 0;
		bag.weighty = 0;
		btnCost = new JButton("Calculate Cost");
		btnCost.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtFlooringCost.setText(df.format(TotalCost.getOrderTotal()));
				
				txtTotal.setText(df.format(TotalCost.getTotalCost()));
			}
		});
		super.add(btnCost,bag);	
		
		//column 2, row 8
		bag.gridx = 2;
		bag.gridy = 8;
		bag.weightx = 0;
		bag.weighty = 0;
		btnDisplayOrder = new JButton("Display Order Summary");
		btnDisplayOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder order = new StringBuilder();
				order.append("Full Name: " + CustomerInformation.txtFullName.getText() + "\n");
				order.append("Address: " + CustomerInformation.txtAddress.getText() + "\n");
				order.append("Flooring Type: " + txtFlooringType.getText() + "\n");
				order.append("Floor Area: " + txtArea.getText()+ "\n");
				order.append("Total Cost: " + txtTotal.getText() + "\n");
				OutputHelpers.showStandardDialog(order.toString(),"Order Summary");
			}
		});
		super.add(btnDisplayOrder,bag);

		//column 4, row 8
		bag.gridx = 4;
		bag.gridy = 8;
		bag.weightx = 0;
		bag.weighty = 0;
		btnDisplay = new JButton("Display Order List");
		btnDisplay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			   displayOrderList();
			}
			
			private void displayOrderList() {
				StringBuilder str = new StringBuilder();
				str.append("Order List Summary");
				str.append("\nName\tAddress\tFlooring Type\tTotal Area\tTotal Cost");
				str.append("\n");
				
				DecimalFormat df = new DecimalFormat("$#,###.00");
				String line = null;
				String deliminator = "[,]";
				StringTokenizer row;
				ArrayList<String> listString = FileHelpers.readList("listData.txt");
				
				try {
					//open file
					BufferedReader file = new BufferedReader(new FileReader("listData.txt"));
					//go through each line in file and add to ArrayList
					while((line = file.readLine()) !=null) {
						listString.add(line);
					}
					//if no records in file, exit method
					if (listString.isEmpty()) {
						OutputHelpers.showStandardDialog("File contains no records!", "Wood and Carpet Calculator");
                        return;
					}
					//go through the ArrayList and create output for file items
					for(String tokenLine : listString) {
						
						double fields = 0;
						//get a line to tokenize
						row = new StringTokenizer(tokenLine, deliminator);
						//tokenize the line
						while(row.hasMoreElements()) {
							if (fields < 5)
								str.append(String.format("%-20s", row.nextElement()));
								
							else
								str.append(String.format("%-20s", df.format(Double.parseDouble(row.nextElement().toString()))));
							    str.append(String.format("%-20s", df.format(Double.parseDouble(row.nextElement().toString()))));
							    str.append(String.format("%-20s", row.nextElement()));
							    str.append(String.format("%-20s", row.nextElement()));
								fields++;
						}
						str.append("\n");
					}
					file.close();
					
				 } catch (IOException ex) {
	                    //if any errors occur especially while opening a file
	                    OutputHelpers.showExceptionDialog("ERROR: " + ex.getMessage(), "Wood and Carpet Calculator");
	                }
		                OutputHelpers.showConsole(str.toString());
				}
	        });
				
		super.add(btnDisplay,bag);
		
		//column 6, row 8
		bag.gridx = 6;
		bag.gridy = 8;
		bag.weightx = 0;
		bag.weighty = 0;
		btnSubmit = new JButton("Submit Order");
		btnSubmit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e){
				if(isFormValid()) {

					
					String customerName, customerAddress, flooringType;
					String floorTotal;
					String floorArea;
					
					customerName = CustomerInformation.txtFullName.getText();
					customerAddress = CustomerInformation.txtAddress.getText();
					flooringType = txtFlooringType.getText();
					floorArea = txtArea.getText();
					floorTotal = txtTotal.getText();

					writeToFile(customerName, customerAddress, flooringType, floorArea, floorTotal);
				} else {
					OutputHelpers.showStandardDialog("Please complete the form to save your order.","Wood and Carpet Calculator");
				}
				
			}
		});		
		
			super.add(btnSubmit, bag);
			
		}
	private boolean isFormValid() {
		if(!CustomerInformation.txtFullName.getText().isEmpty() &&
			!CustomerInformation.txtAddress.getText().isEmpty() &&
			!txtFlooringType.getText().isEmpty() &&
			!txtFlooringCost.getText().isEmpty() && 
			!txtArea.getText().isEmpty())
		
		{
		return true;
	}
		return false;
	}
	
	private void writeToFile(String customerName, String customerAddress, String flooringType, String floorArea,
			String floorTotal) {
		StringBuilder str = new StringBuilder();
		str.append(customerName + ",");
		str.append(customerAddress + ",");
		str.append(flooringType + ",");
		str.append(floorArea + ",");
		str.append(floorTotal);
		FileHelpers.writeData(str.toString(), "listData.txt");
		
		JOptionPane.showMessageDialog(null,"Customer order information has been submitted " ,"List Data",JOptionPane.OK_OPTION + JOptionPane.INFORMATION_MESSAGE);
		OutputHelpers.showConsole(str.toString());
	}
	
	
}
	
	

