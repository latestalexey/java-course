package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;
import net.azib.java.students.t040719.homework.DecathlonConstants;
import net.azib.java.students.t040719.homework.ISOCountry;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.exceptions.ConfigurationException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

/**
 * XMLOutput - class for generating xml output and saving it to a file
 *
 * @version 1.0
 * @author Romi Agar
 */
public class XMLOutput implements DataOutput{
	private static final Logger LOG = Logger.getLogger(XMLOutput.class.getSimpleName());
	private File out;			
	
	public XMLOutput() {
		this(null);
	}

	XMLOutput(File out) {
		this.out = out;
	}
	
	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		   System.exit(errorCode);
	}
	
	/**
	 * @param results a list of athlete objects
	 * @return returns a DOM4J xml document object
	 */
	public static Document makeXMLDocument(List<Athlete> results){
		Document document = DocumentHelper.createDocument();
        Element root = document.addElement("decathlon")
        	.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
        	.addAttribute(new QName("xsi:noNamespaceSchemaLocation",Namespace.NO_NAMESPACE), "DecathlonResults.xsd");
        Integer i = 1;
        for (Athlete a: results){
	        Element athlete = root.addElement("athlete");
        	athlete.addElement("name").addText(a.getName());
        	athlete.addElement("birthday").addText(a.getBirthdayString());
        	Element country = athlete.addElement("country");
		    country.addElement("code").addText(a.getCountryCode());
		    country.addElement("name").addText(ISOCountry.getCountryName(a.getCountryCode()));
	        athlete.addElement("score").addText(Integer.toString(a.getDecathlonPoints()));
	        athlete.addElement("place").addText(i.toString());
	        for (int j=0; j<DecathlonConstants.values().length; j++){
		        Element event = athlete.addElement("event")
		            .addAttribute("order", Integer.toString(j+1));
		        event.addElement("name").addText(DecathlonConstants.getOrdinal(j).getName());
	        	event.addElement("result").addText(String.format(Locale.US, "%.2f", a.getDecathlonResult(j)));
	        	event.addElement("unit").addText(DecathlonConstants.getOrdinal(j).getUnit());
		    }
	        i++;
	    }
        return document;
	}
	
	/**
	 * Outputs the athlete results from given list to an output file
	 * @param results a list of athletes
	 * @param parameter single parameter output file name
	 */
	public void outputResults(List<Athlete> results, String... parameter) {
		if (results == null){
			LOG.severe("Null parameter for athlete list.");
			exit(13);
		}
		else if (parameter == null || parameter.length == 0 || parameter[0].equals("")){
			LOG.severe("No output file name given.");
			exit(12);
		}
		else{
			Document document = makeXMLDocument(results);
			String xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").getPath();
			if (!isValidXML(document.asXML(), xsdPath))
				LOG.warning("XML file is not valid.");
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        XMLWriter writer;
	        if (out == null)
	        	out = new File(parameter[0]);
			try {
				writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(out),"UTF8"),format);
		        writer.write(document);
		        writer.close();
		    }
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Could not create xml output file", e);
				else
					LOG.log(Level.SEVERE, "Could not create xml output file");
				exit(13);
			}
		}	
	}
	
	public static boolean isValidXML(String xmlAsString, String xsdPath){
		Validator validator = null;
		try {
			validator = new Validator(xmlAsString, xsdPath);
			validator.useXMLSchema(true);
		}
		catch (ConfigurationException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Error validating XML file.", e);
			else
				LOG.log(Level.SEVERE, "Error validating XML file.");
		}
		catch (SAXException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Error validating XML file.", e);
			else
				LOG.log(Level.SEVERE, "Error validating XML file.");
		}
		if (validator != null)
			return validator.isValid();
		return false;

	}
	
	public static Document styleDocument(Document document, URI stylesheetSource){
	        TransformerFactory factory = TransformerFactory.newInstance();
	        DocumentResult result = null;
	        Document transformedDoc = null;
	        try {
	        	File xsltFile = new File(stylesheetSource.getPath());
	        	Source xsltSource = new StreamSource(xsltFile);
	        	Transformer transformer = factory.newTransformer(xsltSource);
	        	DocumentSource source = new DocumentSource(document);
		        result = new DocumentResult();
				transformer.transform( source, result );
			}
			catch (TransformerException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.",e);
				else
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.");
			}
			if (result != null)
				transformedDoc = result.getDocument();
			
	        return transformedDoc;
	}
	
	public static byte[] transformDocument(Document document, URI stylesheetSource){
        TransformerFactory factory = TransformerFactory.newInstance();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
        	File xsltFile = new File(stylesheetSource.getPath());
        	Source xsltSource = new StreamSource(xsltFile);
        	Transformer transformer = factory.newTransformer(xsltSource);
        	//Transformer transformer = factory.newTransformer(new StreamSource( new FileInputStream(new File(stylesheetSource.getPath())), "UTF-8"));
        	//Transformer transformer = factory.newTransformer(new StreamSource( stylesheetPath ));
        	transformer.transform( new StreamSource(new ByteArrayInputStream(document.asXML().getBytes("UTF-8"))), new StreamResult(out));

		}
		catch (TransformerException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.",e);
			else
				LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.");
		}
		catch (UnsupportedEncodingException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Problem with xml encoding.",e);
			else
				LOG.log(Level.SEVERE, "Problem with xml encoding.");
		}

	
        return out.toByteArray();
	}

}
