
import javax.swing.JOptionPane;

import java.io.*;   
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/02/2015
 * This Class is used to read all the Employees payroll details one by one and also create an new overtime report.
 */
public class ReadData {
	//parameter used to display all wages, gross salaries etc to be displayed in currency format
	DecimalFormat twoDecimal = new DecimalFormat("$0.00");

	/**
	 * This is the default constructor being called every time a new ReadData instance is created.
	 */
	public ReadData ()
	{
		try {  
			//gets all the employees from the getEmployees method from the Report class where we read the 
			ArrayList<Employee> employees=getEmployees();
			//declaring and instantiating file writer object 
			FileWriter overtimeWriter= new FileWriter("overtime.txt");
			//Instantiating Buffer Writer object to write into overtime.txt
			BufferedWriter overtimeWriterBuffer = new BufferedWriter(overtimeWriter);
			for(Employee emp:employees){
				JOptionPane.showMessageDialog(null, "Name: "+emp.getName() + "\nHours: "
						+ emp.getHours() + "\nWages: " + twoDecimal.format(emp.getWages())+"\nGross Income: "+twoDecimal.format(emp.getGrossIncome()), "Result",
						JOptionPane.PLAIN_MESSAGE );
				overtimeWriterBuffer.write(emp.getName());
				overtimeWriterBuffer.newLine();
				overtimeWriterBuffer.write(twoDecimal.format(emp.getOverTimePay()));
				overtimeWriterBuffer.newLine();
			}

			overtimeWriterBuffer.close();
			System.exit(0);
		}//end try
		catch (IOException e ) { System.out.println(e); }        
	}//end ReadData

	/**
	 * This method reads the payroll file and creates Employee objects.
	 * @return List of Employee objects
	 */
	static ArrayList<Employee> getEmployees() {
		FileReader file;
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		try {
			//Instantiate the file reader object
			file = new FileReader("payroll.txt");

			BufferedReader payrollBuffReader = new BufferedReader(file);
			String line;
			//following while loop reads the payroll file and creates a list of employee objects.
			while((line = payrollBuffReader.readLine()) != null && !line.equals(""))
			{
				Employee employee =new Employee();
				employee.setName(line);
				employee.setHours(Double.parseDouble(payrollBuffReader.readLine()));
				employee.setWages(Double.parseDouble(payrollBuffReader.readLine()));
				employeeList.add(employee);
			}
			payrollBuffReader.close();
			return employeeList;
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
		new ReadData();
	}//end main
}//end ReadData
