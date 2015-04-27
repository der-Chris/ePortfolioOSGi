package de.cjt.operation;

/**
 * Declared the Service, that can be Consumed
 * @author christianverdion
 *
 */
public interface Operation {

	/**
	 * Returns the Symbol the operation represents
	 * @return
	 */
	public String getSign();
	
	/**
	 * Calculates the Equation and returns the Solution
	 * @param a First operant
	 * @param b Second operant
	 * @return the Solution
	 */
	public double calculate(double a, double b);
	
	/**
	 * Returns the Priority of the Operation
	 */
	public double getPriority();
}
