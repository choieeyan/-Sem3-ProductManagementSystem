package javaassignment;

import Data.FileAccess;
import Data.TextAccess;
import java.util.ArrayList;
import Util.Function;
import java.io.FileWriter;
import java.io.PrintWriter;

public class User implements FileAccess{
    
    protected TextAccess TA;
    protected String ID, Name, Address, Email, Role, Username, Password;
    protected Role role;

    
    public void setID(String id) {
        this.ID = id;
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public void setAddress(String address) {
        this.Address = address;
    }
    
    public void setEmail(String email) {
        this.Email = email;
    }
    
    public void setRole(String role) {
        this.Role = role;
    }
    
    public void setUsername(String username) {
        this.Username = username;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public User() {
        TA = new TextAccess();
        TA.setFileName("user.txt");
    }
    
    public User(String id, String name, String username, String email, String address,String password, Role role) {
        this.ID = id;
        this.Name = name;
        this.Username = username;
        this.Email = email;
        this.Address = address;
        this.role = role;
        this.Password = password;
    }
    
    public boolean login() {
        boolean success = false;
        ArrayList<String> data = TA.readAll();
        for (String record : data) {
            String[] split = record.split("\\|");
            if (split[2].equals(Username)
                    && split[6].equals(Password)) {
                success = true;
                break;
            }
        }
        return success;
    }
    
    @Override
    public String create() {
        
        Long id = Function.generateUniqueId();
        String userid = Long.toString(id);

        String record = String.join("|",
                 userid,Name, Username, Password, Email, Address, Role);
        boolean ok = TA.write(record);
        System.out.println(ok);
        if (ok) {
            return userid;
        } else {
            return null;
        }

    }
    
    public String create(String username){
        
        TextAccess FA = new TextAccess();
        ArrayList<String> data = FA.readAll();
        boolean success = false;
        
        for (int counter = 0; counter < data.size(); counter ++){
            String[] split = data.get(counter).split("\\|");
            if (split[2].equals(Username)) {
                success = true;
            }else{
                continue;
            }
        }
        return null;
    }        
    
  
    
    //remove function for text access
    @Override
    public boolean remove(String id) {
        //remove the content
        ArrayList<String> old_list = TA.readAll();//existing content
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
            try(PrintWriter out = new PrintWriter(new FileWriter("user.txt", false))) {
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
        User obj = new User();
        obj.remove("1206708305172447880");
        
    }
    
}
