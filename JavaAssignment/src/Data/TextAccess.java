package Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextAccess extends FileDataAccess implements Update {
    
     @Override
    public ArrayList<String> readAll() {
        ArrayList<String> list = new ArrayList<String>();
        
        try (Scanner scan = new Scanner(this.filename)) {
             while (scan.hasNextLine()) {
                String line = scan.nextLine();
                list.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
        
        
    
    
    @Override
    public boolean write(String record) {
        //PrintWriter
        try (PrintWriter out = new PrintWriter(new FileWriter(this.filename, true))) {
            out.println(record);//write to file
            //if 'write' is succeeded
            return true;
        } catch (IOException ex) {
            //any exception/error
            System.out.println("Error: Failed to write.");
            return false;
        }
    }
    
        
        
        /* retriebe from fileaccess
    public boolean write(String record){
        boolean success = false;
        this.setFileName("user.txt");
        File f = this.filename;
        ArrayList<String> data = null;
        
        if (f.exists()) {
            data = this.readAll();
        } else {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(TextAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            data = new ArrayList();
        }
        
        if (data != null) {
            data.add(record);
             try (PrintWriter out = new PrintWriter(new FileWriter(this.filename, true))) {
            out.println(record);//write to file
            //if 'write' is succeeded
            return true;
        } catch (IOException ex) {
            //any exception/error
            System.out.println("Error: Failed to write.");
        }
        }
    return false;
    }
    
*/
    public boolean write(ArrayList<String> data){
         try (PrintWriter out = new PrintWriter(new FileWriter(this.filename, true))) {
            out.println(data);//write to file
            //if 'write' is succeeded
            return true;
        } catch (IOException ex) {
            //any exception/error
            System.out.println("Error: Failed to write.");
            return false;
        }
    }      
    
    
    @Override
    public boolean update(String id, String newLine) {
        ArrayList<String> old_list = this.readAll();//existing content
        ArrayList<String> new_list = new ArrayList();
        //iterate each element in old_list
        for (String oldLine : old_list) {
            String[] split = oldLine.split("\\|");
            if (split[0].equals(id)) {
                String newRecordLine = String.join("|", id, newLine);
                new_list.add(newRecordLine);
            } else {
                new_list.add(oldLine);
            }
        }
        
        if(new_list.size() > 0){
            try(PrintWriter out = new PrintWriter(new FileWriter(filename))) {
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
    

    @Override
    public boolean read(String read) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args){
        TextAccess fa = new TextAccess();
        fa.setFileName("user.txt");
        ArrayList<String> content = fa.readAll();
        System.out.println( content );
    }

}

   
