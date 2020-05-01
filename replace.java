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
	
	String SearchWord, ReplaceWord, FileName;
	Scanner UserInput = new Scanner(System.in);
        List<Observer> ObserverList = new ArrayList<>();
        private int State;
        
        public void replaceWord() {
            System.out.println("Enter a word to search for: ");
            SearchWord = UserInput.next();
            System.out.println("Enter a replacement word: ");
            ReplaceWord = UserInput.next();

            File TextFile = new File(FileName);
        
            FileInputStream TextFileStream = null;
            InputStreamReader FileStreamReader = null;
            BufferedReader ReaderBuffer = null;
            StringBuffer FileStringBuffer = new StringBuffer();
            String LineString;
        
            try {
             TextFileStream = new FileInputStream(TextFile);
             FileStreamReader = new InputStreamReader(TextFileStream);
             ReaderBuffer = new BufferedReader(FileStreamReader);
            
            while(true)
            {
                LineString = ReaderBuffer.readLine();
                if(LineString == null)
                    break;
                FileStringBuffer.append(LineString + "\n");
				try {
					while (true) {
						String _old = SearchWord;
						int _counter = FileStringBuffer.indexOf(_old);
						FileStringBuffer.replace(_counter,_counter+_old.length(),ReplaceWord);
					}
				}
				catch (Exception e) {
				}
            }
			
              TextFileStream.close();
              FileStreamReader.close();
              ReaderBuffer.close();

            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
            
            try{
                FileWriter TextFileWriter = new FileWriter(TextFile);
                BufferedWriter FileWriterBuffer = new BufferedWriter(TextFileWriter);
                FileWriterBuffer.write(FileStringBuffer.toString());
                FileWriterBuffer.close();
                
            }catch (Exception e){
              System.err.println("Error: " + e.getMessage());
            }
        }
        
        public void registerObservers(List<Observer> ObserverList) {
            this.ObserverList.addAll(ObserverList);
        }
        
        public void notifyObservers() throws FileNotFoundException {
            for(Observer _observer: this.ObserverList)
                _observer.update(FileName);
        }
        
        public void setState(int StateInt, String TextFileName) throws FileNotFoundException{
            this.State = StateInt;
            this.FileName = TextFileName;
            if(this.State == 0)
            {
                System.out.println("\n\nCurrent State: Finding file statistics....");
                notifyObservers();
            }
            else if(this.State == 1)
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
	
	// values: wordcount, SearchWord, ReplaceWord, 
	// methods: overWrite
