
import java.util.Scanner;

public class SearchReplace {
	public static void main(String[] args) {
		String file, sWord, rWord;
		int choice = 2;
		Scanner userIn = new Scanner(System.in);
		System.out.println("Enter name of the file: ");
		file = userIn.next();
		
		System.out.println("Choose an operation: (0 or 1) \nShow word count [0]\nSearch and replace a word [1]");
		choice = userIn.nextInt();
		wordcount newWC = new wordcount(file); // ** Process the file to get all the word counts
		
		if (choice == 0) {
			newWC.print(newC); // ** Print out the word counts to screen
		}
		else if (choice == 1) {
			
			
			
			replace newReplace = replace(newWC); // create new replace object for replace operations
																// constructor displays the number of times the search word is in the file
			newReplace.overWrite(rWord);
		
		}
		else {
			
		}
		
		
		// * Ask the user for file name
		// * Ask user if they want to see word count or perform search and replace
		// Word count use case parses file using empty spaces (space, tab, etc.) as delimiters
		// Word count then displays each unique word followed by its count. Sorted most used to least used words.
		// Search and replace asks the user what word to search for
		// Search and replace performs a silent word count (to populate location arrays)
		// Search and replace displays the number of times the searched word appears in the file
		// Search and replace asks the user what they want to replace the word with
		// Search and replace goes to the last known location first to start the replacements and continues backward (so the location values don't have to change)
	}
}

