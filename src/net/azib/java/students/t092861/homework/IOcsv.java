package net.azib.java.students.t092861.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Stanislav / 092861
 * 
 */
public class IOcsv extends AbstractIO {
	
	/**
	 * File name or the path to the file.
	 */
	public String param = "";

	/**
	 * Default constructor.
	 * 
	 * @param param
	 *            - parameters of the input/output
	 * @param ctrl
	 *            - controller
	 */
	public IOcsv(String param, Controller ctrl) {
		super(ctrl);
		this.param = param;
	}

	@Override
	ArrayList<Athlete> input() {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		FileInputStream streamIn = null;
		InputStreamReader readerIn;
		BufferedReader bufReader = null;
		int lineNumber = 0;
		try {
			streamIn = new FileInputStream(Const.PACKAGE + getParameters());
			// trying to read as utf-8
			readerIn = new InputStreamReader(streamIn, "UTF8");
			bufReader = new BufferedReader(readerIn);

			// current line
			String curLine = null;
			// Read input file line by line
			while ((curLine = bufReader.readLine()) != null) {
				// converting string array to array list
				inputData = new ArrayList<String>(Arrays.asList(curLine.split(",")));
				athletes.add(ctrl.readData(inputData));
				lineNumber++;
			}
			out.println("\nSuccessful input from " + "\"" + getParameters()+ "\"" + " file!\n");
		} catch (FileNotFoundException en) {
			out.println("\nExeption " + en.getMessage()
					+ ". Please check the file " + getParameters()
					+ " location!");
		} catch (UnsupportedEncodingException e) {
			out.println("\nCouldn't read file as UTF-8");
			// therefore reading it as non-UTF-8 encoding
			readerIn = new InputStreamReader(streamIn);
		} catch (ArrayIndexOutOfBoundsException e) {
			out.println("\nError! File" + getParameters()+ " structure in line " + lineNumber + " is incorrect\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return athletes;
	}

	@Override
	void output(ArrayList<Athlete> athletes) {
		ArrayList<Athlete> results = arrangeInOrder(athletes);
		Iterator<Athlete> itr = results.iterator();		
		try {
			File file = getOutputFile(getParameters());
			
			Writer wOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			
			while (itr.hasNext()) {
				Athlete item = itr.next();
				wOut.write(item.getPlace() + ":"
						+ item.getName() + ","
						+ this.convertDateDMY(item.getBirthday()) + ","
						+ item.getCountry() + ","
						+ item.getSprint100() + ","
						+ item.getLongJump() + ","
						+ item.getShortPut() + ","
						+ item.getHighJump() + ","
						+ this.convertTimeToString(item.getSprint400()) + ","
						+ item.getHurdles() + ","
						+ item.getDiscusThrow() + ","
						+ item.getPoleVault() + ","
						+ item.getJavelinThrow() + ","
						+ this.convertTimeToString(item.getSprint1500()) + ","
						+ item.getScore()+"\n");
//						out.newLine();
			}
			wOut.flush(); // forces any buffered output bytes to be written out
			wOut.close();
			out.println("Successful CSV output to " + getParameters() + " file!");
		} catch (FileNotFoundException en) {
			out.println("\nERROR! The file " + getParameters() + " was not found ");
//			en.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getParameters() {
		return param;
	}
}