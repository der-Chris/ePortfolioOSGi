package de.cjt.operation.plus;

import de.cjt.operation.Operation;

/**
 * Implements the Operator Service
 * @author christianverdion
 *
 */
public class Plus implements Operation {

	@Override
	public String getSign() {
		return "+";
	}

	@Override
	public double calculate(double a, double b) {
		return a + b;
	}

	@Override
	public double getPriority() {
		return 10;
	}

}
