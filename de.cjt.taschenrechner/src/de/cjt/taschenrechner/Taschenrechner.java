package de.cjt.taschenrechner;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.cjt.operation.Operation;

public class Taschenrechner implements BundleActivator {

	ArrayList<Operation> operations = new ArrayList<Operation>();
	Operation service = null;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starting quoteconsumer bundles");

		//ServiceReference reference = context.getServiceReference(Operation.class.getName());
		ServiceReference reference[] = context.getServiceReferences(Operation.class.getName(), null);
		for (ServiceReference serviceReference : reference) {
			service = (Operation) context.getService(serviceReference);
			System.out.println(service.getSign());
		}
		//service = (Operation) context.getService(reference);
		//System.out.println(service.getSign());
	}

	protected void bindOperation(Operation operation) {
		if (operation != null && !operations.contains(operation)) {
			operations.add(operation);
			System.out.println("Debug: Added Operation: [" + operation.getSign() + "]");
		}
	}

	protected void unbindOperation(Operation operation) {
		if (operation != null && operations.contains(operation)) {
			operations.remove(operation);
			System.out.println("Debug: Removed Operation: [" + operation.getSign() + "]");
		}
	}

	private void listAllOperations() {
		System.out.println("Debug: Listing all [" + operations.size() + "] Operations");
		for (Operation operation : operations) {
			System.out.println("Debug: OperationSign: [" + operation.getSign() + "] has Priority: [" + 
					operation.getPriority() + "]");
		}
	}

	public static void main(String[] args) {
		System.out.println("Debug: Programm has started!");
		Taschenrechner rechner = new Taschenrechner();
		rechner.listAllOperations();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}
}
