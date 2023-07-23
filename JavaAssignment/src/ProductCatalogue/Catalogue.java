package ProductCatalogue;

import Data.FileAccess;
import Data.TextAccess;
import Util.Function;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Catalogue implements FileAccess{  

    protected String cID, cName, cDescription, cTheme;

    public Catalogue() {
    }

     public Catalogue(String cID, String cName, String cDescription,String cTheme){
        this.cID = cID;
        this.cName = cName;
        this.cDescription =cDescription;
        this.cTheme = cTheme;
     }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public String getcTheme() {
        return cTheme;
    }

    public void setcTheme(String cTheme) {
        this.cTheme = cTheme;
    }

    
    @Override
    public String create() { 
        
        TextAccess FA = new TextAccess(); 
        FA.setFileName("catalogue.txt");          
        ArrayList<String> record = FA.readAll();
        for (int counter = 0; counter < record.size(); counter ++){
            String[] split = record.get(counter).split("\\|");
            Long autoID = Function.generateUniqueId();
            if(split[0].equals(Long.toString(autoID))) {
                continue;
            }else{
                cID = Long.toString(autoID);
                break;
            }
        }
        
        String data = String.join("|",
                cID, cName, cDescription, cTheme);
        boolean ok = FA.write(data);
        if (ok) {
            return cID;
        } else {
            return null;
        } 
    }

    @Override
    public boolean remove(String id) {
        TextAccess FA = new TextAccess(); 
        FA.setFileName("catalogue.txt");    
        ArrayList<String> old_list = FA.readAll();//existing content
        ArrayList<String> new_list = new ArrayList();
        //iterate each element in old_list
        for (String oldLine : old_list) {
            String[] split = oldLine.split("\\|");
            if (!split[0].equals(id)) { 
                new_list.add(oldLine); //keep the content that is not matching with the id
            }
        }
        //write the new_list element to the file
        if(new_list.size() > 0){
            try(PrintWriter out = new PrintWriter(new FileWriter("catalogue.txt", false))) {
                for (String line : new_list) {
                    out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }        
    
    
    public static void main(String[] args){
        Catalogue ca = new Catalogue(); 
        ca.create();
 
        
    }
 
}
   

            
               
            
     