package helpers;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class OutputHelpers {
	
	private static NumberFormat decimalFormatter = NumberFormat.getNumberInstance();
	private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
	
	public static NumberFormat getDecimalFormatter(int precision) {
		decimalFormatter.setMaximumFractionDigits(precision);
		return decimalFormatter;
	}
	public static NumberFormat getCurrencyFormatter() {
		return currencyFormatter; 
	}
	public static String formattedCurrency(double value) {	
		return currencyFormatter.format(value);
	}
	public static String formattedDouble(double value, int precision) {
		String result;
		
		NumberFormat nf = getDecimalFormatter(precision);
		result = nf.format(value);
		
		return result;
	}
	public static void showConsole(String prompt) {
		System.out.print(prompt);
	}
	public static void showStandardDialog(String prompt, String title)
	{
		JOptionPane.showMessageDialog(null, prompt, title, JOptionPane.PLAIN_MESSAGE);
	}
	public static int showOKCancelDiaglog(String prompt, String title)
	{
		return JOptionPane.showConfirmDialog(null, prompt, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	public static void showExceptionDialog(String prompt, String title)
	{
		JOptionPane.showMessageDialog(null, prompt, title, JOptionPane.ERROR_MESSAGE);
	}
}
