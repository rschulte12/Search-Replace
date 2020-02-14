//package searchreplace;

import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class replace {
	
	String sWord, rWord, fileName;
	Scanner userIn = new Scanner(System.in);
	
	
	public replace(String fileName) {
		this.fileName = fileName;
		System.out.println("Enter a word to search for: ");
		sWord = userIn.next();
		System.out.println("Enter a replacement word: ");
		rWord = userIn.next();
	
		File f=new File(fileName);
        
        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;
        
        StringBuffer sb = new StringBuffer();
        
        String textinLine;
        
        try {
             fs = new FileInputStream(f);
             in = new InputStreamReader(fs);
             br = new BufferedReader(in);
            
            while(true)
            {
                textinLine=br.readLine();
                if(textinLine==null)
                    break;
                sb.append(textinLine + "\n");
				try {
					while (true) {
						String textToEdit1 = sWord;
						int cnt1 = sb.indexOf(textToEdit1);
						sb.replace(cnt1,cnt1+textToEdit1.length(),rWord);
					}
				}
				catch (Exception e) {
					// Ignore this guy (Buddy Garrity voice)
				}
            }
			
              fs.close();
              in.close();
              br.close();

            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
            
            try{
                FileWriter fstream = new FileWriter(f);
                BufferedWriter outobj = new BufferedWriter(fstream);
                outobj.write(sb.toString());
                outobj.close();
                
            }catch (Exception e){
              System.err.println("Error: " + e.getMessage());
            }
	}
}
	
	
	
	
	
	
	
	
	/* private String sWord, rWord;
	private Scanner userIn = new Scanner(System.in);
	
	
	public replace(wordcount) {
		System.out.println("Enter a word to search for: ");
		sWord = userIn.next();
		
		if (find(sWord)) {
			System.out.println("Enter a replacement word: ");
			rWord = userIn.next();
			
			
			
			
			
			
			
		}
		else {
			System.out.println("That word doesn't exist in the file.");
		}
	}
	
	public boolean find(String sWord) { // Returns true if sWord exists in the wordcount list, false if it doesn't
		
		for (String foundWord : wc) { // For each word in the wordcount list
			if (foundWord.equals(sWord)) { // Compare the list word to the searched word
				return true; // Return true if a match is found
			}
		}
		return false; // Return false if a match was never found
	}
	
	
	 */
	
	
	
	
	// Main program passes in file name, word to search, and word to replace with
	// Has method that determines if the file or word exists
	// Has method that replaces the words and creates in file object
	// Has method that writes the file object to an external text file the replace the original file
	
	// values: wordcount, sWord, rWord, 
	// methods: overWrite
