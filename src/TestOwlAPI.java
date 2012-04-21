
/**
 * File: TestOwlAPI.java
 * Date: Apr 21, 2012
 * Author: Morteza Ansarinia <ansarinia@me.com>
 */

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.SystemOutDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class TestOwlAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			
			// Load an ontology from the web (via document IRI)
			IRI documentIRI = IRI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl");
			OWLOntology pizzaOntology = manager.loadOntologyFromOntologyDocument(documentIRI);
			System.out.println("Loaded ontology: " + pizzaOntology);
			
			File file = new File("~/pizza_local.owl");
			manager.saveOntology(pizzaOntology, IRI.create(file.toURI()));
			
			OWLOntologyFormat owlFormat = manager.getOntologyFormat(pizzaOntology);
			System.out.println("Ontology format: " + owlFormat);
			
			// Save the ontology in owl/xml format (current format is RDF/XML)
			OWLXMLOntologyFormat owlxmlFormat = new OWLXMLOntologyFormat();
			if(owlFormat.isPrefixOWLOntologyFormat()) {
				owlxmlFormat.copyPrefixesFrom(owlFormat.asPrefixOWLOntologyFormat());
			}
			manager.saveOntology(pizzaOntology, owlxmlFormat, IRI.create(file.toURI()));

			// Print ontology
			OWLOntologyDocumentTarget documentTarget = new SystemOutDocumentTarget();
			manager.saveOntology(pizzaOntology, owlFormat, new SystemOutDocumentTarget());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
