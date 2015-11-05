import javax.swing.JOptionPane;
/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/04/2015
 * This class provides user Login interface
 *
 */
public class Login {
	/**
	 * this is the static method used to kick start the program
	 * 
	 * this method inputs the user name and password and provides the menu console 
	 * @param args this parameter gets inputs from the console.
	 */
	public static void main(String[] args)  
	{ 
		//this parameter tracks the number of incorrect attempts to login to the application
		int noOfAccess=0;
		while(true){
			boolean access = false;	
			String message = "welcome" + "\n", response;
			message += "enter your name";
			message += "\n" + " ";   
			String name = JOptionPane.showInputDialog(message);
			String password;
			name = name.trim();
			name = name.toUpperCase();

			//verifies username
			if (name.equals("AKSHAY")) 
			{ 
				JOptionPane.showMessageDialog(null,"hello " + name);
				message = "enter your password";
				message += "\n" + " ";
				password = JOptionPane.showInputDialog(message);
				password = password.trim();
				password = password.toUpperCase();
				//verifies password
				if (password.equals("AUTUMN")) 
				{ 
					access = true;
				}
				else
				{
					//increments if wrong password is entered
					noOfAccess++;
					//allows the user to reenter the password only if he has done not more then 3 errors.
					if (noOfAccess<3)
						JOptionPane.showMessageDialog(null, "incorrect password");
					else{
						JOptionPane.showMessageDialog(null, "You have entered Invalid credentials more then three times, Please try again later!");
						System.exit(1);}

				}
			}
			else
			{
				//increments if wrong user name is entered
				noOfAccess++;
				//allows the user to reenter the user name only if he has done not more then 3 errors.
				if(noOfAccess<3)
					JOptionPane.showMessageDialog(null, "incorrect login name");
				else{
					JOptionPane.showMessageDialog(null, "You have entered Invalid credentials more then three times, Please try again later!");
					System.exit(1);}
			}
			//if the user name and password entered is correct then we grant access and instantiate the menu
			if(access == true)
			{
				try {
					Menu m = new Menu(); 
					System.exit(1);
				}
				catch (Exception e) { System.out.println(e);} 
			}
		}
	}//end main
}//end class
