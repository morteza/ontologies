
/**
 * File: TestJena.java
 * Date: Apr 21, 2012
 * Author: Morteza Ansarinia <ansarinia@me.com>
 */

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class TestJena {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = ModelFactory.createOntologyModel();
		
		String Namespace = "http://www.itrc.ac.ir/ontologies/test/";
		
		Resource r = model.createResource(Namespace + "resource1");
		Property p = model.createProperty(Namespace + "property1");
		
		r.addProperty(p,"object1",  XSDDatatype.XSDstring);
		
		model.write(System.out, null);
	}

}
