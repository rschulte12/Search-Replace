import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class fileStats extends Observer {
    int charCount;
    int wordCount;
    int lines;
    String file;
    
    public void getLines() throws FileNotFoundException {
        File file = new File(this.file);
        charCount = 0;
        wordCount = 0;
        lines = 0;
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
        for(String s: t)
        {
            lines++;
            char[] ch = s.toCharArray();
            for(int i = 0; i < ch.length; i++)
            {

                charCount++;
                if(Character.isSpaceChar(ch[i]))
                    wordCount++;
                if(i == (ch.length - 1))
                    wordCount++;
            }
        }
    }

    public void print(fileStats FS) throws FileNotFoundException {
        FS.getLines();
        System.out.println("FILE STATS:");
        System.out.println("\nCharacter count = " + FS.charCount + 
                "\nWord count = " + FS.wordCount + "\nLines = " + lines);
    }

    public void update(String file) throws FileNotFoundException {
        this.file = file;
        this.print(this);
    }
}
