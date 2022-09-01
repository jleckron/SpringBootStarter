package com.example.inputreader;

import java.util.HashSet;


public class DifferenceFinder {
	
	public String[] changedEntries, newEntries;
	
	HashSet<String> file1Contents = new HashSet<String>();
	HashSet<String> file2Contents = new HashSet<String>();
	
	public DifferenceFinder(InputReader file1, InputReader file2) {
		for(String line : file1.fileLineEntries) this.file1Contents.add(line);
		for(String line : file2.fileLineEntries) this.file2Contents.add(line);
	}
	
	public void findChanges() {
		System.out.println("File 1: " + this.file1Contents);
		System.out.println("File 2: " + this.file2Contents);
		for(String line : this.file1Contents) {
			this.file2Contents.remove(line);
		}
		System.out.println("Changes: " + this.file2Contents);
	}
	
	public void findAdditions() {
		
	}
}