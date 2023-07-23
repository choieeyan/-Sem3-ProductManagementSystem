package javaassignment;

import java.util.ArrayList;
import java.util.List;
import javaassignment.Product;

public class ProductManager extends User {
    
    private List<Product> Productlist;
    
    public ProductManager() {
        this.Productlist =  new ArrayList<>();
    }
    
    public int addProduct(Product p){
        this.Productlist.add(p);
        return this.Productlist.size();
    }
    
    public int count(){
        return this.Productlist.size();
    }
    
    public Product getProduct(int index){
        if(index < 0 || index >= count()){
            return null;
        }
    return this.Productlist.get(index);
}
    
    public boolean removeProduct(int pID){
        int index = -1;
        int i;
        int n;
        for (i = 0, n = count(); i<n; i++){
            if(this.Productlist.get(i).getpID() == pID);{
            index = i;
            break;
        }
    }
    if(index != -1){
        this.Productlist.remove(index);
        return true;
    }
    return false;
    }



    
public ProductManager(String ID, String Name, String Username, String Email, String Address, String Password, Role role) {
        super(ID, Name, Username, Email, Address, Password, role);
    
       
    
    }
}