package de.cjt.taschenrechner;

import java.util.ArrayList;
import java.util.Collection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.cjt.operation.Operation;

public class Taschenrechner implements BundleActivator {

	ArrayList<Operation> operations = new ArrayList<Operation>();
	Operation service = null;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starting Calculator Bundle and Referenced Bundles");

		// Find Services to be used
		context.getServiceReferences(Operation.class, null);
		Collection<ServiceReference<Operation>> reference = context.getServiceReferences(Operation.class, null);
		for (ServiceReference<Operation> serviceReference : reference) {
			// Cast them and use them
			service = (Operation) context.getService(serviceReference);
			System.out.println("Debug: Found Operation: [" + service.getSign() + "]");
			double numberA = Math.floor(Math.random() * 1000) / 10;
			double numberB = Math.floor(Math.random() * 1000) / 10;
			double solution = Math.floor(service.calculate(numberA, numberB) * 10) / 10;
			System.out.println("Debug: Calculation: [" + numberA + "][" + service.getSign() + "][" + 
					numberB + "][ equals: [" + solution + "]");
		}
	}

	// Bind services to be used by this Service
	protected void bindOperation(Operation operation) {
		if (operation != null && !operations.contains(operation)) {
			operations.add(operation);
			System.out.println("Debug: DS Added Operation: [" + operation.getSign() + "]");
		}
	}

	//Unbind services, that are removed
	protected void unbindOperation(Operation operation) {
		if (operation != null && operations.contains(operation)) {
			operations.remove(operation);
			System.out.println("Debug: DS Removed Operation: [" + operation.getSign() + "]");
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}
}
