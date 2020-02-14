//package searchreplace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;


public class SearchReplace {
	public static void main(String[] args) throws FileNotFoundException {
		String file, sWord, rWord;
		int choice = 2;
		Scanner userIn = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nEnter name of the file: ");
			file = userIn.next();
		
			System.out.println("Choose an operation: (0, 1, 2) \nShow word count [0]\nSearch and replace a word [1]\nExit [2]");
			choice = userIn.nextInt();
			wordcount newWC = new wordcount(file); // ** Process the file to get all the word counts
		
			if (choice == 0) {
				newWC.print(newWC);
				//List<wordcount> WC.addall(newWC.print(newC)); // ** Print out the word counts to screen
			}
			else if (choice == 1) {
				replace newReplace = new replace(file); // create new replace object 
			}
			else {
				break;
			}
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

