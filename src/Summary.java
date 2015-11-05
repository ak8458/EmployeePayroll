import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/02/2015
 * This class provides the Overtime Summary
 */

public class Summary {
	DecimalFormat twoDecimal = new DecimalFormat("$0.00");
	/**
	 * default constructor called when a summary instance is created
	 */
	public Summary() {
		// TODO Auto-generated constructor stub
		generateOvertimeReport();
	}

	/**
	 * This method reads the overtime txt file and generates the overtime summary for employee name starting from A-F and 
	 * G-L and also provides the grand total of the overtime from names starting from A-Z
	 */
	private void generateOvertimeReport() {
		// TODO Auto-generated method stub

		char testVariable;
		double overtimeAF=0,overtimeGL=0,overtimeMZ=0,grandTotal;
		try{
			String line;
			//new filereader object to read the overtime.txt file
			FileReader overtimeFile = new FileReader("overtime.txt");
			//new BufferedReader object to read the overtime.txt file
			BufferedReader overtimeBuffReader = new BufferedReader(overtimeFile);
			//control breaking logic using while loop
			while((line=overtimeBuffReader.readLine()) != null){
				testVariable=line.charAt(0);
				//logic to add up the overtime of employees names starting from A-F
				if((testVariable>='a' && testVariable<='f')||(testVariable>='A' && testVariable<='F')){
					overtimeAF+=Double.parseDouble(overtimeBuffReader.readLine().substring(1));

				}
				//logic to add up the overtime of employees names starting from G-L
				else if((testVariable>='g' && testVariable<='l')||(testVariable>='G' && testVariable<='L')){
					overtimeGL+=Double.parseDouble(overtimeBuffReader.readLine().substring(1));
				}
				//logic to add up the overtime of employees names starting from M-Z
				else{
					overtimeMZ+=Double.parseDouble(overtimeBuffReader.readLine().substring(1));
				}
			}
			overtimeBuffReader.close();
			//calculating grand total of all overtime wages.
			grandTotal=overtimeAF+overtimeGL+overtimeMZ;

			//displaying summary
			JOptionPane.showMessageDialog(null, "Total overtime for Employees having first name b/w A-F : "+twoDecimal.format(overtimeAF)+ "\nTotal overtime for Employees having first name b/w G-L : "
					+twoDecimal.format(overtimeGL) + "\nGrand Overtime Total(A-Z) : " + twoDecimal.format(grandTotal), "Result",
					JOptionPane.PLAIN_MESSAGE );

		}//end try
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}//end generateOvertimeReport


	/**
	 * this is the static method used to kick start the program
	 * @param args args this parameter gets inputs from the console.
	 * 
	 */
	public static void main(String[] args){
		new Summary();
	}//end main

}//end class
