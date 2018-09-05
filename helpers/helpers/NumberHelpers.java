package helpers;
import java.text.NumberFormat;

public class NumberHelpers 
{
	public static int getRandomNumber(int seed)
	{
		return (int) (Math.random() * seed + 1);
	}
	
	private static NumberFormat decimalFormatter = NumberFormat.getNumberInstance();
	public static NumberFormat getDecimalFormatter(int precision)
	{
		decimalFormatter.setMaximumFractionDigits(precision);
		return decimalFormatter;
	}
	
	private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
	public static NumberFormat getCurrencyFormatter()
	{
		return currencyFormatter;
	}
}
