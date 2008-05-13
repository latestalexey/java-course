package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.Document;

/**
 * CSVOutput - class for generating csv file for outputting decathlon results
 *
 * @version 1.0
 * @author Romi Agar
 */
public class CSVOutput implements DataOutput{
	private static final Logger LOG = Logger.getLogger(XMLOutput.class.getSimpleName());
	private File out;			
	
	public CSVOutput() {
		this(null);
	}

	CSVOutput(File out) {
		this.out = out;
	}


	public void outputResults(List<Athlete> results, String... parameter) {
		if (results == null){
			LOG.severe("Null parameter for athlete list.");
			exit(14);
		}
		else if (parameter == null || parameter.length == 0 || parameter[0].equals("")){
			LOG.severe("No output file name given.");
			exit(15);
		}
		else{
			Document xmlDoc = XMLOutput.makeXMLDocument(results);
			URI xsdPath = null;
			URI stylesheetPath = null;
			try {
				xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").toURI();
				stylesheetPath = Decathlon.class.getResource("xml/csv.xsl").toURI();
			}
			catch (URISyntaxException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "URI syntax error.", e);
				else
					LOG.log(Level.SEVERE, "URI syntax error.");
			}
			if (xsdPath != null && !XMLOutput.isValidXML(xmlDoc.asXML(), xsdPath.getPath())){
				LOG.warning("XML is not valid.");
			}
			
			byte[] transformedDoc = XMLOutput.transformDocument(xmlDoc, stylesheetPath);
			if (out == null)
	        	out = new File(parameter[0]);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(out);
				fos.write(transformedDoc);
			}
			catch (FileNotFoundException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Cannot create new file.", e);
				else
					LOG.log(Level.SEVERE, "Cannot create new file.");
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Cannot write to file.", e);
				else
					LOG.log(Level.SEVERE, "Cannot write to file.");
			}
			finally{
				if (fos != null)
					try {
						fos.close();
					}
					catch (IOException e) {
						if (System.getProperty("program.debug") != null)
							LOG.log(Level.SEVERE, "Cannot close output stream.", e);
						else
							LOG.log(Level.SEVERE, "Cannot close output stream.");
					}
			}
			
		}
	}
	
	void exit(int errorCode) {
		   System.exit(errorCode);
	}

}
