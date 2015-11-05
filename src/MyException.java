
/**
 * 
 * @author Akshay Patil 
 * Student ID A20356673 Current Date:09/17/2015
 * The following class is used to  handle custom exception's and create custom error messages. This class is of type Exception
 */
public class MyException extends Exception{
	//declare local string variable to get and set custom error messages.
	private String msg;
	/**
	 * Accessor method for the variable msg
	 * @return error message in string format
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * Mutator method for the variable msg
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * Constructor for the exception class of type exception
	 * @param msg
	 */
	public MyException(String msg) {
		//calling parent Class Constructor
        super(msg);
        //setting error message to global variable msg
        this.setMsg(msg);
    }
	
}
