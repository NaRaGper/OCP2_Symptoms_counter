package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReaderCounter implements IReaderCounter {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReaderCounter(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public TreeMap<String, Integer> GetList() {
			
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
				
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
					
				while (line != null) {
						
					if (result.containsKey(line)) result.put(line, result.get(line) + 1); 	//if the String already exists, increment it
					else result.put(line, 1);											  	//else add it to the TreeMap 
							
					System.out.println(result);
					line = reader.readLine();
				}	
					
				reader.close();
					
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return result;
	}
	
	public FileWriter WriteList() throws IOException {
		
		FileWriter writer = new FileWriter("result.out");
		Set<Entry<String, Integer>> entries = GetList().entrySet();
		
		writer.write("Results from: " + filepath + "\n\n");
		
        entries.forEach( entry -> {
        	try {
        		writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        	} catch (IOException e) {
        		e.printStackTrace();
        	} 
        });
        
        writer.flush();
        writer.close();
		return writer;
	}
}
