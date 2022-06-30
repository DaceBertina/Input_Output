package input_output;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		
		readDir();
		getFilesByExtension();
		checkPermissions();
		checkFileVsDir();
		compareFiles();
		getLastModTime();
		readFromConsole();
		getFileSizeInBytes();
		contBytesArray();
	}
	
	static void readDir()	{
		File file = new File("C:\\Users\\User\\Desktop\\JAVA_2_sem\\");
   
		try {
			if (file.exists() == false) {
				System.out.println("Directory not found.");
				return;
			} 	
			String[] fileList = file.list();
	        for(String name:fileList){
	            System.out.println(name);
	        }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading directory.");
		}
	}

	static void getFilesByExtension()	{
		File file = new File("C:\\Users\\User\\Desktop\\Python\\");
   
		try {
			if (file.exists() == false) {
				System.out.println("Directory not found.");
				return;
			} 	
			String[] list = file.list(new FilenameFilter() {
		           @Override
		            public boolean accept(File dir, String name) {
		             if(name.toLowerCase().endsWith(".py")){
		                    return true;
		                } else {
		                    return false;
		                }
		            }
		        });
		        for(String f:list){
		            System.out.println(f);
		        }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading directory.");
		}
	}
	
	static void checkPermissions()	{
		File file = new File("C:\\Users\\User\\Desktop\\JAVA_2_sem\\");
   
		try {
			if (file.exists() == false) {
				System.out.println("Directory not found.");
				return;
			} 	
			if (file.canWrite()) 
	           {
	            System.out.println(file.getAbsolutePath() + " can write.\n");
	           } 
	         else
	          {
	            System.out.println(file.getAbsolutePath() + " cannot write.\n");
	          }
	         if (file.canRead()) 
	           {
	            System.out.println(file.getAbsolutePath() + " can read.\n");
	           } 
	         else
	          {
	            System.out.println(file.getAbsolutePath() + " cannot read.\n");
	          }  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem checking permissions.");
		}
	}
	
	static void checkFileVsDir()	{
		File file = new File("C:\\Users\\User\\Desktop\\JAVA_2_sem\\");
   
		try {
			if (file.exists() == false) {
				System.out.println("Directory not found.");
				return;
			} 	
			if (file.isDirectory()) 
	           {
	            System.out.println(file.getAbsolutePath() + " is a directory.\n");
	           } 
	         else
	          {
	            System.out.println(file.getAbsolutePath() + " is not a directory.\n");
	          }
	         if (file.isFile()) 
	           {
	            System.out.println(file.getAbsolutePath() + " is a file.\n");
	           } 
	         else
	          {
	            System.out.println(file.getAbsolutePath() + " is not a file.\n");
	          }  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem checking File vs Directory.");
		}
	}
	
	static void compareFiles()	{
		
		String file1 = "mbox";
	    String file2 = "mbox-short";
	    String file3 = "DB_Script";

	    int comp1 = file1.compareTo(file2);
	    System.out.println("file1 & file2 comparison: "+ comp1);

	    int comp2 = file1.compareTo(file3);
	    System.out.println("file1 & file3 comparison: "+ comp2);
	}
	
	static void getLastModTime()	{
		File file = new File("C:\\Users\\User\\Desktop\\Family\\Person.java");
   
		try {
			if (file.exists() == false) {
				System.out.println("File not found.");
				return;
			} 	
			Date date=new Date(file.lastModified());
			   System.out.println("\nThe file was last modified on: "+date+"\n");	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading file.");
		}
	}
	
	static void readFromConsole()	{
		try {
			 BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
			    System.out.print("Input your name: ");
			    String name = R.readLine();
			    System.out.println("Your name is: " + name);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading console.");
		}
	}
	
	static void getFileSizeInBytes()	{
		File file = new File("C:\\Users\\User\\Desktop\\Family\\Person.java");
   
		try {
			if (file.exists() == false) {
				System.out.println("File not found.");
				return;
			} 	
			System.out.println(filesize_in_Bytes(file));
	        System.out.println(filesize_in_kiloBytes(file));
	        System.out.println(filesize_in_megaBytes(file));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading file.");
		}
	}
	
	 private static String filesize_in_megaBytes(File file) {
	        return (double) file.length()/(1024*1024)+" mb";
	    }
	 
	    private static String filesize_in_kiloBytes(File file) {
	        return (double) file.length()/1024+"  kb";
	    }
	 
	    private static String filesize_in_Bytes(File file) {
	        return file.length()+" bytes";
	    }
	
	static void contBytesArray()	{
			
			InputStream fins = null;
			try {
				File file = new File("C:\\Users\\User\\Desktop\\Family\\Main.java");
				if (file.exists() == false) {
					System.out.println("File not found.");
					return;
				} 
				fins = new FileInputStream(file);
	            byte file_content[] = new byte[2*1024];
	            int read_count = 0;
	            while((read_count = fins.read(file_content)) > 0){
	                System.out.println(new String(file_content, 0, read_count-1));
	            }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try{
	                if(fins != null) fins.close();
	            } catch(Exception ex){
	            }     
	        }
	  }
}

