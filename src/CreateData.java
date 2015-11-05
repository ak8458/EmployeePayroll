import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 

import javax.swing.JOptionPane;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/04/2015
 * This Class is used to accept payroll records from the user and the same is written to a text file.
 */
public class CreateData {


	/**
	 * This is the default constructor being called everytime an instance of CreateData is created.
	 */
	CreateData(){

		do{
			Write();
			//Pops up a yes/no dialog if you need to add some more employee payroll records.
			if (JOptionPane.showConfirmDialog(null, "Would you like to add some more payroll records?", "Input",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				// yes option
			} else {
				// no option
				break;
			}
		}
		while(true);
	}

	/**
	 * this is the static method used to kick start the program
	 * @param args args this parameter gets inputs from the console.
	 * 
	 */
	public static void main(String[] args)
	{
		new CreateData();
	}

	/**
	 * This is a static method which accepts payroll inputs from the user and prints to the text file.
	 */
	static void Write()
	{
		try {  
			//parameters to be written to the text file
			String firstLine="", secondLine="", thirdLine="", number="";
			//File object where we need to inject our data
			File check = new File("payroll.txt");  
			//declaring file writer object 
			FileWriter file;

			/*if file already exists then append the content to the same file else 
			create a new file and write in it*/
			if(check.exists()) 
				//allows appending of data to file
				file = new FileWriter("payroll.txt", true);
			else
				file = new FileWriter("payroll.txt");
			//instanciating Buffer Writter object
			BufferedWriter buffer = new BufferedWriter(file);
			int size, count = 1;

			//get the count of records to be added. It should not be null or blank
			while(number == null || number.equals("")) {
				number =JOptionPane.showInputDialog("how many records?");
				//checks if the value input is a positive integer
				if(number!=null && !number.equals("") && !number.matches("^\\d+$")){
					JOptionPane.showMessageDialog(null,"Please Enter a positive integer value only");
					number=null;
				}
				//checks if the value input is a non zero value
				if(number!=null && !number.equals("") && Integer.parseInt(number)==0){
					JOptionPane.showMessageDialog(null,"Please Enter a non zero integer value");
					number=null;
				}
			}
			//set size with the count entered by the user.
			size = Integer.parseInt(number);


			do {
				//gets name of the employee from the user. It should not be null or blank
				while(firstLine == null || firstLine.equals("")) {
					firstLine = JOptionPane.showInputDialog("Enter name");
				}
				//gets employee hours from the user. It should not be null or blank
				while(secondLine == null || secondLine.equals("")) {
					secondLine = JOptionPane.showInputDialog("Enter hours");
					//checks if the value input is a positive integer
					if(secondLine!=null && !secondLine.equals("") && !secondLine.matches("^\\d+$")){
						JOptionPane.showMessageDialog(null, "Please enter hours as positive integers");
						secondLine=null;
					}
					//checks if the value input is a non zero value
					if(secondLine!=null && !secondLine.equals("") && Integer.parseInt(secondLine)==0){
						JOptionPane.showMessageDialog(null, "Please Enter a non zero hour");
						secondLine=null;
					}
				}


				//gets per hour wages of the employee from the user. It should not be null or blank
				while(thirdLine == null || thirdLine.equals("")) {
					thirdLine = JOptionPane.showInputDialog("Enter wage");
					//checks if the value input is a number
					if(thirdLine!=null && !thirdLine.equals("") && !thirdLine.matches("^[0-9]*\\.?[0-9]*$")){
						JOptionPane.showMessageDialog(null, "Please enter valid wage as a positive number");
						thirdLine=null;
					}
					//checks if the value input is a non zero value
					if(thirdLine!=null && !thirdLine.equals("") && Float.parseFloat(thirdLine)<=0){
						JOptionPane.showMessageDialog(null, "Wages cannot be negative or zero");
						thirdLine=null;
					}
				}

				//writes to the file
				buffer.write(firstLine);
				buffer.newLine();
				buffer.write(secondLine);
				buffer.newLine();
				buffer.write(thirdLine);
				buffer.newLine();
				//increases count after every employee detail is added
				count++;
				firstLine=null;
				secondLine=null;
				thirdLine=null;

			}while(count <= size);
			buffer.close();

			JOptionPane.showMessageDialog(null, "data processed",
					"Result", JOptionPane.PLAIN_MESSAGE );

		}//end try

		catch (Exception e) { System.out.println(e); }//end catch 

	}//end write



}//end class


