package com.xtivia.salesforce.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.xtivia.salesforce.contact.service.ListContactService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/*
 * THsi is the first module load after an application deploy
 */
@Component(immediate=true,
property={"jaxrs.application=true"}, service=Application.class)
@ApplicationPath("salesforcecontact")
public class SalesForceRestService extends Application {
	
	/*
	 * Register our JAX-RS providers and resources and services.
	 */
	@Override
	public Set<Object> getSingletons() {
		
		Set<Object> singletons = new HashSet<Object>();
		//add the automated Jackson marshaller for JSON
		singletons.add(new JacksonJsonProvider());
		singletons.add(new ListContactService());
		return singletons;
	}
	
}