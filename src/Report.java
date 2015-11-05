import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/02/2015
 * This Class is used to accept payroll records from the user and the same is written to a text file.
 */
public class Report {
	DecimalFormat twoDecimal = new DecimalFormat("$0.00");
	DecimalFormat hourDecimal = new DecimalFormat("000");
	/**
	 * This is the default constructor being called every time an instance of Report is created.
	 */
	public Report() {
		//gets the list of employee objects
		ArrayList<Employee> employeeList=ReadData.getEmployees();
		//sorts employees in ascending order
		Collections.sort(employeeList);
		//creates a string array which is fed to the dropdown JOptionPane
		String[] dropDownEmpNames= new String[employeeList.size()];
		//gets the name of employee from the employee list and adds to the dropdown list.
		for(int i=0;i<employeeList.size();i++){
			dropDownEmpNames[i]=employeeList.get(i).getName();
		}
		String input=null;
		//gets user input of the employee whose report is to be generated
		while(input==null){
			input = (String) JOptionPane.showInputDialog(null, "Employee names",
					"Select Employee", JOptionPane.QUESTION_MESSAGE, null, 
					dropDownEmpNames, // Array of choices
					dropDownEmpNames[0]); // Initial choice
		}
		//calls the generate report function.
		String fileName=generateReport(input,employeeList);
		JOptionPane.showMessageDialog(null, fileName+".txt file is generated");
	}

	/**
	 * This method creates a txt file with the name as the employees name whose report is to be generated and 
	 * writes all the details of the employee into that file
	 * 
	 * 
	 * @param input name of the employee whose report is to be generated
	 * @param employees list of employee objects from which all the details pertaining to the employee is to be extracted.
	 */
	private String generateReport(String input,ArrayList<Employee> employees) {
		try{
			//splits the name using the space into first and last name
			String[] empName=input.split(" ");
			//Concatenating the first character of the first name and the entire second name
			String fileName=empName[0].charAt(0)+empName[1]; 
			//declaring file writer object 
			FileWriter employeeFile;

			employeeFile = new FileWriter(fileName+".txt");
			//Instantiating Buffer Writer object
			BufferedWriter employeeBuffer = new BufferedWriter(employeeFile);
			//logic to iterate through each employee from the employee list
			for(Employee e:employees){
				//if the employee in the list matches the employee input from the user then we write into the file
				if(e.getName().equals(input)){
					employeeBuffer.write("************ Payroll Report *************************");
					employeeBuffer.newLine();
					employeeBuffer.write("Employee Name: "+e.getName());
					employeeBuffer.newLine();
					employeeBuffer.write("Hours: "+hourDecimal.format(e.getHours()));
					employeeBuffer.newLine();
					employeeBuffer.write("Wages: "+twoDecimal.format(e.getWages()));
					employeeBuffer.newLine();
					employeeBuffer.write("Gross Pay: "+twoDecimal.format(e.getGrossIncome()));
					employeeBuffer.newLine();
					employeeBuffer.write("Overtime Pay: "+twoDecimal.format(e.getOverTimePay())+" (included in gross pay)");
					employeeBuffer.newLine();
					employeeBuffer.write("*****************************************************");
					employeeBuffer.newLine();
					break;
				}
			}

			employeeBuffer.close();
			return fileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * this is the static method used to kick start the program
	 * @param args args this parameter gets inputs from the console.
	 * 
	 */
	public static void main(String[] args)  
	{
		new Report();
	}

}
