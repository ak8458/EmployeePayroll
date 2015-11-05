/**
 * 
 * @author Akshay Patil
 * Student ID A20356673 Current Date:11/04/2015
 * This Class is used to create Employee objects with its related parameters and getter setter methods.
 * This class also implements the COmparable interface to sort Employees in ascending order.
 *
 */
public class Employee implements Comparable<Employee> {

	//Employee parameters
	private String Name;
	private double hours;
	private double wages;
	private double grossIncome;
	private double overTimePay=0;

	/**
	 * getName 
	 * @return name of the employee
	 */
	public String getName() {
		return Name;
	}
	/**
	 * setName
	 * @param name Name of the employee
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * getHour
	 * @return hours worked by employee
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * setHours
	 * @param hours number of hours worked by employee 
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

	/**
	 * getWages
	 * @return returns per hour wages of the employee
	 */
	public double getWages() {
		return wages;
	}

	/**
	 * setWages
	 * @param wages per hour wages of the employee
	 */
	public void setWages(double wages) {
		this.wages = wages;
	}

	/**
	 * This method uses the Employee object properties, calculates and then returns the grossIncome 
	 * @return gross income earned by the employee
	 */
	public double getGrossIncome() {
		if(this.hours>40)
			grossIncome=this.wages*(this.hours-40)*1.5 + this.wages*40;
		else
			grossIncome=this.wages*this.hours;
		return grossIncome;
	}

	/**
	 * This method uses the Employee object properties, calculates and then returns the overtime pay
	 * @return Over time earned by the employee
	 */
	public double getOverTimePay() {
		if(this.hours>40)
			overTimePay=(this.wages*(this.hours-40)*1.5);
		return overTimePay;
	}

	@Override
	/**
	 * This method is used to sort employees in a collection in an ascending order by comparing there String names.
	 */
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(emp.getName());
	}



}//end class
