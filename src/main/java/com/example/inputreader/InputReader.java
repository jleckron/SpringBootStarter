package com.example.inputreader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;  

public class InputReader {
	
	public List<String> fileLineEntries = new ArrayList<>(); 
	String filePath = "";
	
	public InputReader(String path) throws FileNotFoundException {
		this.filePath = path;
		this.readInput();
	}
	
	public void readInput() {
		String line = "";
		String splitBy = ",";	
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while((line = br.readLine()) != null) {
				String[] employee = line.split(splitBy);
				this.fileLineEntries.add(Arrays.toString(employee));
			}
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}