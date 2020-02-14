public class wordCount {
    String word;
    Set<Integer> positions = new HashSet<>();
    
    public wordCount(String w, int p) {
        word = w;
        positions.add(p);
    }
}
