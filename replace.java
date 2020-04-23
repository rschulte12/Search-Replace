package searchreplace;

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

// class replace is the subject class of the observer. 
//This class handles the observes and also changes the file if user wants to
class replace {
	
	String sWord, rWord, fileName;
	Scanner userIn = new Scanner(System.in);
        List<Observer> o = new ArrayList<>();
        private int State;
        
        public void replaceWord() {
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
        
        public void register(List<Observer> o) {
            this.o.addAll(o);
        }
        
        public void notifyObservers() throws FileNotFoundException {
            for(Observer o: this.o)
                o.update(fileName);
        }
        
        public void setState(int state, String file) throws FileNotFoundException{
            this.State = state;
            this.fileName = file;
            if(State == 0)
            {
                System.out.println("\n\nCurrent State: Finding file statistics....");
                notifyObservers();
            }
            else if(State == 1)
            {
                System.out.println("\n\nCurrent State: replacing word...");
                replaceWord();
            }
            else
                System.out.println("\n\nCurrent State: exiting program...");
        }
}
	
	
	
	
	// Main program passes in file name, word to search, and word to replace with
	// Has method that determines if the file or word exists
	// Has method that replaces the words and creates in file object
	// Has method that writes the file object to an external text file the replace the original file
	
	// values: wordcount, sWord, rWord, 
	// methods: overWrite
