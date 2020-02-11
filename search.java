public List<wordCount>(String s, int chars) {

  s = s + " ";
  char[] ch = s.toCharArray();
  List<wordCount> LineWC = new ArrayList<>();
  String newWord = "";
  int pos = 0;

  for(Character c: ch)
  {
      if(!Character.isWhitespace(c))
          newWord = newWord + c;
      else if(Character.isWhitespace(c) || !Character.isAlphabetic(c) && !newWord.isEmpty())
      {
          if(!Character.isAlphabetic(newWord.charAt(newWord.length()-1))) 
              newWord = newWord.substring(0, newWord.length()-1);

          pos = chars - newWord.length();
          newWord = newWord.toLowerCase();
          wordCount wc = new wordCount(newWord, pos);
          int aval = search(LineWC, newWord);
          if(aval != -1)
              LineWC.get(aval).positions.add(pos);
          else
              LineWC.add(wc);

          newWord = "";
      }
      else
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
