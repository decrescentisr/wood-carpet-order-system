package helpers;
public class ApplicationHelpers 
{
	public static void displayApplicationInformation(String appName, String week, String description)
	{
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("*************************************************************");
		prompt.append("\nWelcome to the " + appName + " program");
		//prompt.append("\nCIS355A: Week " + week);
		prompt.append("\nProgrammer: Robert DeCrescentis");
		prompt.append("\n" + description);
		prompt.append("\n*************************************************************");
	
		OutputHelpers.showStandardDialog(prompt.toString(), appName);
	}
	public static void terminateApplication(String programName)
    {
		StringBuilder prompt = new StringBuilder();
		
		prompt.append("\n*************************************************************");
		prompt.append("\nTerminating " + programName);
		prompt.append("\n*************************************************************");
        OutputHelpers.showStandardDialog(prompt.toString(), programName);
        
        System.exit(0);
    }
}
