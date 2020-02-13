public List<wordCount>(String s, int chars) {

  s = s + " ";
  char[] ch = s.toCharArray();
  List<wordCount> LineWC = new ArrayList<>();
  String newWord = "";
  int pos = 0;

  for(Character c: ch)  // go through each character to line
  {
      if(!Character.isWhitespace(c))  // if character is not a space then add character to newWord
          newWord = newWord + c;
      else if((Character.isWhitespace(c) || !Character.isAlphabetic(c)) && !newWord.isEmpty())  // if the character is a whitespace or 
          // a period comma etc. then that is the end of the word
      {
          if(!Character.isAlphabetic(newWord.charAt(newWord.length()-1)))  // check to see if last character on end of word is a comma or period etc
              newWord = newWord.substring(0, newWord.length()-1);

          pos = chars - newWord.length();
          newWord = newWord.toLowerCase();
          wordCount wc = new wordCount(newWord, pos);
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

public int search(List<wordCount> wc, String s) {
        
    for(wordCount w: wc) 
    {
        if(w.word.equals(s))
            return wc.indexOf(w);
    }

    return -1;
}

/////////////////////////////////// Test code
Scanner scnIn = new Scanner(System.in);
System.out.println("Enter your file path here:");
nF = scnIn.next();
File file = new File(nF);
Scanner scn = new Scanner(file);  // get file

while(scn.hasNextLine())      // add end line to each line
    all += (scn.nextLine() + "\n");

String[] t = all.split("\n"); // split each line by end line character
List<wordCount> wc = new ArrayList<>();
int c = 1;
for(String o: t)
{
    for(wordCount w: lineReader(o, c))    // get word count for each line then test it with current wc list
    {
        int aval = search(wc, w.word);
        if(aval != -1)
            wc.get(aval).positions.addAll(w.positions);
        else
            wc.add(w);
    }
    c += o.length();
}
