import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveLoad
{
    static int a = 0;
    int b = 3;
    
    public static void loadFromSaveFile(String fromFile) throws IOException{
        CreateArrayFromFile c = new CreateArrayFromFile(fromFile);
        c.fillWithoutMax();

        String load = "";
        for(int i = 0; i < c.file.length; i++){
            load += c.file[i];
        }
        ArrayList<String> loader = new ArrayList<String>();
        for(int i = 0; i < load.length(); i++){
            String s = load.substring(i, i+1);
                loader.add(s);
        }
        for(int i = 0; i < loader.size(); i++){
            a = Integer.parseInt(loader.get(i));
        }
    }
    
    public static void saveToFile(String toFile) throws IOException{
        File out = new File(toFile);
        FileOutputStream fos = new FileOutputStream(out);
        
        String saveInfo = "";
        for(int i = 0; i < 10; i++){
            saveInfo += i+"!@";
        }
        
        byte[] bytesArray = saveInfo.getBytes();
        fos.write(bytesArray);
        fos.close();
    }
}
