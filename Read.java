package read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Read {
	
static FileWriter myWriter;

	public static void main(String[] args) {
		
		createFile();
		System.out.println();
		writeFile();
		System.out.println();
		readFile();
		System.out.println();
		justThreeLines();
		System.out.println();
		readPlainText();
	}

	static void createFile()	{
		String filePath = "C:\\Users\\User\\Desktop\\BootCamp\\4th_Day.txt";
		File file = new File(filePath);
		try {
			if (file.exists() == false) {
				file.createNewFile();
				System.out.println("File created successfully.");
			} else {
				System.out.println("The file already exists on your PC.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem creating file.");
		}
	}
	
	static void writeFile() {
		BufferedReader br = null;
		try {
			String path = "C:\\Users\\User\\Desktop\\BootCamp\\4th_Day.txt";
			boolean append = false;
			FileWriter myWriter = new FileWriter(path, append);			
			myWriter.write("\nWe are running out of time. Hurry up! :)");
			System.out.println("Writing done!");
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("1) Problem writing to file.");
		}
	}
	
	static void readFile() {
		BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader( new FileReader("C:\\Users\\User\\Desktop\\BootCamp\\4th_Day.txt"));
            while( (strLine = br.readLine()) != null){
                System.out.println(strLine);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
	}
	
	static void readPlainText() {
		 StringBuilder sb = new StringBuilder();
	        String strLine = "";
	        String name = "";
	        ArrayList<String> allNames = new ArrayList<String>();
	        try {
	             BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\people.txt"));
	             while (strLine != null) { // doesn't work, throws NPE.....
	                sb.append(strLine);
	                sb.append(System.lineSeparator());
	                strLine = br.readLine();
	                String names [] = strLine.split(" ");
	                name = names [0];
	                allNames.add(name);
	                System.out.println(strLine);
	                System.out.println(name + " ");
	            }
	             System.out.println(allNames);
	             br.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }
	}
	
	static void justThreeLines() {
		BufferedReader br = null;
		String strLine = "";
	        try {             
	             LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream("C:\\Users\\User\\Desktop\\people.txt"), "UTF-8"));
	             while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= 3){
	                System.out.println(strLine);
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }
	}
}
