package de.cjt.taschenrechner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

  public void start(BundleContext context) throws Exception {
    System.out.println("Starting bundle");
    Taschenrechner rechner = new Taschenrechner();
    rechner.main(null);
    // do something with the context, e.g. 
    // register services
  }

  public void stop(BundleContext context) throws Exception {
    System.out.println("Stopping bundle");
    // do something with the context, e.g. 
    // unregister service
  }

} 