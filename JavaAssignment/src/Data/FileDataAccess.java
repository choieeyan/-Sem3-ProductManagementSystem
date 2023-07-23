package Data;

import java.io.File;
import java.util.ArrayList;

public abstract class FileDataAccess {
    public File filename;
    
    public void setFileName(String fn) {
        this.filename = new File(fn);
    }
    
         
    public abstract ArrayList<String> readAll();
        
    public abstract boolean write(String record);
    
    public abstract boolean read(String read);
    
    
}
