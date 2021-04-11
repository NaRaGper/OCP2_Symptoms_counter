package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Anything that will read Strings from a source, line by line.
 * 
 * It will order itself alphabetically by default.
 * Duplicates will increment the number of times symptoms are read by one.
 */
public interface IReaderCounter {
	/**
	 * If no data is available, returns an empty list
	 * 
	 * @return an alphabetically ordered list of Strings read and the number of times they occur in a given file
	 */
	TreeMap<String, Integer> GetList();
	
	/**
	 * Writes the Strings from GetList() in a given file
	 * 
	 * @return the Strings from GetList() formated
	 */
	FileWriter WriteList() throws IOException;
}
