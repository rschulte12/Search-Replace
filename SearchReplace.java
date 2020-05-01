import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class SearchReplace {
    public static void main(String[] args) throws FileNotFoundException {
        String file;
        int choice = 0;
        Scanner userIn = new Scanner(System.in);
        List<Observer> observers = new ArrayList<>();
        Observer wc = new wordcount();
        Observer fs = new fileStats();
        observers.add(fs);
        observers.add(wc);
        replace NR = new replace();
        NR.registerObservers(observers);
        while (true) {
            System.out.println("\nEnter name of the file: ");
            file = userIn.next();

            while(choice != 2)
            {
                System.out.println("\n\nChoose an operation: (0, 1, 2) \nShow File statistics [0]\nSearch and replace a word [1]\nExit [2]");
                choice = userIn.nextInt();
                NR.setState(choice, file);
            }
            return;
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

