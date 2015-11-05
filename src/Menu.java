import javax.swing.JOptionPane;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/04/2015
 * This Class is used to display menu and get options from the user
 */
public class Menu {
	/**
	 * This is the default constructor being called every time a new Menu instance is created
	 */
	public Menu()
	{
		String message = "welcome" + "\n", response;

		message += "\n" + "enter...";
		message += "\n" + "  1 to enter payroll data";
		message += "\n" + "  2 to view payroll data";
		message += "\n" + "  3 to generate report by employee";
		message += "\n" + "  4 to generate overtime summary";
		message += "\n" + "  5 to exit" + "\n" + " ";
		
		//default value parameter which is set to Y stating to enter the do while statement a value N will allow to break from the loop
		char answer = 'Y';

		do {

			try {  
				//gets the user input
				response  = JOptionPane.showInputDialog(message);
				//parses response to integer type
				int choice = Integer.parseInt(response);
				//switch logic to instantiate based on the user input
				switch (choice) {
				//allows user to add payroll data by instantiating CreateData object
				case 1:  new CreateData();
				answer = 'N'; System.exit(1);
				break;
				//allows user to read payroll data by instantiating ReadData object
				case 2:  new ReadData();
				answer = 'N';  System.exit(1);
				break;
				//allows user to create payroll report for a particular employee by instantiating Report object
				case 3:  new Report();
				answer = 'N';  System.exit(1);
				break;
				//allows user to create overtime summary report for all employees by instantiating Summary object
				case 4:  new Summary();
				answer = 'N';  System.exit(1);
				break;
				//allows user to exit from the program.
				case 5:  answer = 'N';  System.exit(1);
				break;
				default: { answer = 'Y'; choice = 0;
				JOptionPane.showMessageDialog(null,"enter a number: 1 - 5");
				} 
				}//end switch
			}//end try
			catch (Exception e ) { JOptionPane.showMessageDialog(null,"enter a number: 1 - 5");System.out.println(e); }  
		}while(answer == 'Y' || answer == 'y');  //end do while

	}//end default constructor

	public static void main(String[] args)  
	{ 
		new Menu();
	}//end main
}//end class 
