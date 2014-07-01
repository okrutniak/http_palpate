package nauka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFilesFromFolder {
  public static File folder = new File("D:/praca/repa");
   static String temp = "defaultVars";
  static String field = "http";
  

   static String urlFile = "";
  
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
    listFilesForFolder(folder);
    //findPaternInFiles("D:/praca/repa/AdapterNIP_AA1_root/defaultVars/EAI/JMS/defaultVars.substvar","adnip");
    
  }

  public static void listFilesForFolder(final File folder) {

    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
         System.out.println("Reading files under the folder "+folder.getAbsolutePath());
        listFilesForFolder(fileEntry);
      } else {
        if (fileEntry.isFile()) {
          temp = fileEntry.getName();
          System.out.println("Wartosc temp: " + temp);
          		if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("substvar"))
          		 urlFile = folder.getAbsolutePath();
		 System.out.println("Wartosc urlFile: " + urlFile);
			System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
        	 if ( findPaternInFiles(temp,"adnip") != null) {
        		  System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
        	  }
            
        }

      }
    }
  }
  
  public static String findPaternInFiles (final String pattern, String pattern2) {
	  File file = new File(pattern);
	  Scanner scanner = null;
	try {
		scanner = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String foundString = scanner.findWithinHorizon(pattern2,0);
	  if (foundString != null ){
		  System.out.println(foundString);
		  
	  }else{
		  System.out.println("Nie odnalazlem patternu: " + pattern2);
	  }
	  scanner.close();
	return foundString;
	  
  }
  
}