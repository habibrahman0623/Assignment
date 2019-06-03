package bfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	public List<List<Integer>> myList;
	private Scanner input;
	private String filePath;
	
	public FileReader(String path) {
		// TODO Auto-generated constructor stub
		filePath = path;
		myList = new ArrayList<>();
		
	}
	
	public void openFile(){
		
		try {
			input = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println( "Error opening file." );
	        System.exit( 1 );
		}
	}
	
	public List<List<Integer>> readFile(){
		
		try {
			while(input.hasNextLine()){
				
				List<Integer> perLineInput = new ArrayList<>();
				String line = input.nextLine();
				String[] strings = line.split("\t");
				for (String string : strings) {
					
					perLineInput.add(Integer.parseInt(string));
					
				}
				myList.add(perLineInput);
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myList;
	}
	
	public void closeFile()
	   {
	      if ( input != null )
	         input.close();
	   } 

}
