import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class wordcount extends Observer{
    String word;
    Set<Integer> positions = new HashSet<>();
    String file;

    public wordcount() {
    }
    public wordcount(String w, int p) {
        word = w;
        positions.add(p);
    }

    public List<wordcount> getWords() throws FileNotFoundException {
        File file = new File(this.file);
        Scanner scn = new Scanner(file);
        try {
            scn = new Scanner(file);
        }
        catch ( FileNotFoundException e ) {
            System.out.println("File not found");
        }
        String all = "";

        while(scn.hasNextLine())      // add end line to each line
            all += (scn.nextLine() + "\n");

        String[] t = all.split("\n"); // split each line by end line character

        List<wordcount> wc = new ArrayList<>();
        int c = 1;
        for(String o: t)
        {
            for(wordcount w: lineReader(o, c))    // get word count for each line then test it with current wc list
            {
                int aval = search(wc, w.word);
                if(aval != -1)
                    wc.get(aval).positions.addAll(w.positions);
                else
                    wc.add(w);
            }
            c += o.length();
        }

        return wc;
    }

    public List<wordcount> lineReader(String s, int chars) { // List for storing strings and location

      s = s + " "; // Put a space at the end of s
      char[] ch = s.toCharArray(); // Save s as a character array in ch
      List<wordcount> LineWC = new ArrayList<>(); // Create new array list
      String newWord = ""; // Create empty string called newWord to store a word
      int pos = 0; // Create int start at 0

      for(Character c: ch)  // go through each character to line
      {
          if(!Character.isWhitespace(c))  // if character is not a space then add character to newWord
              newWord = newWord + c; // Add character c in ch to newWord
          else if((Character.isWhitespace(c) || !Character.isAlphabetic(c)) && !newWord.isEmpty())  // if the character is a whitespace or 
              // a period comma etc. then that is the end of the word
          {
              if(!Character.isAlphabetic(newWord.charAt(newWord.length()-1)))  // check to see if last character on end of word is a comma or period etc
                  newWord = newWord.substring(0, newWord.length()-1); // Shorten newWord so it doesn't include the comma or period

              pos = chars - newWord.length(); // Store the starting position of the word
              newWord = newWord.toLowerCase(); // Convert the word to lower case
              wordcount wc = new wordcount(newWord, pos); // Create a new wordcount and pass newWord and the position to the constructor
              int aval = search(LineWC, newWord);       // check if same word has already been added to line list
              if(aval != -1)
                  LineWC.get(aval).positions.add(pos);
              else
                  LineWC.add(wc);

              newWord = ""; // reset word
          }
          else    // in case other two ifs fail just delete current word
              newWord = "";

          chars++;
      }

      return LineWC;
    }

    public int search(List<wordcount> wc, String s) {

        for(wordcount w: wc) 
        {
            if(w.word.equals(s))
                return wc.indexOf(w);
        }

        return -1;
    }

    public void print(wordcount wc) throws FileNotFoundException {
        List<wordcount> wordC = wc.getWords();
        System.out.println("WORD COUNT OF FILE:");

        for(wordcount w: wordC) 
        {
            System.out.print("\nWord: " + w.word + "\nCharacter locations: ");
            for(int i: w.positions)
            {
                System.out.print(i + " ");
            }
        }
    }

    public void update(String file) throws FileNotFoundException {
        this.file = file;
        this.print(this);
    }
}
