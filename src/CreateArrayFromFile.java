import java.io.*;
import java.util.*;
 
public class CreateArrayFromFile
{
    private String fileName;
    public String[] file;
    int length = 0;
    
    public CreateArrayFromFile(String path) throws IOException{
        fileName = path;
        file = new String[countLines()];
    }
    
    public void fill(int a) throws IOException{
        length = a;
        int i = 0;
        File input = new File(fileName);
        Scanner s = new Scanner(input);
        
        while(s.hasNextLine() && i <= (a-1)){
            file[i] = s.nextLine();
            i++;
        }
        s.close();
    }
    
    public void fillWithoutMax() throws IOException{
        int i = 0;
        File input = new File(fileName);
        Scanner s = new Scanner(input);
        
        while(s.hasNextLine()){
            file[i] = s.nextLine();
            i++;
        }
        s.close();
    }
    
    private int countLines() throws IOException{
        int count = 0;
        File input = new File(fileName);
        Scanner s = new Scanner(input);
        
        while(s.hasNextLine()){
            count++;
        }
        s.close();
        return count;
    }
    
    public String[] getArray(){
        for(int i = 0; i < length; i++){
            //System.out.println(file[i]);
        }
        return file;
    }                                                                                                                                                                        
}
