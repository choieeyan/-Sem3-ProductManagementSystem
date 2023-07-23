package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserCheck extends TextAccess{
    

    public UserCheck() {
    }
    
    public String checking(String username, String password) { 
        String sRole = null; 
        int i = 0;
        TextAccess TA = new TextAccess();
        TA.setFileName("user.txt");
        ArrayList<String> data = TA.readAll();
        
        for (int counter = 0; counter < data.size(); counter ++){
            String[] split = data.get(counter).split("\\|");
            if (split[2].equals(username) && split[3].equals(password)) {
                if (split[6].equals("Administrator")){
                    sRole = "Administrator";
                }else{
                    sRole = "Product Manager";
                }
            }else{
                continue;
            }
        }
        return sRole;
    }
    
    public boolean checkUser(String username) throws FileNotFoundException, IOException{
        TextAccess TA = new TextAccess();
        TA.setFileName("user.txt");
        boolean success = false; 
        ArrayList<String> data = null;
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("user.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\|");
            if (split[2].equals(username)) {
                success = true;
                break;
            } else {
                line = br.readLine();
                data.add(line);
            }
        }
        br.close();
        return success;
    }
}

