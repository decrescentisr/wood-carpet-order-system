import javax.swing.JPanel;

public class TotalCost extends JPanel
{
	public static final double COST_FLOORING = 20.00;
	public static final double COST_CARPET = 10.00;
	
	public static String NONE = "None";
	public static final String FLOORING = "Flooring";
	public static final String CARPET = "Carpet";
	
	
	public static double getOrderTotal() {
		double total = 0;
		if(WoodCarpet.rdoCarpet.isSelected()) {
			total += TotalCost.COST_CARPET;
		}
		else if(WoodCarpet.rdoWood.isSelected()) {
			total += TotalCost.COST_FLOORING;
		}
		return total;
	}
	public static double getTotalCost() {
		double total = 0;
		if(WoodCarpet.rdoCarpet.isSelected()) {
			total = COST_CARPET * Calculations.area;
		}
		if(WoodCarpet.rdoWood.isSelected()) {
			total = COST_FLOORING * Calculations.area;
		}
		return total;
	}
}
