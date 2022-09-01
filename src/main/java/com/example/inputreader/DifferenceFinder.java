package com.example.inputreader;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class DifferenceFinder {
	String commonColKey = "";
	
	public List<HashMap<String, String>> file1Content = new ArrayList<>(); 
	public List<HashMap<String, String>> file2Content = new ArrayList<>(); 
	
	HashSet<String> commonCols = new HashSet<String>();

	/*  Constructor
	 *  @param	file1			InputReader object of file 1
	 *  @param	file2			InputReader object of file 2
	 *  @param	commonColKey 	Join key for files
	 *  
	 *  @return void
	 *  @see DifferenceFinder
	 */
	public DifferenceFinder(InputReader file1, InputReader file2, String commonColKey) {
		this.commonColKey = commonColKey;
		
		this.file1Content = file1.fileLineEntries;
		this.file2Content = file2.fileLineEntries;
		
		this.commonCols = findCommonCols(file1.headers, file2.headers);
	}
	
	
	/*
	 * 	This function finds shared columns other than the given unique identifier column.
	 *  @param	file1headers	Column headers in file1
	 *  @param	file2headers	Column headers in file2
	 *  
	 *  @return commons			HashSet of common column headers not including key
	 *  @see findCommonCols
	 */
	public HashSet<String> findCommonCols(List<String> file1headers, List<String> file2headers) {
		HashSet<String> headerSet1 = new HashSet<String>(file1headers);
		HashSet<String> headerSet2 = new HashSet<String>(file2headers);
		
		HashSet<String> commonHeads = new HashSet<String>();
		
		for(String header : headerSet1) {
			if(headerSet2.contains(header)) commonHeads.add(header);
		}
		commonHeads.remove(commonColKey);
		return commonHeads;
	}
	
	
	/*
	 *  This function finds the value groupings based on the following:
	 *  Given a singular unique identifier column,  
	 *  	Group A contains entries of file 1 where the value does not exist in file 2
	 *  	Group B contains entries of files 1 and 2 that share the same identifier value,
	 *  		but differ among any other shared column value. 
	 *  
	 *  @return void
	 *  @see findGroupings
	 */
	public void findGroupings() {
		System.out.println(file1Content);
		System.out.println(file2Content);
		List<HashMap<String, String>> groupA = new ArrayList<HashMap<String, String>>(); 
		List<HashMap<String, String>> groupB = new ArrayList<HashMap<String, String>>(); 
		
		for(HashMap<String, String> entry1 : file1Content) {
			boolean existsInBothRecords = false;
			for(HashMap<String, String> entry2 : file2Content) {
				//If common column value exists in both records
				if(entry1.get(commonColKey).equals(entry2.get(commonColKey))) {
					existsInBothRecords = true;
					for(String auxHeader : commonCols) {
						if(!entry1.get(auxHeader).equals(entry2.get(auxHeader))) {
							groupB.add(entry1);
							groupB.add(entry2);
							break;
						}
					}
				}
			}
			//If common column value is only found in record 1
			if(!existsInBothRecords) {
				groupA.add(entry1);
			}
		}
		System.out.println("Grouping A: " + groupA);
		System.out.println("Grouping B: " + groupB);

	}
}