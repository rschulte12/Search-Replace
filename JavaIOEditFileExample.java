import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaIOEditFileExample {

    public static void main(String[] args) {
        
        File f=new File("appendOldFile.txt");
        
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
						String textToEdit1 = "abc";
						int cnt1 = sb.indexOf(textToEdit1);
						sb.replace(cnt1,cnt1+textToEdit1.length(),"REPLACED");
					}
				}
				catch (Exception e) {
				}
            }
              

              fs.close();
              in.close();
              br.close();

            } catch (FileNotFoundException e) {
              //e.printStackTrace();
            } catch (IOException e) {
              //e.printStackTrace();
            }
            
            try{
                FileWriter fstream = new FileWriter(f);
                BufferedWriter outobj = new BufferedWriter(fstream);
                outobj.write(sb.toString());
                outobj.close();
                
            }catch (Exception e){
              //System.err.println("Error: " + e.getMessage());
            }

    }
}