package com.example.inputreader;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;  

public class InputReader {
	
	public List<HashMap<String, String>> fileLineEntries = new ArrayList<>(); 
	public List<String> headers = new ArrayList<>(); 
	
	public InputReader(String path) throws FileNotFoundException {
		this.readInput(path);
	}
	
	
	/*
	 * 	This function opens and reads specified file, and stores its contents in queryable HashMap, and the records headers
	 *  @param	filePath	Path to file
	 *  
	 *  @return void
	 *  @see readInput
	 */
	public void readInput(String filePath) {
		String line = "";
		String splitBy = ",";	
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String[] headerLine = br.readLine().split(splitBy);
			while((line = br.readLine()) != null) {
				HashMap<String, String> lineObject = new HashMap<String, String>();
				String[] employee = line.split(splitBy);
				for(int i=0; i<headerLine.length; i++) {
					lineObject.put(headerLine[i], employee[i]);
				}
				this.fileLineEntries.add(lineObject);
			}
			br.close();
			headers = Arrays.asList(headerLine);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}